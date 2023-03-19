package hexlet.code.formatters;

import java.util.List;
import java.util.Map;

public class Plain {
    private static StringBuilder result;

    public static String plainResult(List<Map<String, Object>> comparisonResult) {
        result = new StringBuilder();

        for (Map<String, Object> map: comparisonResult) {

            switch ((String) map.get("status")) {
                case "updated" -> caseUpdated(map);
                case "added" -> caseAdded(map);
                case "removed" -> caseRemoved(map);
                default -> { }
            }
        }
        result.deleteCharAt(result.length() - 1);
        return result.toString();
    }

    private static void basicString(Map<String, Object> map) {
        String status = (String) map.get("status");
        result.append("Property '")
                .append(map.get("key"))
                .append("' was ")
                .append(status);
    }

    private static void caseUpdated(Map<String, Object> map) {
        basicString(map);
        result.append(". From ")
                .append(showValue(map.get("oldvalue")))
                .append(" to ")
                .append(showValue(map.get("newvalue")))
                .append("\n");
    }

    private static void caseAdded(Map<String, Object> map) {
        basicString(map);
        result.append(" with value: ")
                .append(showValue(map.get("newvalue")))
                .append("\n");
    }

    private static void caseRemoved(Map<String, Object> map) {
        basicString(map);
        result.append("\n");
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
