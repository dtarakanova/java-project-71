package hexlet.code;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;


public class Differ {

    public static String generate(String filepath1, String filepath2) throws Exception {
        return generate(filepath1, filepath2, "stylish");
    }

    public static String generate(String filepath1, String filepath2, String format) throws Exception {
        Map<String, Object> data1 = read(filepath1);
        Map<String, Object> data2 = read(filepath2);
        List<Map<String, Object>> comparisonResult = Comparator.compareFiles(data1, data2);
        return Formatter.formatChoice(comparisonResult, format);
    }

    public static Map<String, Object> read(String filePath) throws IOException {
        var normalizePath = normalizePath(filePath);
        var type = getFormat(filePath);
        var content = Files.readString(normalizePath);

        return Parser.parse(content, type);
    }

    private static Path normalizePath(String path) {
        return Paths.get(path).toAbsolutePath().normalize();
    }

    private static String getFormat(String filePath) {
        String[] allExtensions = {"json", "yml", "yaml"};
        String extension = filePath.substring(filePath.lastIndexOf('.') + 1).toLowerCase();

        if (extension.equals(allExtensions[2])) {
            return allExtensions[1];
        }
        return extension;
    }

}
