package base;

import configuration.AppProperties;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;

public class BaseTest {
    private static AppProperties appProperties;

    @BeforeAll
    public static void setUp() {
        appProperties = AppProperties.getInstance();
        RestAssured.requestSpecification = new RequestSpecBuilder()
                .setBaseUri(System.getProperty("baseUri"))
                .addParam("appid", System.getProperty("appid"))
                .setContentType(ContentType.JSON)
                .build()
                .filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
    }
}
