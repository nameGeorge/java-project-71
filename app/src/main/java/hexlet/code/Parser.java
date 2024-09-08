package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import java.io.IOException;
import java.util.Map;

public class Parser {
    public static Map<String, Object> parseFile(String file, String format) throws IOException {
        switch (format) {
            case "json":
                ObjectMapper objectMapperJson = new ObjectMapper();
                Map<String, Object> mapJson
                        = objectMapperJson.readValue(file, new TypeReference<>() { });
                return mapJson;
            case "yaml", "yml":
                ObjectMapper objectMapperYml = new ObjectMapper(new YAMLFactory());
                Map<String, Object> mapYml = objectMapperYml.readValue(file, Map.class);
                return mapYml;
            default:
                throw new RuntimeException("format not supported");
        }
    }
}
