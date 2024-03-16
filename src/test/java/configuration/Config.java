package configuration;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;


@Getter
public class Config {
    private Map<String, Object> config = new HashMap<>();

    @JsonAnyGetter
    public Map<String, Object> getConfig() {
        return config;
    }

    @JsonAnySetter
    public void setConfig(String key, Object value) {
        config.put(key, value);
    }

}
