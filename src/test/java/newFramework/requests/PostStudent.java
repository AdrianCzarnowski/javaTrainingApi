package newFramework.requests;

import dto.StudentDto;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import model.Student;
import newFramework.client.ExecutableRequest;

import static io.restassured.RestAssured.given;

public class PostStudent implements ExecutableRequest {
    private final RequestSpecBuilder requestSpecBuilder;

    public PostStudent(Student student, RequestSpecBuilder requestSpecBuilder) {
        this.requestSpecBuilder = requestSpecBuilder;
        this.requestSpecBuilder.setBody(student);
    }

    @Override
    public Response execute() {
        return given()
                .spec(requestSpecBuilder.build())
                .when()
                .post("/api/studentsDetails");
    }

    public StudentDto saveAsDto() {
        return execute().then().extract().as(StudentDto.class);
    }
}
