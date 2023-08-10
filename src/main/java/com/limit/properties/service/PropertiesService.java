package com.limit.properties.service;

import java.util.*;

import com.limit.properties.domain.GetPropertiesRequestDTO;
import com.limit.properties.domain.PropertyResponseDTO;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class PropertiesService {
	private final EasyBrokerPropertiesService service;

	private final ModelMapper modelMapper;

	/**
	* it makes a request to Easy broker to return all properties
	* and map the result to a distinct property model
	*
	* @param filters      the query filters
	*
	* @return all the listings
	*/
	public Mono<List<PropertyResponseDTO>> getAllProperties(GetPropertiesRequestDTO filters) {
		return service.getProperties(filters)
				.map(l -> modelMapper.map(l, new TypeToken<List<PropertyResponseDTO>>() {}.getType()));
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
		return service.getProperty(id)
				.map(l -> modelMapper.map(l, new TypeToken<List<PropertyResponseDTO>>() {}.getType()));

	}

}
