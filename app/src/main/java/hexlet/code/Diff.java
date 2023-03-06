package hexlet.code;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;


public class Diff {

    public static String generate(String filepath1, String filepath2) throws Exception {
        Map<String, Object> newMap1= readFile(filepath1);
        Map<String, Object> newMap2 = readFile(filepath2);
        Map<String, Object> mapsCombined = new HashMap<>(newMap1);
        mapsCombined.putAll(newMap2);

        Map<String, Object> sortedMap = new TreeMap<>(mapsCombined);

        StringBuilder builder = new StringBuilder("{"  + "\n");

        Set<String> allKeys = sortedMap.keySet();
        for (String key : allKeys) {
            Object value = sortedMap.get(key);
            Object oldValue = newMap1.get(key);
            if (newMap1.containsKey(key) && newMap2.containsKey(key)) {
                if ((newMap1.containsValue(value)) && (newMap2.containsValue(value))) {
                  builder.append("  ").append(key).append(": ").append(value).append("\n");
                }
                else {
                  builder.append("- ").append(key).append(": ").append(oldValue).append("\n");
                    builder.append("+ ").append(key).append(": ").append(value).append("\n");
                }
            } else {
                if (newMap1.containsKey(key) && !newMap2.containsKey(key)) {
                    builder.append("- ").append(key).append(": ").append(value).append("\n");
                } else {
                    builder.append("+ ").append(key).append(": ").append(value).append("\n");
                }
            }
        }
        builder.append("}");
        return builder.toString();
            }

    private static Map<String, Object> readFile(String filePath) throws IOException {
        var normalizePath = normalizePath(filePath);
        var format = getFormat(filePath);

        var content = Files.readString(normalizePath);

        return Parser.parse(content, format);
    }

    private static Path normalizePath(String path) {
        return Paths.get(path).toAbsolutePath().normalize();
    }

    private static String getFormat(String filePath) {
        var pathParts = filePath.split("\\.");
        return pathParts[pathParts.length - 1];
    }
   
}

