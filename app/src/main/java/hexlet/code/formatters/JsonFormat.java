package hexlet.code.formatters;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;
import java.util.Map;

public class JsonFormat {
    public static String getJson(List<Map<String, Object>> different) throws JsonProcessingException {
        ObjectMapper objectToJason = new ObjectMapper();
        String result = objectToJason.writerWithDefaultPrettyPrinter().writeValueAsString(different);
        result = result.substring(2);
        result = result.substring(0, result.length() - 2);
        return result;
    }
}
