package hexlet.code;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;
public class Parser {
    public static Map<String, Object> parseFile(String file, String format) throws IOException {
        switch (format) {
            case "json":
                ObjectMapper objectMapperJson = new ObjectMapper();
                Map<String, Object> mapjson
                        = objectMapperJson.readValue(file, new TypeReference<Map<String, Object>>() { });
                Map<String, Object> sortedJson = new TreeMap<>(mapjson);
                return sortedJson;
            case "yaml", "yml":
                ObjectMapper objectMapperYml = new ObjectMapper(new YAMLFactory());
                Map<String, Object> mapyml = objectMapperYml.readValue(file, Map.class);
                Map<String, Object> sortedYml = new TreeMap<>(mapyml);
                return sortedYml;
            default:
                throw new RuntimeException("format not supported");
        }
    }
}