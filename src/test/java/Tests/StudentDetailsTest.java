package Tests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.Test;

public class StudentDetailsTest {

    String requestBody = """
                    {
                        "first_name": "Angelina",
                        "middle_name": "Jolie",
                        "last_name": "Camila",
                        "date_of_birth": "01/03/1977"
                    }
            """;

    @Test
    public void shouldPostNewStudent() {
        RestAssured
                .given()
                .baseUri("https://thetestingworldapi.com")
                .basePath("/api/studentsDetails")
                .contentType(ContentType.JSON)
                .log()
                .all()
                .body(requestBody)
                .post()
                .then()
                .statusCode(201)
                .log()
                .all();
    }
    @Test
    public void shouldGetNewStudent(){
        //10093344
        RestAssured
                .given()
                .baseUri("https://thetestingworldapi.com")
                .basePath("/api/studentsDetails")
                .contentType(ContentType.JSON)
                .log()
                .all()
                .get()
                .then()
                .statusCode(200)
                .log()
                .all();
    }
}
