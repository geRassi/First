





import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountCharacters {

    static int getCompare(Map.Entry<Character, Integer> p1, Map.Entry<Character, Integer> p2) {
        if (p1.getValue() == p2.getValue())
            return 0;

        if (p1.getValue() > p2.getValue())
            return 1;

        return -1;
    }


    public static Character fincMostUsedCharacter(String x) {

        Map<Character, Integer> counter = countCharacters(x);

        return counter.entrySet().stream().max((p1, p2) -> CountCharacters.getCompare(p1, p2)).get().getKey();
        //return counter.entrySet().stream().max((p1, p2) -> getCompare(p1, p2)).get().getKey();
        //return counter.entrySet().stream().max((p1, p2) -> Integer.compare( p1.getValue(), p2.getValue())).get().getKey();
        //return counter.entrySet().stream().max(Comparator.comparingInt(Map.Entry::getValue)).get().getKey();
    }

    private static Map<Character, Integer> countCharacters(String str) {
        Map<Character, Integer> counter = new HashMap<>();

        str.chars().forEach(b -> getPut(counter, (char) b));

//        for (int i = 0; i < str.length(); i++)
//            counter.put(str.charAt(i), counter.getOrDefault(str.charAt(i), 0) + 1);

        return counter;
    }

    private static Integer getPut(Map<Character, Integer> counter, char b) {
        return counter.put(b, counter.getOrDefault(b, 0) + 1);
    }

}
