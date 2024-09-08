package hexlet.code;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;


class DifferTest {
    @Test
    void testJson() throws IOException {
        var result = Differ.generate("src/test/resources/file1.json",
                "src/test/resources/file2.json", "json");
        Path path = Paths.get("src/test/resources/fileresult.txt");
        var actual = Files.readString(path);
        assertEquals(result, actual);
    }

    @Test
    void testYaml() throws IOException {
        var result = Differ.generate("src/test/resources/file3.yaml",
                "src/test/resources/file4.yaml", "yaml");
        Path path = Paths.get("src/test/resources/fileresult.txt");
        var actual = Files.readString(path);
        assertEquals(result, actual);
    }
}