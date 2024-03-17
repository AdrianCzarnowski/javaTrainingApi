package newFramework.requests;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import newFramework.client.ExecutableRequest;

import static io.restassured.RestAssured.given;

public class GetMockedStudent implements ExecutableRequest {
    private final RequestSpecBuilder requestSpecBuilder;

    public GetMockedStudent(String first_name, RequestSpecBuilder requestSpecBuilder) {
        this.requestSpecBuilder = requestSpecBuilder;
        this.requestSpecBuilder.addPathParam("firstName", first_name);
    }

    @Override
    public Response execute() {
        return given().spec(requestSpecBuilder.build()).when().get("/api/studentsDetails/{firstName}");
    }
}
