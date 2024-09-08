package hexlet.code;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

//import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

public class Differ {
    public static String generate(String filepath1, String filepath2) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Path path1 = Paths.get(filepath1);
        Path path2 = Paths.get(filepath2);
        String file1 = Files.readString(path1);
        String file2 = Files.readString(path2);
//        File file1 = new File("file1.json");
//        File file2 = new File("file2.json");
        Map<String, Object> map1
                = objectMapper.readValue(file1, new TypeReference<Map<String,Object>>(){});
        Map<String, Object> map2
                = objectMapper.readValue(file2, new TypeReference<Map<String,Object>>(){});
        Map<String, Object> sortedMap1 = new TreeMap<>(map1);
        Map<String, Object> sortedMap2 = new TreeMap<>(map2);

//        System.out.println(sortedMap1);
//        System.out.println(sortedMap2);
//        System.out.println(sortedMap1.keySet());
//        System.out.println(sortedMap2.keySet());
        var keys = new TreeSet<>();
        keys.addAll(sortedMap1.keySet());
        keys.addAll(sortedMap2.keySet());
//        System.out.println(keys);
        String result = "";
        for (var key : keys) {
            if (sortedMap1.containsKey(key) && sortedMap2.containsKey(key)) {
                if (sortedMap1.get(key).equals(sortedMap2.get(key))) {
                    result += "  " + key + " : " + sortedMap1.get(key) + "\n";
                    //System.out.println("  " + key + " : " + sortedMap1.get(key));
                } else {
                    result += "- " + key + " : " + sortedMap1.get(key) + "\n";
                    result += "+ " + key + " : " + sortedMap2.get(key) + "\n";
//                    System.out.println("- " + key + " : " + sortedMap1.get(key));
//                    System.out.println("+ " + key + " : " + sortedMap2.get(key));
                }
            }
            if (!sortedMap1.containsKey(key) && sortedMap2.containsKey(key)) {
                result += "+ " + key + " : " + sortedMap2.get(key) + "\n";
//                System.out.println("+ " + key + " : " + sortedMap2.get(key));
            }
            if (sortedMap1.containsKey(key) && !sortedMap2.containsKey(key)) {
                result += "- " + key + " : " + sortedMap1.get(key) + "\n";
//                System.out.println("- " + key + " : " + sortedMap1.get(key));
            }
        }
        return result;
    }
}