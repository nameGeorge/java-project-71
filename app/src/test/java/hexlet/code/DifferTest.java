package hexlet.code;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;


class DifferTest {
    @Test
    void testJsonStylish() throws IOException {
        var result = Differ.generate("src/test/resources/file1.json",
                "src/test/resources/file2.json", "stylish");
        Path path = Paths.get("src/test/resources/fileresult.txt");
        var actual = Files.readString(path);
        assertEquals(result, actual);
    }

    @Test
    void testYamlStylish() throws IOException {
        var result1 = Differ.generate("src/test/resources/file3.yaml",
                "src/test/resources/file4.yaml", "stylish");
        Path path = Paths.get("src/test/resources/fileresult.txt");
        var actual1 = Files.readString(path);
        assertEquals(result1, actual1);
    }

    @Test
    void testYamlStylishBig() throws IOException {
        var result2 = Differ.generate("src/test/resources/file1.yaml",
                "src/test/resources/file2.yaml", "stylish");
        Path path = Paths.get("src/test/resources/ymlstlyshresult.txt");
        var actual2 = Files.readString(path);
        assertEquals(result2, actual2);
    }

    @Test
    void testJsonStylishBig() throws IOException {
        var result3 = Differ.generate("src/test/resources/file3.json",
                "src/test/resources/file4.json", "stylish");
        Path path = Paths.get("src/test/resources/ymlstlyshresult.txt");
        var actual3 = Files.readString(path);
        assertEquals(result3, actual3);
    }

    @Test
    void testJsonPlain() throws IOException {
        var result4 = Differ.generate("src/test/resources/file1.json",
                "src/test/resources/file2.json", "plain");
        Path path = Paths.get("src/test/resources/Plainresult2.txt");
        var actual4 = Files.readString(path);
        assertEquals(result4, actual4);
    }

    @Test
    void testYamlPlain() throws IOException {
        var result5 = Differ.generate("src/test/resources/file1.yaml",
                "src/test/resources/file2.yaml", "plain");
        Path path = Paths.get("src/test/resources/Plainresult.txt");
        var actual5 = Files.readString(path);
        assertEquals(result5, actual5);
    }

    @Test
    void testJsonJson() throws IOException {
        var result6 = Differ.generate("src/test/resources/file1.json",
                "src/test/resources/file2.json", "json");
        Path path = Paths.get("src/test/resources/Jsonresult2.txt");
        var actual6 = Files.readString(path);
        assertEquals(result6, actual6);
    }

    @Test
    void testYamlJson() throws IOException {
        var result7 = Differ.generate("src/test/resources/file1.yaml",
                "src/test/resources/file2.yaml", "json");
        Path path = Paths.get("src/test/resources/Jsonresult.txt");
        var actual7 = Files.readString(path);
        assertEquals(result7, actual7);
    }
}
