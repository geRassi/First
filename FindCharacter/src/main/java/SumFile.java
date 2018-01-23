import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class SumFile {

    public static Map<String, Integer> sum(String s) {

        return Arrays.stream(s.split("\\r?\\n"))
                .map((x) -> x.split("\\s")).collect(Collectors.toMap(x -> x[0].split("\\.")[1], x -> Integer.valueOf(x[1].split("MB")[0]), (x, y) -> x + y));
    }

//    private static void collect(String line, Map<String, Integer> collector) {
//
//        String[] verbs = line.split("\\s");
//        String suffix = verbs[0].split("\\.")[1];
//        String[] Size = verbs[1].split("MB");
//
//        collector.put(suffix, collector.getOrDefault(suffix, 0) + Integer.valueOf(Size[0]));
//    }
//
//    private static void collect2(String line, Map<String, Integer> collector) {
//
//        collector.put(line.split("\\s")[0].split("\\.")[1], collector.getOrDefault(line.split("\\s")[0].split("\\.")[1], 0) + Integer.valueOf(line.split("\\s")[1].split("MB")[0]));
//    }
}



