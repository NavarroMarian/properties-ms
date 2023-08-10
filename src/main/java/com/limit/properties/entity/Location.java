package com.limit.properties.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@Table(name = "locations")
@RequiredArgsConstructor
public class Location {

    @Id
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "name_location")
    private String name;

    @ManyToOne
    @JoinColumn(name = "property_id", referencedColumnName = "id")
    private Property property;
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
