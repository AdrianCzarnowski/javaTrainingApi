package newFramework.base;

import com.fasterxml.jackson.databind.ObjectWriter;
import com.github.tomakehurst.wiremock.junit5.WireMockExtension;
import newFramework.client.JacksonMapper;
import org.junit.jupiter.api.extension.RegisterExtension;

import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.wireMockConfig;

public class NewFrameworkTestBase {

    @RegisterExtension
    protected static WireMockExtension mock = WireMockExtension.newInstance().options(wireMockConfig().dynamicPort()).build();

    protected static ObjectWriter writer = new JacksonMapper().create().writer().withDefaultPrettyPrinter();
}
