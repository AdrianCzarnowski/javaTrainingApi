package newFramework.test;

import io.restassured.http.ContentType;
import lombok.SneakyThrows;
import model.MockStudent;
import newFramework.base.NewFrameworkTestBase;
import newFramework.client.ApiClient;
import newFramework.factories.StudentFactory;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.assertj.core.api.Assertions.assertThat;

public class NewFrameworkStudentMockApiTest extends NewFrameworkTestBase {
    private final String baseUrl = "https://thetestingworldapi.com";
    private ApiClient api;
    private StudentFactory studentFactory;

    private final String basePathMockedPost = "/api/studentsDetails";

    private final String basePathMockedGet = "/api/studentsDetails/.*";

    @BeforeEach
    public void setupClient() {
        api = createApiClient(mock.baseUrl());
        studentFactory = new StudentFactory();
        mock.stubFor(post(urlPathMatching(basePathMockedGet))
                .willReturn(aResponse()
                        .withStatus(HttpStatus.SC_CREATED)));

    }

    @SneakyThrows
    @Test
    public void shouldGetNewStudent() {
        String studentName = RandomStringUtils.random(8, true, false).toLowerCase();
        MockStudent mockStudent = new MockStudent(studentName);
        mock.stubFor(get(urlPathMatching(basePathMockedGet)).willReturn(aResponse()
                .withStatus(HttpStatus.SC_OK)
                .withHeader("Content-Type", ContentType.JSON.toString())
                .withBody(writer.writeValueAsString(mockStudent))));
        assertThat(api.getMockedStudent(studentName).execute().getStatusCode()).isEqualTo(HttpStatus.SC_OK);
    }

    @Test
    public void shouldPostNewStudent() {

    }
}