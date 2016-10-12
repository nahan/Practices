package facebook.hard;

import java.util.*;

// https://leetcode.com/problems/longest-consecutive-sequence/

// 128

public class LongestConsecutiveSequence {
    
    public int longestConsecutive(int[] nums) {
        int length = 1;
        if (nums == null || nums.length < 2) {
            return length;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int n: nums) {
            if (map.containsKey(n)) {
                continue;
            }
            int left = map.getOrDefault(n - 1, 0);
            int right = map.getOrDefault(n + 1, 0);
            int range = left + right + 1;
            length = Math.max(length, range);
            map.put(n, range);
            map.put(n - left, range);
            map.put(n + right, range);
        }
        return length;
    }

}
