package configuration;

import lombok.extern.slf4j.Slf4j;

import java.util.Map;

@Slf4j
public class AppProperties {

    YamlConfigReader yamlConfigReader = new YamlConfigReader();

    private Config config;

    public AppProperties() {
        setConfigProperties();
    }

    public static AppProperties getInstance() {
        return AppPropertiesSingleton.INSTANCE;
    }

    public static class AppPropertiesSingleton {
        private static final AppProperties INSTANCE = new AppProperties();
    }

    private void setConfigProperties() {
        config = yamlConfigReader.getConfig();
        setProperties(config.getConfig(), "property");
    }

    private void setProperties(Map<String, Object> map, String string) {
        map.forEach((key, value) -> {
            System.setProperty(key, value.toString());
            log.info("Loaded {} property: {}, {}", string, key, value);
        });
    }
}
