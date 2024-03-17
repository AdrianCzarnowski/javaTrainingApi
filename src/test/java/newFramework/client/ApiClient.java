package newFramework.client;

import io.restassured.builder.RequestSpecBuilder;
import model.Student;
import newFramework.requests.GetMockedStudent;
import newFramework.requests.GetStudent;
import newFramework.requests.PostMockedStudent;
import newFramework.requests.PostStudent;

import java.util.function.Supplier;

public class ApiClient {
    private final Supplier<RequestSpecBuilder> requestSpecBuilderSupplier;

    public ApiClient(Supplier<RequestSpecBuilder> requestSpecBuilderSupplier) {
        this.requestSpecBuilderSupplier = requestSpecBuilderSupplier;
    }

    public GetStudent getRealStudent(String studentId) {
        return new GetStudent(studentId, requestSpecBuilderSupplier.get());
    }

    public PostStudent postRealStudent(Student student) {
        return new PostStudent(student, requestSpecBuilderSupplier.get());
    }

    public GetMockedStudent getMockedStudent(String first_name) {
        return new GetMockedStudent(first_name, requestSpecBuilderSupplier.get());
    }

    public PostMockedStudent postMockedStudent(String first_name) {
        return new PostMockedStudent(first_name, requestSpecBuilderSupplier.get());
    }

}
