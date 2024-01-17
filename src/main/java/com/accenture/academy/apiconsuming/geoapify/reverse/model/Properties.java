package com.accenture.academy.apiconsuming.geoapify.reverse.model;

import lombok.Data;

@Data
public class Properties {
    private Datasource datasource;
    private String name;
    private String country;
    private String country_code;
    private String state;
    private String city;
    private String postcode;
    private String district;
    private String suburb;
    private String street;
    private String housenumber;
    private double lon;
    private double lat;
    private int distance;
    private String result_type;
    private String formatted;
    private String address_line1;
    private String address_line2;
    private String category;
    private Timezone timezone;
    private String plus_code;
    private Rank rank;
    private String place_id;
}
