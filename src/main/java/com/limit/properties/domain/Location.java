package com.limit.properties.domain;

import com.fasterxml.jackson.annotation.JsonAlias;

public class Location {

    private String name;
    private String street;
    @JsonAlias(value = "exterior_number" )
    private String exteriorNumber;
    @JsonAlias(value = "interior_number" )
    private String interiorNumber;
    @JsonAlias(value = "cross_street" )
    private String crossStreet;
    @JsonAlias(value = "postal_code" )
    private String postalCode;
    private Double latitude;
    private Double longitude;

}
