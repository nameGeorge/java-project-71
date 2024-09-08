package hexlet.code;

import java.util.List;
import java.util.Map;

public class Formatter {
    public static String diffResult(List<Map<String, Object>> different, String format) {
        return switch (format) {
            case "stylish" -> Stylish.getStylish(different);
            case "json" -> Jsonformat.getJson(different);
            default -> throw new RuntimeException("format not supported");
        };
    }
}
