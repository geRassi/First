import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

class HelloWorldApp {
    public static void main(String[] args) {

        System.out.println(fincMostUsedCharacter("aaabbbcccfffgfyeeeeee"));
    }

    private static Character fincMostUsedCharacter(String x) {
        Map<Character, Integer> counter = new HashMap<>();

        int c;
        for (int i = 0; i < x.length(); i++) {
            if (!counter.containsKey(x.charAt(i))) {
                c = 0;
            } else {
                c = counter.get(x.charAt(i));
            }
            counter.put(x.charAt(i), c + 1);
        }


        return counter.entrySet().stream().max((p1, p2) -> getCompare(p1, p2)).get().getKey();
        //return counter.entrySet().stream().max((p1, p2) -> Integer.compare( p1.getValue(), p2.getValue())).get().getKey();
        //return counter.entrySet().stream().max(Comparator.comparingInt(Map.Entry::getValue)).get().getKey();
    }

    private static int getCompare(Map.Entry<Character, Integer> p1, Map.Entry<Character, Integer> p2) {
        if (p1.getValue() == p2.getValue())
            return 0;

        if (p1.getValue() > p2.getValue())
            return 1;

        return -1;
    }
}

