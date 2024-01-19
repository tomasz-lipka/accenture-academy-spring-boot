package com.accenture.academy.parish;

import com.accenture.academy.church.ChurchDao;
import com.accenture.academy.leader.LeaderDao;
import com.accenture.academy.member.MemberDao;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

import static jakarta.persistence.GenerationType.AUTO;

@Entity
@Data
@Table(name = "PARISH")
class ParishDao {

    @Id
    @GeneratedValue(strategy = AUTO)
    private long id;
    @OneToOne
    private LeaderDao leaderDao;
    @OneToOne
    private ChurchDao churchDao;
    @OneToMany
    @JoinColumn(name="PARISH_ID")
    private Set<MemberDao> members;
}
