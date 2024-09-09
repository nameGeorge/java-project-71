package hexlet.code;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;


class DifferTest {
    private static final String STYLISHFILE = "src/test/resources/Stylishresult.txt";
    private static final String PLAINFILE = "src/test/resources/Plainresult.txt";
    private static final String JASONFILE = "src/test/resources/Jsonresult.txt";
    private static final String JASONFILE1 = "src/test/resources/file1.json";
    private static final String JASONFILE2 = "src/test/resources/file2.json";
    private static final String YAMLFILE1 = "src/test/resources/file1.yaml";
    private static final String YAMLFILE2 = "src/test/resources/file2.yaml";
    private static String stylishResult;
    private static String plainResult;
    private static String jasonResult;

    @BeforeAll
    public static void beforeAll() throws Exception {
        stylishResult = Files.readString(Paths.get(STYLISHFILE));
        plainResult = Files.readString(Paths.get(PLAINFILE));
        jasonResult = Files.readString(Paths.get(JASONFILE));
    }

    @Test
    void testJsonStylish() throws Exception {
        var result = Differ.generate(JASONFILE1, JASONFILE2, "stylish");
        assertEquals(result, stylishResult);
    }

    @Test
    void testYamlStylish() throws Exception {
        var result1 = Differ.generate(YAMLFILE1, YAMLFILE2, "stylish");
        assertEquals(result1, stylishResult);
    }

    @Test
    void testYamlDefault() throws Exception {
        var result2 = Differ.generate(YAMLFILE1, YAMLFILE2);
        assertEquals(result2, stylishResult);
    }

    @Test
    void testJsonDefault() throws Exception {
        var result3 = Differ.generate(JASONFILE1, JASONFILE2);
        assertEquals(result3, stylishResult);
    }

    @Test
    void testJsonPlain() throws Exception {
        var result4 = Differ.generate(JASONFILE1, JASONFILE2, "plain");
        assertEquals(result4, plainResult);
    }

    @Test
    void testYamlPlain() throws Exception {
        var result5 = Differ.generate(YAMLFILE1, YAMLFILE2, "plain");
        assertEquals(result5, plainResult);
    }

    @Test
    void testJsonJson() throws Exception {
        var result6 = Differ.generate(JASONFILE1, JASONFILE2, "json");
        ObjectMapper objectmapper = new ObjectMapper();
        List<Map<String, Object>> mapJson
                = objectmapper.readValue(result6, new TypeReference<>() { });
        List<Map<String, Object>> actualJson
                = objectmapper.readValue(jasonResult, new TypeReference<>() { });
        assertEquals(mapJson, actualJson);
    }

    @Test
    void testYamlJson() throws Exception {
        var result7 = Differ.generate(YAMLFILE1, YAMLFILE2, "json");
        ObjectMapper objectmapper = new ObjectMapper();
        List<Map<String, Object>> mapYaml
                = objectmapper.readValue(result7, new TypeReference<>() { });
        List<Map<String, Object>> actualYaml
                = objectmapper.readValue(jasonResult, new TypeReference<>() { });
        assertEquals(mapYaml, actualYaml);
    }
}
