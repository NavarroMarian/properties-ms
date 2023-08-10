package com.limit.properties.domain;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SearchObjectRequestDTO {
    @JsonAlias("updated_after")
    private LocalDateTime updatedAfter;

    @JsonAlias("updated_before")
    private LocalDateTime updatedBefore;

    @JsonAlias("operation_type")
    private String operationType;

    @JsonAlias("min_price")
    private Integer minPrice;

    @JsonAlias("max_price")
    private Integer maxPrice;

    @JsonAlias("min_bedrooms")
    private Integer minBedrooms;

    @JsonAlias("min_bathrooms")
    private Integer minBathrooms;

    @JsonAlias("min_parking_spaces")
    private Integer minParkingSpaces;

    @JsonAlias("min_construction_size")
    private Integer minConstructionSize;

    @JsonAlias("max_construction_size")
    private Integer maxConstructionSize;

    @JsonAlias("min_lot_size")
    private Integer minLotSize;

    @JsonAlias("max_lot_size")
    private Integer maxLotSize;
}
