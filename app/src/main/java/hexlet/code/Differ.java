package hexlet.code;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

import java.util.List;
import java.util.ArrayList;
import java.util.TreeSet;
import java.util.LinkedHashMap;

public class Differ {

        public static String generate(String filepath1, String filepath2, String format) throws IOException {

            Path path1 = Paths.get(filepath1);
        Path path2 = Paths.get(filepath2);
            String fileFormat = filepath1.substring(filepath1.lastIndexOf(".") + 1);
        String file1 = Files.readString(path1);
        String file2 = Files.readString(path2);

            Map<String, Object> sortedMap1 = Parser.parseFile(file1, fileFormat);
            Map<String, Object> sortedMap2 = Parser.parseFile(file2, fileFormat);


            System.out.println(format);
            List<Map<String, Object>> different = CalcDiff.getDiff(sortedMap1, sortedMap2);
            return Formatter.diffResult(different, format);
        }


}
