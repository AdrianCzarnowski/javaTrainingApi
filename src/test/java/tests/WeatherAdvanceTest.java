package tests;

import base.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static io.restassured.RestAssured.given;
import static specifications.WeatherRequest.getWeatherRequestSpecification;
import static specifications.WeatherResponse.getWeatherResponseSpecification;

public class WeatherAdvanceTest extends BaseTest {

    @ParameterizedTest
    @CsvFileSource(resources = "/cities.csv")
    @Tag("regression")
    @DisplayName("Check response with weather for selected city")
    public void shouldGetWeatherByCity(String city, String country, int id) {
        given().spec(getWeatherRequestSpecification(id))
                .when().get()
                .then().spec(getWeatherResponseSpecification(city, country, id));
    }
}
