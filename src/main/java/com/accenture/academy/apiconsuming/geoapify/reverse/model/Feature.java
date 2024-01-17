package com.accenture.academy.apiconsuming.geoapify.reverse.model;

import lombok.Data;

import java.util.ArrayList;

@Data
public class Feature {
    private String type;
    private Properties properties;
    private Geometry geometry;
    private ArrayList<Double> bbox;
}
