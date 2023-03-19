package hexlet.code;

import hexlet.code.formatters.Plain;
import hexlet.code.formatters.Stylish;

import java.util.List;
import java.util.Map;

public class Formatter {

    public static String formatChoice(final List<Map<String, Object>> comparisonResult, String format) {
        return switch (format) {
            case "stylish" -> Stylish.stylishResult(comparisonResult);
            case "plain" -> Plain.plainResult(comparisonResult);
            default -> throw new RuntimeException("This format is unknown. Please recheck the format.");
        };
    }
}
