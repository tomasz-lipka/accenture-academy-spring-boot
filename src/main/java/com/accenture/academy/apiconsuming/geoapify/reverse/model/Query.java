package com.accenture.academy.apiconsuming.geoapify.reverse.model;

import lombok.Data;

@Data
public class Query {
    public double lat;
    public double lon;
    public String plus_code;
}
