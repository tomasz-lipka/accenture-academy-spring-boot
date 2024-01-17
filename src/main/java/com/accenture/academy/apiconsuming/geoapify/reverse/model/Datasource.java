package com.accenture.academy.apiconsuming.geoapify.reverse.model;

import lombok.Data;

@Data
public class Datasource{
    private String sourcename;
    private String attribution;
    private String license;
    private String url;
}