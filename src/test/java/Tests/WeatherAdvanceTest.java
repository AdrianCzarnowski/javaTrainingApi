package Tests;

import base.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static Specification.WeatherRequest.getWeatherRequestSpecification;
import static Specification.WeatherResponse.getWeatherResponseSpecification;
import static io.restassured.RestAssured.given;

public class WeatherAdvanceTest extends BaseTest {

    @ParameterizedTest
    @CsvFileSource(resources = "/xxx.csv")
    @Tag("regression")
    @DisplayName("Check response with weather for selected city")
    public void shouldGetWeatherByCity(String city, String country, int id) {
        given().spec(getWeatherRequestSpecification(id))
                .when().get()
                .then().spec(getWeatherResponseSpecification(city, country, id));
    }
}
