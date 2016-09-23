package godaddy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MissingWords {
    public String[] missingWords(String s, String t) {
        String[] a1 = s.split(" ");
        String[] a2 = t.split(" ");
        List<String> list = new ArrayList<>();
        Set<String> set = new HashSet<>();
        for (String item: a2) {
            set.add(item);
        }
        for (String item: a1) {
            if (set.add(item)) {
                list.add(item);
            }
        }
        String[] result = new String[list.size()];
        return list.toArray(result);
    }
    public static void main(String[] args) {
        MissingWords solution = new MissingWords();
        System.out.println(Arrays.toString(solution.missingWords("I am a good boy", "am good boy")));
        System.out.println(Arrays.toString(solution.missingWords("Hello World improve programming", "World programming")));
    }
}
