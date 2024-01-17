package com.accenture.academy.apiconsuming.geoapify.reverse.model;

import lombok.Data;

@Data
public class Timezone {
    private String name;
    private String offset_STD;
    private int offset_STD_seconds;
    private String offset_DST;
    private int offset_DST_seconds;
    private String abbreviation_STD;
    private String abbreviation_DST;
}
