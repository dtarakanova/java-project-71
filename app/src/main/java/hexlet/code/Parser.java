package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.util.TreeMap;


public class Parser {

    public static TreeMap<String, Object> parse(String content, String type) throws Exception {
        ObjectMapper objectmapper = chooseType(type);
        return objectmapper.readValue(content, new TypeReference<>() { });
    }

    public static ObjectMapper chooseType(String type) throws Exception {
        return switch (type) {
            case "json" -> new ObjectMapper();
            case "yaml" -> new ObjectMapper(new YAMLFactory());
            case "yml" -> new ObjectMapper(new YAMLFactory());
            default -> throw new Exception("Format is unknown " + type);
        };
    }
}
