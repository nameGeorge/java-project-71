package hexlet.code.formatters;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Plain {
    public static String getPlain(List<Map<String, Object>> different) {
        String result = "";
        String changed = "Property '%s' was updated. From %s to %s\n";
        String deleted = "Property '%s' was removed\n";
        String added = "Property '%s' was added with value: %s\n";
        for (var diff : different) {
            String key = diff.get("key").toString();
            if (diff.get("type").toString().equals("changed")) {
                result += String.format(changed, key, typeOfValue(diff.get("value1")),
                        typeOfValue(diff.get("value2")));
            }
            if (diff.get("type").toString().equals("added")) {
                result += String.format(added, key, typeOfValue(diff.get("value2")));
            }
            if (diff.get("type").toString().equals("deleted")) {
                result += String.format(deleted, key);
            }
        }
        return result.substring(0, result.length() - 1);
    }

    public static String typeOfValue(Object value) {

        if (value instanceof ArrayList<?> || value instanceof LinkedHashMap<?, ?>) {
            return  "[complex value]";
        } else if (value instanceof String) {
            return  "'" + value + "'";
        } else {
            return String.valueOf(value);
        }
    }
}
