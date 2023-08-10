package com.limit.properties.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.validation.constraints.Max;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GetPropertiesRequestDTO {


	/**
	 * Content's page
	 */
	private Integer page = 1;

	/**
	 * Max results per page (Maximum: 50)
	 */
	@Max(value = 50, message = "Value should be less then 50")
	private Integer limit;

	/**
	 * Search property types
	 */
	@JsonAlias(value = " search_property_types")
	private List<String> searchPropertyTypes;

	/**
	 * Optional search
	 */
	private SearchObjectRequestDTO search;
}
