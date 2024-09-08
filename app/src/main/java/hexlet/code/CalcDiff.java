package hexlet.code;

import java.util.Objects;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.TreeSet;
import java.util.LinkedHashMap;

public class CalcDiff {
    public static List<Map<String, Object>> getDiff(Map<String, Object> sortedMap1, Map<String, Object> sortedMap2) {
        var keys = new TreeSet<>();
        keys.addAll(sortedMap1.keySet());
        keys.addAll(sortedMap2.keySet());
        List<Map<String, Object>> result = new ArrayList<>();
        for (var key : keys) {
            Map<String, Object> line = new LinkedHashMap<>();
            line.put("key", key.toString());
            if (sortedMap1.containsKey(key.toString()) && sortedMap2.containsKey(key.toString())) {
                if (Objects.equals(sortedMap1.get(key.toString()), (sortedMap2.get(key.toString())))) {
                    line.put("type", "unchanged");
                    line.put("value", sortedMap1.get(key.toString()));
                } else {
                    line.put("type", "changed");
                    line.put("oldvalue", sortedMap1.get(key.toString()));
                    line.put("newvalue", sortedMap2.get(key.toString()));
                }
            }
            if (!sortedMap1.containsKey(key) && sortedMap2.containsKey(key)) {
                line.put("type", "added");
                line.put("newvalue", sortedMap2.get(key.toString()));
            }
            if (sortedMap1.containsKey(key) && !sortedMap2.containsKey(key)) {
                line.put("type", "deleted");
                line.put("oldvalue", sortedMap1.get(key.toString()));
            }
            result.add(line);
        }
        return result;
    }
}
