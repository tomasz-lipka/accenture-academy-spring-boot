package com.accenture.academy.apiconsuming.geoapify.reverse.model;

import lombok.Data;

@Data
public class Query {
    private double lat;
    private double lon;
    private String plus_code;
}
