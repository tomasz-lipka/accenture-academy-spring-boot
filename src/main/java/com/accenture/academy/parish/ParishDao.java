package com.accenture.academy.parish;

import com.accenture.academy.church.ChurchDao;
import com.accenture.academy.leader.LeaderDao;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;

import static jakarta.persistence.GenerationType.AUTO;

@Entity
@Data
class ParishDao {

    @Id
    @GeneratedValue(strategy = AUTO)
    private long id;
    @OneToOne
    private LeaderDao leaderDao;
    @OneToOne
    private ChurchDao churchDao;
}
