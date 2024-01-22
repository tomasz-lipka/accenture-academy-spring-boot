package com.accenture.academy.leader;

import jakarta.persistence.Embeddable;

@Embeddable
class Location {
    private String city;
    private String street;
    private String numberOfStreet;
}
