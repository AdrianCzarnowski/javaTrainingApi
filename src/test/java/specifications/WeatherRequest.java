package specifications;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class WeatherRequest {
    public static RequestSpecification getWeatherRequestSpecification(int id) {
        return new RequestSpecBuilder()
                .addParam("id", id)
                .build();
    }
}
