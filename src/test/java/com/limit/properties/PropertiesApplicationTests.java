package com.limit.properties;

import java.io.IOException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.reactive.server.WebTestClient;

import com.limit.properties.service.PropertiesService;

import okhttp3.mockwebserver.MockWebServer;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class PropertiesApplicationTests {


	private static MockWebServer mockWebServer;

	@Autowired
	private WebTestClient webTestClient;
	@MockBean
	private PropertiesService propertiesService;

	@BeforeAll
	static void setUp() throws IOException {
		mockWebServer = new MockWebServer();
		mockWebServer.start();
	}

	@AfterAll
	static void tearDown() throws IOException {
		mockWebServer.shutdown();
	}

	@BeforeEach
	void initialize() {
	}

	@Test
	void contextLoads() {
		Assertions.assertNotNull(webTestClient);
	}

	@DisplayName("Checks the availability of the healthcheck endpoint and receives a 200 OK.")
	@Test
	void shouldReceiveOKFromActuatorHealth() {
		webTestClient
		.get()
		.uri("/actuator/health")
		.exchange()
		.expectStatus()
		.isOk();
	}

	@DisplayName("Queries a non-existent endpoint and receives a 404 Not Found response")
	@Test
	void shouldReturnErrorWhenQueryNotExistentPath() {
		webTestClient
		.get()
		.uri("/any-endpoint")
		.exchange()
		.expectStatus()
		.isNotFound()
		.expectBody(String.class);
	}
}