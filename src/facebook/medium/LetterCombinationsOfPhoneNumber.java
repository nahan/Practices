package facebook.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Han on 10/6/16.
 */

//    https://leetcode.com/problems/letter-combinations-of-a-phone-number/
//
//    17

public class LetterCombinationsOfPhoneNumber {

    // 1. using HashMap
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.isEmpty()) {
            return result;
        }
        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        for (int i = 0; i < digits.length(); i++) {
            char c = digits.charAt(i);
            if (!map.containsKey(c)) {
                return result;
            }
        }
        StringBuilder builder = new StringBuilder();
        dfs(result, builder, map, digits, 0);
        return result;
    }
    public void dfs(List<String> result, StringBuilder builder, Map<Character, String> map, String digits, int index) {
        if (index == digits.length()) {
            result.add(builder.toString());
            return;
        }
        char c = digits.charAt(index);
        String s = map.get(c);
        for (int i = 0; i < s.length(); i++) {
            int length = builder.length();
            builder.append(s.charAt(i));
            dfs(result, builder, map, digits, index + 1);
            builder.setLength(length);
        }
    }

    // 2. using String[]
    public List<String> letterCombinationsII(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.isEmpty()) {
            return result;
        }
        String[] map = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        for (int i = 0; i < digits.length(); i++) {
            char c = digits.charAt(i);
            if (map[c - '0'].isEmpty()) {
                return result;
            }
        }
        StringBuilder builder = new StringBuilder();
        dfsII(result, builder, map, digits, 0);
        return result;
    }
    public void dfsII(List<String> result, StringBuilder builder, String[] map, String digits, int index) {
        if (index == digits.length()) {
            result.add(builder.toString());
            return;
        }
        String s = map[digits.charAt(index) - '0'];
        for (int i = 0; i < s.length(); i++) {
            int length = builder.length();
            builder.append(s.charAt(i));
            dfsII(result, builder, map, digits, index + 1);
            builder.setLength(length);
        }
    }

    public static void main(String[] args) {
        LetterCombinationsOfPhoneNumber solution = new LetterCombinationsOfPhoneNumber();
        System.out.println(solution.letterCombinations("23"));
        System.out.println(solution.letterCombinationsII("23"));
    }

}
