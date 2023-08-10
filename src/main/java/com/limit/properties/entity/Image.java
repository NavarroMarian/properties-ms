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
@Table(name = "image")
@RequiredArgsConstructor
public class Image {

    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "images")
    private String images;
}
