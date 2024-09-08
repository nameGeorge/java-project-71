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
        var result = Differ.generate("src/test/resources/file3.yaml",
                "src/test/resources/file4.yaml", "stylish");
        Path path = Paths.get("src/test/resources/fileresult.txt");
        var actual = Files.readString(path);
        assertEquals(result, actual);
    }

    @Test
    void testYamlStylishBig() throws IOException {
        var result = Differ.generate("src/test/resources/file1.yaml",
                "src/test/resources/file2.yaml", "stylish");
        Path path = Paths.get("src/test/resources/ymlstlyshresult.txt");
        var actual = Files.readString(path);
        assertEquals(result, actual);
    }

    @Test
    void testJsonStylishBig() throws IOException {
        var result = Differ.generate("src/test/resources/file3.json",
                "src/test/resources/file4.json", "stylish");
        Path path = Paths.get("src/test/resources/ymlstlyshresult.txt");
        var actual = Files.readString(path);
        assertEquals(result, actual);
    }
}


