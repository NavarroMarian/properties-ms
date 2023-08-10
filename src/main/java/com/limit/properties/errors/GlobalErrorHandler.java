package com.limit.properties.errors;

import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.server.ResponseStatusException;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Slf4j
public class GlobalErrorHandler {

    public static Mono<ResponseStatusException> manageError(ClientResponse clientResponse) {
    	return clientResponse.createException().flatMap(response -> {
            log.error(response.getResponseBodyAsString());
			return Mono.error(new ResponseStatusException(response.getStatusCode(), response.getMessage()));
        });
    }
}
