package configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.File;
import java.io.IOException;

public class YamlConfigReader {

    public static Config config;

    public Config getConfig() {
        return config;
    }

    public YamlConfigReader() {
        try {
            ObjectMapper om = new ObjectMapper(new YAMLFactory());
            config = om.readValue(new File("src/test/resources/configuration.yaml"), Config.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}