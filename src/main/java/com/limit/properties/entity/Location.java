package com.limit.properties.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@Table(name = "location")
@RequiredArgsConstructor
public class Location {

    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    private String name;
    private String street;

    @Column(name = "exterior_number")
    private String exteriorNumber;

    @Column(name = "interior_number")
    private String interiorNumber;

    @Column(name = "cross_street")
    private String crossStreet;

    @Column(name = "postal_code")
    private String postalCode;

    private Double latitude;
    private Double longitude;
}
