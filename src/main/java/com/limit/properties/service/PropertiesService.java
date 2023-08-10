package com.limit.properties.service;

import java.util.*;
import java.util.stream.Collectors;

import com.limit.properties.domain.GetPropertiesRequestDTO;
import com.limit.properties.domain.PropertyResponseDTO;
import com.limit.properties.entity.Property;
import com.limit.properties.errors.PropertyNotFoundException;
import com.limit.properties.repository.PropertyRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@Service
@Slf4j
@RequiredArgsConstructor
public class PropertiesService {
	private final EasyBrokerPropertiesService service;

	private final ModelMapper modelMapper;

	private PropertyRepository propertyRepository;

	/**
	* it makes a request to Easy broker to return all properties
	* and map the result to a distinct property model
	*
	* @param filters      the query filters
	*
	* @return all the listings
	*/
	public Mono<List<PropertyResponseDTO>> getAllProperties(GetPropertiesRequestDTO filters) {
		log.info("Getting all properties");

		return service.getProperties(filters)
				.map(properties -> properties.stream()
						.map(property -> modelMapper.map(property, PropertyResponseDTO.class))
						.toList()
				);
	}

	/**
	 * it makes a request to Easy broker to return a property
	 * and map the result to a distinct property model
	 *
	 * @param id  id from property
	 *
	 * @return a property
	 */

	public Mono<PropertyResponseDTO> getProperty(String id) {
		log.info("Getting property:{}",id);

		return service.getProperty(id)
				.map(property -> modelMapper.map(property, PropertyResponseDTO.class))
				.doOnSuccess(propertyResponse -> {
					propertyRepository.save(modelMapper.map(propertyResponse,Property.class));
					log.info("Property saved successfully: {}", propertyResponse);
				})
				.switchIfEmpty(Mono.error(new PropertyNotFoundException()));

	}

}
