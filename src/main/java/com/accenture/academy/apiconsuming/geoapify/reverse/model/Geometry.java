package com.accenture.academy.apiconsuming.geoapify.reverse.model;

import lombok.Data;

import java.util.ArrayList;

@Data
public class Geometry {
    private String type;
    private ArrayList<Double> coordinates;
}
