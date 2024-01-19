package com.accenture.academy.leader;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

import static jakarta.persistence.GenerationType.*;

@Entity
@Data
@NoArgsConstructor
@Table(name = "PRIEST")
public class LeaderDao {

    @Id
    @GeneratedValue(strategy = AUTO)
    private Long id;
    private String name;
    private Integer age;

    public LeaderDao(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
}

