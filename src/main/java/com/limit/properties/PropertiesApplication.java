package com.limit.properties;

import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.ExchangeFilterFunction;
import org.springframework.web.reactive.function.client.WebClient;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@SpringBootApplication
@Slf4j
@OpenAPIDefinition(
        info = @Info(
                title = "Lumit Stays Properties API",
                version = "0.1",
                description = "Listings API for Lumit"
        ),
        tags = {
                @Tag(name = "Properties", description = "Properties API endpoints"),
        }
)
public class PropertiesApplication {

	@Bean
	ModelMapper modelMapper() {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setSkipNullEnabled(true);
		modelMapper.getConfiguration().setPropertyCondition(Conditions.isNotNull());
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		return modelMapper;
	}

	public static void main(String[] args) {
		SpringApplication.run(PropertiesApplication.class, args);
	}

	@Bean
	WebClient.Builder webClient() {
		return WebClient.builder()
				.defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
				.codecs(configurer -> configurer.defaultCodecs().maxInMemorySize(16 * 1024 * 1024)).filter(logRequest())
				.filter(logResponse());
	}

	private static ExchangeFilterFunction logRequest() {
		return ExchangeFilterFunction.ofRequestProcessor(clientRequest -> {
			log.info("Request: {} {}", clientRequest.method(), clientRequest.url());
			clientRequest.headers().forEach((name, values) -> values.forEach(value -> log.info("{}={}", name, value)));
			return Mono.just(clientRequest);
		});
	}

	private static ExchangeFilterFunction logResponse() {
		return ExchangeFilterFunction.ofResponseProcessor(clientResponse -> {
			log.info("Response status: {}", clientResponse.statusCode());
			clientResponse.headers().asHttpHeaders()
					.forEach((name, values) -> values.forEach(value -> log.info("{}={}", name, value)));
			return Mono.just(clientResponse);
		});
	}
}
