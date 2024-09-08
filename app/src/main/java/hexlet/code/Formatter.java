package hexlet.code;
import com.fasterxml.jackson.core.JsonProcessingException;
import hexlet.code.formatters.JsonFormat;
import hexlet.code.formatters.Plain;
import hexlet.code.formatters.Stylish;
import java.util.List;
import java.util.Map;

public class Formatter {
    public static String diffResult(List<Map<String, Object>> different, String format)
            throws JsonProcessingException {
        return switch (format) {
            case "stylish" -> Stylish.getStylish(different);
            case "plain" -> Plain.getPlain(different);
            default -> throw new RuntimeException("format not supported");
        };
    }
}
