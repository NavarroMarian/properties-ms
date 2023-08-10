package com.limit.properties.controller;

import java.util.List;

import com.limit.properties.domain.PropertyResponseDTO;
import com.limit.properties.service.PropertiesService;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.limit.properties.domain.GetPropertiesRequestDTO;

import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping
@AllArgsConstructor
@Tag(name = "Properties")
public class PropertiesController {


	private final PropertiesService propertiesService;

	/**
	 * Retrieves all the properties from Easy Broker according to the given filters.
	 * Refer to
	 * <a href= "https://dev.easybroker.com/reference/get_properties"> Easy Broker API
	 * docs</a> for more information.
	 *
	 * @param filters The query parameters for the request.
	 *
	 * @return Returns all the properties
	 */
	@GetMapping(value = "/properties", produces = MediaType.APPLICATION_JSON_VALUE)
	public Mono<List<PropertyResponseDTO>> getProperties(
			@ParameterObject @Valid GetPropertiesRequestDTO filters
			) {
		return propertiesService.getAllProperties(filters);
	}

	/**
	 * Retrieves a property from Easy Broker according to the given filters
	 * Refer to
	 * <a href= "https://dev.easybroker.com/reference/get_properties-property-id"> Easy Broker API
	 * docs</a> for more information.
	 **
	 * @return a property
	 */
	@GetMapping(value = "/properties/{propertyId}", produces = MediaType.APPLICATION_JSON_VALUE)
	@Parameters
	public Mono<PropertyResponseDTO> getProperty(
			@PathVariable String propertyId
			) {
		return propertiesService.getProperty(propertyId);
	}



}
