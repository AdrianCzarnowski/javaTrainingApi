package newFramework.requests;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import newFramework.client.ExecutableRequest;

import static io.restassured.RestAssured.given;

public class PostMockedStudent implements ExecutableRequest {
    private final RequestSpecBuilder requestSpecBuilder;

    public PostMockedStudent(String first_name, RequestSpecBuilder requestSpecBuilder) {
        this.requestSpecBuilder = requestSpecBuilder;
        this.requestSpecBuilder.setBody(first_name);
    }

    @Override
    public Response execute() {
        return given()
                .spec(requestSpecBuilder.build())
                .when()
                .post("/api/studentsDetails");
    }
}
