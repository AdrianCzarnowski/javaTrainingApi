package tests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

public class RequestResponseSpecificationTest {
    @Test
    public void shouldGetWeatherForLocationWithResponseSpecification() {
        given().spec(getRequestSpecification())
                .when()
                .get("https://api.openweathermap.org/data/2.5/forecast")
                .then()
                .log()
                .all()
                .spec(getResponseSpecification());
    }

    private RequestSpecification getRequestSpecification() {
        return given()
                .param("appid", "89a2ed8a594cc497a6273490e7ca59dd")
                .param("id", "6695624")
                .log()
                .all();
    }

    private ResponseSpecification getResponseSpecification() {
        ResponseSpecification responseSpecification = RestAssured.expect();
        responseSpecification.log().all();
        responseSpecification.contentType(ContentType.JSON);
        responseSpecification.statusCode(200);
        responseSpecification.body("city.name", is("Warszawa"));
        return responseSpecification;
    }

}
