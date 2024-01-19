package com.accenture.academy.church;

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
@Table(name = "CHURCH")
public class ChurchDao {

    @Id
    @GeneratedValue(strategy = AUTO)
    private Long id;
    private String name;
    private String nameOfCity;
    private Integer numberOfSeats;
    private Integer numberOfMembers;
    private Double budget;

    ChurchDao(String name, String nameOfCity, Integer numberOfSeats, Integer numberOfMembers, Double budget) {
        this.name = name;
        this.nameOfCity = nameOfCity;
        this.numberOfSeats = numberOfSeats;
        this.numberOfMembers = numberOfMembers;
        this.budget = budget;
    }
}

