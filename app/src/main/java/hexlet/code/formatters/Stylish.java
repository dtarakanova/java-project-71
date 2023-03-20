package hexlet.code.formatters;

import java.util.List;
import java.util.Map;

public class Stylish {
    private static StringBuilder result;

    public static String stylishResult(List<Map<String, Object>> comparisonResult) throws Exception {
        result = new StringBuilder("{\n");
        for (Map<String, Object> map: comparisonResult) {
            switch ((String) map.get("status")) {
                case "unmodified" -> basicString(map, "oldvalue", "    ");
                case "updated" -> {
                    basicString(map, "oldvalue", "  - ");
                    basicString(map, "newvalue", "  + ");
                }
                case "removed" -> basicString(map, "oldvalue", "  - ");
                case "added" -> basicString(map, "newvalue", "  + ");
                default -> throw new Exception("Unknown status: " + "status");
            }
        }
        return result.append("}").toString();
    }

    private static void basicString(Map<String, Object> map, String value, String diff) {
        result.append(diff)
                .append(map.get("key"))
                .append(": ")
                .append(map.get(value))
                .append("\n");
    }
}
