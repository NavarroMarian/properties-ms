package com.limit.properties.service;

import java.util.List;
import java.util.Optional;

import com.limit.properties.domain.GetPropertiesRequestDTO;
import com.limit.properties.domain.PropertyResponseDTO;
import com.limit.properties.errors.GlobalErrorHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;


import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Service
@ConfigurationProperties(prefix = "app.easy.broker")
@Slf4j
public class EasyBrokerPropertiesService {

    private static final String BEARER = "Bearer ";

    @Autowired
    private WebClient.Builder webClient;

    @Setter
    private String baseUrl;

    @Setter
    private String propertiesEndpoint;

    @Setter
    private String propertyEndpoint;

    @Setter
    private String accessToken;


    /**
     * Makes a request to Easy Broker API to retrieve the properties according to the given
     * filters
     *
     * @return the list of properties.
     */
    public Mono<List<PropertyResponseDTO>> getProperties(GetPropertiesRequestDTO params) {
        return webClient
                .baseUrl(baseUrl)
                .build()
                .get()
                .uri(uriBuilder -> uriBuilder
                        .path(propertiesEndpoint)
                        .queryParamIfPresent("page", Optional.ofNullable(params).map(GetPropertiesRequestDTO::getPage))
                        .queryParamIfPresent("limit", Optional.ofNullable(params).map(GetPropertiesRequestDTO::getLimit))
                        .queryParamIfPresent("search[property_types][]", Optional.ofNullable(params).map(GetPropertiesRequestDTO::getSearchPropertyTypes))
                        .queryParamIfPresent("search", Optional.ofNullable(params).map(GetPropertiesRequestDTO::getSearch))
                        .build())
                .header("X-" + HttpHeaders.AUTHORIZATION,  accessToken)
                .retrieve()
                .onStatus(HttpStatusCode::isError, GlobalErrorHandler::manageError)
                .bodyToFlux(PropertyResponseDTO.class)
                .collectList();
    }


    /**
     * Makes a request to Easy Broker API to retrieve a property
     according to the id
     *
     * @return a property.
     */

    public Mono<PropertyResponseDTO> getProperty(String id) {
        return webClient
                .baseUrl(baseUrl)
                .build()
                .get()
                .uri(uriBuilder -> uriBuilder.path(propertyEndpoint)
                        .build(id))
                .header("X-" + HttpHeaders.AUTHORIZATION, accessToken)
                .retrieve()
                .onStatus(HttpStatusCode::isError, GlobalErrorHandler::manageError)
                .bodyToMono(PropertyResponseDTO.class);
    }

}

