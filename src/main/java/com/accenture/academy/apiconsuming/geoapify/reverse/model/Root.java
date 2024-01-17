package com.accenture.academy.apiconsuming.geoapify.reverse.model;

import lombok.Data;
import java.util.ArrayList;

@Data
public class Root{
    private String type;
    private ArrayList<Feature> features;
    private Query query;
}

