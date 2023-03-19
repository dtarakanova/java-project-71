package hexlet.code;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

public class Comparator {
    public static List<Map<String, Object>> compareFiles(Map<String, Object> data1, Map<String, Object> data2) {
        List<Map<String, Object>> resultList = new ArrayList<>();
        Set<String> keySet = new TreeSet<>(data1.keySet());
        keySet.addAll(data2.keySet());
        for (String key: keySet) {
            Map<String, Object> result = new LinkedHashMap<>();
            if (data1.containsKey(key) && !data2.containsKey(key)) {
                result.put("key", key);
                result.put("oldvalue", data1.get(key));
                result.put("status", "removed");
            } else if (data2.containsKey(key) && !data1.containsKey(key)) {
                result.put("key", key);
                result.put("newvalue", data2.get(key));
                result.put("status", "added");
            } else if (Objects.equals(data1.get(key), (data2.get(key)))) {
                result.put("key", key);
                result.put("oldvalue", data1.get(key));
                result.put("newvalue", data2.get(key));
                result.put("status", "unmodified");
            } else {
                result.put("key", key);
                result.put("oldvalue", data1.get(key));
                result.put("newvalue", data2.get(key));
                result.put("status", "updated");
            }
            resultList.add(result);
        }
        return resultList;
    }
}
