package hexlet.code;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

public class Comparator {
    public static List<Map<String, Object>> compareFiles(Map<String, Object> newMap1, Map<String, Object> newMap2) {
        List<Map<String, Object>> resultList = new ArrayList<>();
        Set<String> keySet = new TreeSet<>(newMap1.keySet());
        keySet.addAll(newMap2.keySet());
        for (String key: keySet) {
            Map<String, Object> result = new LinkedHashMap<>();
            if (newMap1.containsKey(key) && !newMap2.containsKey(key)) {
                result.put("key", key);
                result.put("oldvalue", newMap1.get(key));
                result.put("status", "deleted");
            } else if (newMap2.containsKey(key) && !newMap1.containsKey(key)) {
                result.put("key", key);
                result.put("newvalue", newMap2.get(key));
                result.put("status", "added");
            } else if (Objects.equals(newMap1.get(key), (newMap2.get(key)))) {
                result.put("key", key);
                result.put("oldvalue", newMap1.get(key));
                result.put("newvalue", newMap2.get(key));
                result.put("status", "unmodified");
            } else {
                result.put("key", key);
                result.put("oldvalue", newMap1.get(key));
                result.put("newvalue", newMap2.get(key));
                result.put("status", "updated");
            }
            resultList.add(result);
        }
        return resultList;
    }
}
