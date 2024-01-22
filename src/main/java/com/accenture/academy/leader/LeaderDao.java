package com.accenture.academy.leader;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import static jakarta.persistence.GenerationType.*;

@Entity
@Data
@NoArgsConstructor
@Table(name = "LEADER")
public class LeaderDao {

    @Id
    @GeneratedValue(strategy = AUTO)
    private Long id;
    @Column(name = "LAST_NAME")
    private String name;
    @Transient
    private Integer age;

    @Embedded
    private Location location;

    public LeaderDao(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
}

