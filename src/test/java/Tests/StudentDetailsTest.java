package Tests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import model.Student;
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
    Student student;

    @Test
    public void shouldPostNewStudentAsObject() {
        // specjalna klasa której zadaniem jest budowanie studenta
        student = new Student("Salma", "Joanna","Hayek","10/01/1988");
        RestAssured
                .given()
                .baseUri("https://thetestingworldapi.com")
                .basePath("/api/studentsDetails")
                .header("Age", 30)
                .contentType(ContentType.JSON)
                .log()
                .all()
                .body(student)
                .post()
                .then()
                .statusCode(201)
                .log()
                .all();
    }
    @Test
    public void shouldGetNewStudent(){
        //10093344 //10093375 //10093384
        RestAssured
                .given()
                .baseUri("https://thetestingworldapi.com")
                .basePath("/api/studentsDetails")
                .pathParam("studentId", "10093344")
                .contentType(ContentType.JSON)
                .log()
                .all()
                .get("/{studentId}")
                .then()
                .statusCode(200)
                .log()
                .all();
    }



    @Test
    public void shouldDeleteNewStudent() {
        String studentId = "10093344";
        RestAssured
                .given()
                .baseUri("https://thetestingworldapi.com")
                .basePath("/api/studentsDetails")
                .pathParam("studentId", studentId)
                .contentType(ContentType.JSON)
                .log()
                .all()
                .delete("/{studentId}")
                .then()
                .statusCode(200)
                .log()
                .all();
    }
}
