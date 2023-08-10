package com.limit.properties.domain;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@AllArgsConstructor
@NoArgsConstructor
public class PropertyResponseDTO {

	@JsonAlias(value = "property_type")
	private String propertyType;
	private String title;
	private String description;
	private String status;
	@JsonAlias(value = "private_description")
	private String privateDescription;
	private List<String> operations;
	private String agent;
	@JsonAlias(value = "show_prices")
	private boolean showPrices;
	private int bedrooms;
	private int bathrooms;
	@JsonAlias(value = "half_bathrooms")
	private int halfBathrooms;
	@JsonAlias(value = "parking_spaces")
	private Integer parkingSpaces;
	private String age;
	private String floor;
	private Integer floors;
	private String expenses;
	private Location location;
	@JsonAlias(value = "shareCommission")
	private boolean shareCommission;
	@JsonAlias(value = "collaborationnotes")
	private String collaborationNotes;
	private List<String> images;
	@JsonAlias(value = "show_exact_location")
	private boolean showExactLocation;
	@JsonAlias(value = "construction_size")
	private double constructionSize;
	@JsonAlias(value = "lot_size")
	private double lotSize;
	@JsonAlias(value = "lot_length")
	private int lotLength;
	@JsonAlias(value = "lot_width")
	private int lotWidth;
	@JsonAlias(value = "covered_space")
	private double coveredSpace;


}
