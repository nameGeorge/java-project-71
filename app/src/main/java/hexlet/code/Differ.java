package hexlet.code;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;

public class Differ {

    public static String generate(String path1, String path2) throws Exception {
        return generate(path1, path2, "stylish");
    }

    public static String generate(String path1, String path2, String format) throws Exception {
        String data1 = readFile(path1);
        String data2 = readFile(path2);

        String format1 = getFileFormat(path1);
        String format2 = getFileFormat(path2);

        Parser parser = new Parser();
        var mapData1 = Parser.parseFile(data1, format1);
        var mapData2 = Parser.parseFile(data2, format2);

        var diff = CalcDiff.getDiff(mapData1, mapData2);

        return Formatter.diffResult(diff, format);
    }

    private static String readFile(String path) throws Exception {
        Path filePath = Paths.get(path);
        if (!Files.exists(filePath) || !Files.isReadable(filePath)) {
            throw new IOException("File does not exist or is not readable: " + path);
        }
        return new String(Files.readAllBytes(filePath));
    }

    private static String getFileFormat(String path) {
        return path.substring(path.lastIndexOf(".") + 1);
    }
}
