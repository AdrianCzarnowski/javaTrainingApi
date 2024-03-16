package Specification;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.ResponseSpecification;

import static org.hamcrest.CoreMatchers.is;

public class WeatherResponse {
    public static ResponseSpecification getWeatherResponseSpecification(String name, String country, int id) {
        return new ResponseSpecBuilder()
                .expectBody("name", is(name))
                .expectBody("sys.country", is(country))
                .expectBody("id", is(id))
                .build()
                .statusCode(200);
    }
}
