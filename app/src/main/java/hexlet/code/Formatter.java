package hexlet.code;

import hexlet.code.formatters.StylishFormatter;

import java.util.List;
import java.util.Map;

public class Formatter {

    public static String formatChoice(final List<Map<String, Object>> comparisonResult, String format) {
        return switch (format) {
            case "stylish" -> StylishFormatter.stylishResult(comparisonResult);
            default -> throw new RuntimeException("This format is unknown. Please recheck the format.");
        };
    }
}
