package com.accenture.academy.apiconsuming.geoapify.reverse.model;

import lombok.Data;

@Data
public class Properties {
    public Datasource datasource;
    public String name;
    public String country;
    public String country_code;
    public String state;
    public String city;
    public String postcode;
    public String district;
    public String suburb;
    public String street;
    public String housenumber;
    public double lon;
    public double lat;
    public int distance;
    public String result_type;
    public String formatted;
    public String address_line1;
    public String address_line2;
    public String category;
    public Timezone timezone;
    public String plus_code;
    public Rank rank;
    public String place_id;
}
