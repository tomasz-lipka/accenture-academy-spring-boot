package com.accenture.academy.apiconsuming.geoapify.reverse.model;

import lombok.Data;

import java.util.ArrayList;

@Data
public class Feature {
    public String type;
    public Properties properties;
    public Geometry geometry;
    public ArrayList<Double> bbox;
}
