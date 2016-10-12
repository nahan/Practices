package facebook.hard;

import java.util.*;

// https://leetcode.com/problems/minimum-window-substring/

// 76

public class MinimumWindowSubstring {
    
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.isEmpty() || t.isEmpty() || t.length() > s.length()) {
            return "";
        }
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int start = 0;
        int minLength = s.length() + 1;
        int first = 0;
        int total = t.length();
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (map.containsKey(cur)) {
                if (map.get(cur) > 0) {
                    total--;
                }
                map.put(cur, map.get(cur) - 1);
            }
            while (total == 0) {
                if (i - first + 1 <= minLength) {
                    minLength = i - first + 1;
                    start = first;
                }
                char head = s.charAt(first++);
                if (map.containsKey(head)) {
                    map.put(head, map.get(head) + 1);
                    if (map.get(head) > 0) {
                        total++;
                    }
                }
            }
        }
        if (minLength > s.length()) {
            return "";
        }
        return s.substring(start, start + minLength);
    }

}
