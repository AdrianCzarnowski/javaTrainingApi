package Tests;

import io.restassured.RestAssured;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class WeatherTest {


    @BeforeEach
    public void setUp() {
        RestAssured.useRelaxedHTTPSValidation();
        RestAssured.baseURI = "https://api.openweathermap.org";
//        RestAssured.basePath = "/data/2.5/weather";
//        RestAssured.port = 8881;
    }

    @Test
    public void shouldGetWeatherForLocation() {
        given()
                .param("appid","89a2ed8a594cc497a6273490e7ca59dd")
                .param("id","6695624")
                .log()
                .all()
                .when()
                .get("/data/2.5/forecast")
                .then()
                .statusCode(200)
                .log()
                .all();
    }
}
