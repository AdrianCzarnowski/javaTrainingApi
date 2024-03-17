package tests;

import dataStore.DataStore;
import io.restassured.RestAssured;
import io.restassured.http.Cookies;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;

public class WeatherTest {
    private Cookies cookie;
    private static Logger logger = LoggerFactory.getLogger("WeatherTest.class");

    @BeforeEach
    public void setUp() {
        RestAssured.useRelaxedHTTPSValidation();
        RestAssured.baseURI = "https://api.openweathermap.org";
//        RestAssured.basePath = "/data/2.5/weather";
//        RestAssured.port = 8881;

    }

    @Test
    public void shouldGetWeatherForLocation() {
        shouldLoginToSystem();
        given()
                .param("appid", "89a2ed8a594cc497a6273490e7ca59dd")
                .param("id", "6695624")
                .log()
                .all()
                .when()
                .get("/data/2.5/forecast")
                .then()
                .statusCode(200)
                .log()
                .all();
    }

    @Test
    public void shouldGetWeatherForLocationWithCookies() {
        cookie = shouldLoginToSystem();
        //tę operację dajemy przed testem i najlepiej dać w  hooku
        given()
                .cookies(cookie)
                .param("appid", "89a2ed8a594cc497a6273490e7ca59dd")
                .param("id", "6695624")
                .log()
                .all()
                .when()
                .get("/data/2.5/forecast")
                .then()
                .statusCode(200)
                .log()
                .all();
    }

    @Test
    public void shouldGetWeatherForLocationWithResponseValidation() {
        DataStore.windDegree = given()
                .param("appid", "89a2ed8a594cc497a6273490e7ca59dd")
                .param("q", "London,uk")
                .log()
                .all()
                .when()
                .get("https://samples.openweathermap.org/data/2.5/weather")
                .then()
                .statusCode(200)
                .log()
                .all()
                .extract().jsonPath().get("wind.deg");
        logger.info("Extracted value: " + DataStore.windDegree);
    }

    @Test
    public void shouldGetWeatherForLocationWithResponseValidationAtHok() {
        given()
                .param("appid", "89a2ed8a594cc497a6273490e7ca59dd")
                .param("q", "London,uk")
                .log()
                .all()
                .when()
                .get("https://samples.openweathermap.org/data/2.5/weather")
                .then()
                .statusCode(200)
                .log()
                .all()
                .body("wind.speed", is(4.1f))
                .body("main.temp_min", equalTo(279.15f));
    }

    private Cookies shouldLoginToSystem() {
        String body = "payload";
        return RestAssured.given().param("appid", "89a2ed8a594cc497a6273490e7ca59dd")
                .param("id", "6695624")
                .log()
                .all()
                .body(body)
                .when()
                .post("api/bbh")
                .getDetailedCookies();
    }
}
