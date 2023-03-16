package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.TreeMap;


public class Parser {

    public static Map<String, Object> readFile(String filePath) throws IOException {
        var normalizePath = normalizePath(filePath);
        var format = getFormat(filePath);

        var content = Files.readString(normalizePath);

        return Parser.parse(content, format);
    }

    public static TreeMap<String, Object> parse(String content, String format) throws IOException {
        ObjectMapper objectmapper = chooseFormat(format);
        return objectmapper.readValue(content, new TypeReference<>() { });
    }

    private static Path normalizePath(String path) {
        return Paths.get(path).toAbsolutePath().normalize();
    }

    private static String getFormat(String filePath) {
        String[] allExtensions = {"json", "yml", "yaml"};
        String fileExtension = filePath.substring(filePath.lastIndexOf('.') + 1).toLowerCase();

        if (fileExtension.equals(allExtensions[2])) {
            return allExtensions[1];
        }
        return fileExtension;
    }
    public static ObjectMapper chooseFormat(String format) {
        return "json".equals(format)  ? new ObjectMapper() : new ObjectMapper(new YAMLFactory());
    }
}
