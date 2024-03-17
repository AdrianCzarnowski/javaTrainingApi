package tests;

import dataStore.DataStore;
import io.restassured.common.mapper.TypeRef;
import io.restassured.http.ContentType;
import model.Student;
import model.StudentResponse;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static io.restassured.RestAssured.given;

public class StudentDetailsTest {
    private static Logger logger = LoggerFactory.getLogger("StudentDetailsTest.class");

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
        given()
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
        student = new Student("Salma", "Joanna", "Hayek", "10/01/1988");
        DataStore.studentId = given()
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
                .all()
                .extract()
                .jsonPath()
                .get("id");

        given()
                .baseUri("https://thetestingworldapi.com")
                .basePath("/api/studentsDetails")
                .pathParam("studentId", DataStore.studentId)
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
    public void shouldGetNewStudent() {
        //10093344 //10093375 //10093384
        given()
                .baseUri("https://thetestingworldapi.com")
                .basePath("/api/studentsDetails")
                .pathParam("studentId", DataStore.studentId)
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
    public void shouldGetNewStudentAmdExtractAsTypeRef() {
        //10093344 //10093375 //10093384
        var actualStudent = given()
                .baseUri("https://thetestingworldapi.com")
                .basePath("/api/studentsDetails")
                .pathParam("studentId", "10093375")
                .contentType(ContentType.JSON)
                .log()
                .all()
                .get("/{studentId}")
//                .jsonPath()
//                .getList(".", StudentResponse.class)
//                .stream()
//                .distinct()
//                .collect(Collectors.toList());
                .then()
                .statusCode(200)
                .log()
                .all()
                .extract()
//                .as(StudentResponse.class);
                .as(new TypeRef<StudentResponse>() {
                });
        logger.info("Extracted student: " + actualStudent);

    }

    @Test
    public void shouldPostNewStudentAsObjectWithBuilder() {
        student = Student
                .builder()
                .date_of_birth("22/02/1999")
                .first_name("Kamila")
                .middle_name("Agnieszka")
                .last_name("Cabeyo")
                .build();
        DataStore.studentId = given()
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
                .all()
                .extract()
                .jsonPath()
                .get("id");
    }
    @Test
    public void shouldDeleteNewStudent() {

        given()
                .baseUri("https://thetestingworldapi.com")
                .basePath("/api/studentsDetails")
                .pathParam("studentId", DataStore.studentId)
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
