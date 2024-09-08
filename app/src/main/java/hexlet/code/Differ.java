package hexlet.code;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

import java.util.List;
import java.util.ArrayList;
import java.util.TreeSet;
import java.util.LinkedHashMap;

public class Differ {

        public static String generate(String filepath1, String filepath2, String format) throws IOException {

            Path path1 = Paths.get(filepath1);
        Path path2 = Paths.get(filepath2);
        String file1 = Files.readString(path1);
        String file2 = Files.readString(path2);

            Map<String, Object> sortedMap1 = Parser.parseFile(file1, format);
            Map<String, Object> sortedMap2 = Parser.parseFile(file2, format);


        var keys = new TreeSet<>();
        keys.addAll(sortedMap1.keySet());
        keys.addAll(sortedMap2.keySet());

        String result = "{\n";
        List<Map<String, Object>> result1 = new ArrayList<>();
        for (var key : keys) {
            Map<String, Object> line = new LinkedHashMap<>();
            line.put("key", key.toString());
            if (sortedMap1.containsKey(key) && sortedMap2.containsKey(key)) {
                if (sortedMap1.get(key).equals(sortedMap2.get(key))) {
                    line.put("type", "unchange");
                    line.put("value", sortedMap1.get(key));
                    result += "  " + key + ": " + sortedMap1.get(key) + "\n";
                } else {
                    line.put("type", "change");
                    line.put("oldvalue", sortedMap1.get(key));
                    line.put("newvalue", sortedMap2.get(key));
                    result += "- " + key + ": " + sortedMap1.get(key) + "\n";
                    result += "+ " + key + ": " + sortedMap2.get(key) + "\n";
                }
            }
            if (!sortedMap1.containsKey(key) && sortedMap2.containsKey(key)) {
                line.put("type", "added");
                line.put("newvalue", sortedMap2.get(key));
                result += "+ " + key + ": " + sortedMap2.get(key) + "\n";
            }
            if (sortedMap1.containsKey(key) && !sortedMap2.containsKey(key)) {
                line.put("type", "deleted");
                line.put("oldvalue", sortedMap1.get(key));
                result += "- " + key + ": " + sortedMap1.get(key) + "\n";
            }
            result1.add(line);
        }
        return result + "}\n";
    }
}
