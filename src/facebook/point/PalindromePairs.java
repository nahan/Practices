package facebook.point;

// https://leetcode.com/problems/palindrome-pairs/
// 336

import java.util.*;

/**
 * Created by Han on 11/2/16.
 */
public class PalindromePairs {

    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> result = new ArrayList<>();
        if (words == null || words.length < 2) {
            return result;
        }
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            map.put(words[i], i);
        }
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j <= words[i].length(); j++) {
                String s1 = words[i].substring(0, j);
                String s2 = words[i].substring(j);
                if (isPalindrome(s1)) {
                    String s2reverse = new StringBuilder(s2).reverse().toString();
                    if (map.containsKey(s2reverse) && map.get(s2reverse) != i) {
                        result.add(Arrays.asList(map.get(s2reverse), i));
                    }
                }
                if (isPalindrome(s2) && s2.length() != 0) {
                    String s1reverse = new StringBuilder(s1).reverse().toString();
                    if (map.containsKey(s1reverse) && map.get(s1reverse) != i) {
                        result.add(Arrays.asList(i, map.get(s1reverse)));
                    }
                }
            }
        }
        return result;
    }
    private boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) {
                return false;
            }
        }
        return true;
    }

}
