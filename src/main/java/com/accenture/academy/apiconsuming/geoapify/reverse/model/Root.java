package com.accenture.academy.apiconsuming.geoapify.reverse.model;

// import com.fasterxml.jackson.databind.ObjectMapper; // version 2.11.1
// import com.fasterxml.jackson.annotation.JsonProperty; // version 2.11.1
/* ObjectMapper om = new ObjectMapper();
Root root = om.readValue(myJsonString, Root.class); */


import lombok.Data;

import java.util.ArrayList;

@Data
public class Root{
    public String type;
    public ArrayList<Feature> features;
    public Query query;
}

