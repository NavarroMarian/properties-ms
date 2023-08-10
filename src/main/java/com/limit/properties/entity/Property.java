package com.limit.properties.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Entity
@Getter
@Setter
@ToString
@Table(name = "property")
@RequiredArgsConstructor
@AllArgsConstructor
public class Property {


	@Id
	@Column(name = "id", nullable = false)
	private String id;

	@Column(name = "property_type")
	private String propertyType;

	private String title;
	private String description;
	private String status;

	@Column(name = "private_description")
	private String privateDescription;

	private String agent;

	@Column(name = "show_prices")
	private boolean showPrices;

	private int bedrooms;
	private int bathrooms;

	@Column(name = "half_bathrooms")
	private int halfBathrooms;

	@Column(name = "parking_spaces")
	private Integer parkingSpaces;

	private String age;
	private String floor;
	private Integer floors;
	private String expenses;

	@OneToMany(mappedBy = "name")
	private List<Location> location;

	@Column(name = "share_commission")
	private boolean shareCommission;

	@Column(name = "collaboration_notes")
	private String collaborationNotes;

	@OneToMany(mappedBy = "operations")
	private List<Operation> operations;

	@OneToMany(mappedBy = "images")
	private List<Image> images;

	@Column(name = "show_exact_location")
	private boolean showExactLocation;

	@Column(name = "construction_size")
	private double constructionSize;

	@Column(name = "lot_size")
	private double lotSize;

	@Column(name = "lot_length")
	private int lotLength;

	@Column(name = "lot_width")
	private int lotWidth;

	@Column(name = "covered_space")
	private double coveredSpace;

}
