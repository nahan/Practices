package facebook.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://leetcode.com/problems/anagrams/

// 49

public class GroupAnagrams {
    
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        if (strs == null || strs.length == 0) {
            return result;
        }
        Map<String, List<String>> map = new HashMap<>();
        for (String s: strs) {
            char[] c = s.toCharArray();
            Arrays.sort(c);
            String key = new String(c);
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(s);
        }
        for (String key: map.keySet()) {
            result.add(map.get(key));
        }
        return result;
    }
}
