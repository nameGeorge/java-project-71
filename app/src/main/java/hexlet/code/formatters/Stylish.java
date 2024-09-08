package hexlet.code.formatters;

import java.util.List;
import java.util.Map;

public class Stylish {
    public static String getStylish(List<Map<String, Object>> different) {
        String result = "{\n";
        for (var diff : different) {
            String type = diff.get("type").toString();
            switch (type) {
                case "unchanged":
                    result += "    " + diff.get("key").toString() + ": " + diff.get("value") + "\n";
                    break;
                case "changed":
                    result += "  - " + diff.get("key").toString() + ": " + diff.get("value1") + "\n";
                    result += "  + " + diff.get("key").toString() + ": " + diff.get("value2") + "\n";
                    break;
                case "added":
                    result += "  + " + diff.get("key").toString() + ": " + diff.get("value2") + "\n";
                    break;
                case "deleted":
                    result += "  - " + diff.get("key").toString() + ": " + diff.get("value1") + "\n";
                    break;
                default:
                    break;
            }
        }
        return result + "}";
    }
}
