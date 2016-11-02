package facebook.point;

// https://leetcode.com/problems/word-break-ii/
// 140

import java.util.*;

/**
 * Created by Han on 11/2/16.
 */
public class WordBreakII {

    public List<String> wordBreak(String s, Set<String> wordDict) {
        List<String> result = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        result = backtracking(wordDict, s, map);
        return result;
    }

    private List<String> backtracking(Set<String> dict, String s, Map<String, List<String>> map) {
        if (map.containsKey(s)) {
            return map.get(s);
        }
        List<String> result = new ArrayList<>();
        if (s.isEmpty()) {
            result.add("");
            return result;
        }
        for (String word: dict) {
            if (s.startsWith(word)) {
                List<String> sub = backtracking(dict, s.substring(word.length()), map);
                for (String item: sub) {
                    result.add((word + " " + item).trim());
                }
            }
        }
        map.put(s, result);
        return result;
    }

    public static void main(String[] args) {
        WordBreakII solution = new WordBreakII();

        String[] array = {"a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa"};
        Set<String> set = new HashSet<>();
        for (String s: array) {
            set.add(s);
        }

        String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaa";

        System.out.println(solution.wordBreak(s, set));
    }
}
