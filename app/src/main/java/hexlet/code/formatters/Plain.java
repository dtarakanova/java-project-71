package hexlet.code.formatters;

import java.util.List;
import java.util.Map;

public class Plain {

    public static String plainResult(List<Map<String, Object>> comparisonResult) {
        StringBuilder result = new StringBuilder();

        for (Map<String, Object> map: comparisonResult) {
            switch ((String) map.get("status")) {
                case "updated" -> result.append("Property '")
                        .append(map.get("key"))
                        .append("' was updated. From ")
                        .append(showValue(map.get("oldvalue")))
                        .append(" to ")
                        .append(showValue(map.get("newvalue")))
                        .append("\n");
                case "added" -> result.append("Property '")
                        .append(map.get("key"))
                        .append("' was added with value: ")
                        .append(showValue(map.get("newvalue")))
                        .append("\n");
                case "removed" -> result.append("Property '")
                        .append(map.get("key"))
                        .append("' was removed")
                        .append("\n");
                default -> {
                }
            }
        }
        result.deleteCharAt(result.length() - 1);
        return result.toString();
    }

    private static Object showValue(Object value) {
        if (value instanceof String) {
            return "'" + value + "'";
        } else if (value instanceof List || value instanceof Map) {
            return "[complex value]";
        }
        return value;
    }
}
