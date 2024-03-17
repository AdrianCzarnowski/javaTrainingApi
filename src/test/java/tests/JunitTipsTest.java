package tests;

import configuration.ProvideRandomStringResolver;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JunitTipsTest {
    private static Logger logger = LoggerFactory.getLogger("JunitTipsTest.class");

    @Test
    @ExtendWith(ProvideRandomStringResolver.class)
    public void shouldCreatedRandomStudentName(String randomName, String randomAddress, String randomCity) {
        String firstNAme = randomName;
        String address = randomAddress;
        String city = randomCity;

        logger.info(firstNAme);
        logger.info(address);
        logger.info(city);

    }
}
