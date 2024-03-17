package newFramework.requests;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import newFramework.client.ExecutableRequest;

import static io.restassured.RestAssured.given;

public class GetStudent implements ExecutableRequest {
    private final RequestSpecBuilder requestSpecBuilder;

    public GetStudent(String id, RequestSpecBuilder requestSpecBuilder) {
        this.requestSpecBuilder = requestSpecBuilder;
        this.requestSpecBuilder.setContentType(ContentType.JSON);
        this.requestSpecBuilder.addPathParam("studentId", id);
    }

    @Override
    public Response execute() {
        return given().spec(requestSpecBuilder.build()).when().get("/api/studentsDetails/{studentId}");
    }
}
