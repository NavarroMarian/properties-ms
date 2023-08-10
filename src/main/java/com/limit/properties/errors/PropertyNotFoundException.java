package com.limit.properties.errors;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class PropertyNotFoundException extends ResponseStatusException {

	public static final HttpStatus STATUS = HttpStatus.NOT_FOUND;
	public static final String REASON = "property.error.notFound";
	public static final String EXAMPLE = """
			{
			    "timestamp": "2023-04-04T18:25:06.274+00:00",
			    "path": "/properties/6408a4195592bb0dasee75071d",
			    "status": 404,
			    "error": "Not Found",
			    "message": "property.error.notFound",
			    "requestId": "da8e8884-1"
			}
			""";

	public PropertyNotFoundException() {
		super(STATUS, REASON);
	}
}
