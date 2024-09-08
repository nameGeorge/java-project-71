package hexlet.code.formatters;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Plain {
    public static String getPlain(List<Map<String, Object>> different) {
        String result = "";
        for (var diff : different) {
            if (diff.get("type").toString().equals("changed")) {
                result += "Property '" + diff.get("key").toString() + "' was updated. From "
                        + typeOfValue(diff.get("oldvalue")) + " to " + typeOfValue(diff.get("newvalue")) + "\n";
            }
            if (diff.get("type").toString().equals("added")) {
                result += "Property '" + diff.get("key").toString() + "' was added with value: "
                        + typeOfValue(diff.get("newvalue")) + "\n";
            }
            if (diff.get("type").toString().equals("deleted")) {
                result += "Property '" + diff.get("key").toString() + "' was removed\n";
            }
        }
        return result;
    }

    public static String typeOfValue(Object value) {
        String returnValue = "";
        if (value instanceof ArrayList<?> || value instanceof LinkedHashMap<?, ?>) {
            returnValue = "[complex value]";
        } else if (Objects.isNull(value)) {
            returnValue = "null";
        } else if (value instanceof String) {
            returnValue = "'" + value + "'";
        } else {
            returnValue = value.toString();
        }
        return returnValue;
    }
}