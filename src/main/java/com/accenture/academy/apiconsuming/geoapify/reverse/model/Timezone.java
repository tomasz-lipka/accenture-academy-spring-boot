package com.accenture.academy.apiconsuming.geoapify.reverse.model;

import lombok.Data;

@Data
public class Timezone {
    public String name;
    public String offset_STD;
    public int offset_STD_seconds;
    public String offset_DST;
    public int offset_DST_seconds;
    public String abbreviation_STD;
    public String abbreviation_DST;
}
