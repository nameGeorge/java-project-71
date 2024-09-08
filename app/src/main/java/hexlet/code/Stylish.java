package hexlet.code;

import java.util.List;
import java.util.Map;

public class Stylish {
    public static String getStylish(List<Map<String, Object>> different) {
        String result = "{\n";
        for (var diff : different) {
            if (diff.get("type").toString().equals("unchanged")) {
                result += "  " + diff.get("key").toString() + ": " + diff.get("value") + "\n";
            }
            if (diff.get("type").toString().equals("changed")) {
                result += "- " + diff.get("key").toString() + ": " + diff.get("oldvalue") + "\n";
                result += "+ " + diff.get("key").toString() + ": " + diff.get("newvalue") + "\n";
            }
            if (diff.get("type").toString().equals("added")) {
                result += "+ " + diff.get("key").toString() + ": " + diff.get("newvalue") + "\n";
            }
            if (diff.get("type").toString().equals("deleted")) {
                result += "- " + diff.get("key").toString() + ": " + diff.get("oldvalue") + "\n";
            }
        }


        return result + "}\n";
    }
}