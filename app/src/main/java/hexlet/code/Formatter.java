package hexlet.code;

import com.fasterxml.jackson.core.JsonProcessingException;
import hexlet.code.formatters.Json;
import hexlet.code.formatters.Plain;
import hexlet.code.formatters.Stylish;

import java.util.List;
import java.util.Map;

public class Formatter {

    public static String formatChoice(final List<Map<String, Object>> comparisonResult, String format)
            throws JsonProcessingException {
        return switch (format) {
            case "stylish" -> Stylish.stylishResult(comparisonResult);
            case "plain" -> Plain.plainResult(comparisonResult);
            case "json" -> Json.jsonResult(comparisonResult);
            default -> throw new RuntimeException("This format is unknown. Please recheck the format.");
        };
    }
}
