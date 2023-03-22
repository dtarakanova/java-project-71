package hexlet.code;

import hexlet.code.formatters.Json;
import hexlet.code.formatters.Plain;
import hexlet.code.formatters.Stylish;

import java.util.List;
import java.util.Map;

public class Formatter {

    public static String formatChoice(final List<Map<String, Object>> comparisonResult, String format)
            throws Exception {
        return switch (format) {
            case "stylish" -> Stylish.stylishResult(comparisonResult);
            case "plain" -> Plain.plainResult(comparisonResult);
            case "json" -> Json.jsonResult(comparisonResult);
            default -> throw new Exception("This format is unknown: " + format);
        };
    }
}
