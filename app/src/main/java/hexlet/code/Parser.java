package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;


import java.io.IOException;
import java.util.TreeMap;


public class Parser {
    public static TreeMap<String, Object> parse(String content, String format) throws IOException {
        ObjectMapper objectmapper = chooseFormat(format);
        return objectmapper.readValue(content, new TypeReference<>() { });
    }

    public static ObjectMapper chooseFormat(String format) {
        return "json".equals(format) ? new ObjectMapper() : new ObjectMapper(new YAMLFactory());
    }
}
