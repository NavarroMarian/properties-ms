# Property Microservice

This microservice is built using Java 17 and Spring Boot 3. It consumes the EasyBroker API to expose property information.

## Setup

1. Install Java 17.
2. Clone this repository.
3. Install and configure Docker (if needed).
4. Update `application.properties` with your EasyBroker API credentials.
5. Update `application.properties` with DataBase credentials.


## Usage

1. Build the project using Maven:
   ```bash
   mvn clean package
   
Run the application:

java -jar target/property-microservice.jar

Access the API:

GET http://localhost:8081/api/properties

Configuration

You can configure the application by editing the application.properties file.
# API Documentation

http://localhost:8081/api/v1/webjars/swagger-ui/4.15.5/index.html#/

# EasyBroker API Configuration

app.easy.broker.base_url=https://api.easybroker.com/v1
app.easy.broker.access-token=EASY_BROKER_TOKEN

Endpoints

GET /api/properties
Retrieve a list of properties from the EasyBroker API.


Parameters:

page (optional): Page number(default: 1)
limit (optional): Max results per page (maximum: 50)
propertyTypes (optional): List of property types to filter
... (add other query parameters as needed)

Example:

GET http://localhost:8081/api/properties?page=1&limit=10&propertyTypes=APARTMENT,VILLA

Response:
[
{
"propertyType": "APARTMENT",
"title": "Luxury Apartment",
"description": "Spacious apartment with stunning views.",
...
},
...
]

License

This project is licensed under the MIT License - see the LICENSE file for details.
