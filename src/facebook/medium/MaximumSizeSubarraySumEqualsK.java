package facebook.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Han on 10/6/16.
 */

//    https://leetcode.com/problems/maximum-size-subarray-sum-equals-k/
//
//    325

public class MaximumSizeSubarraySumEqualsK {

    // 1. brute-force solution O(N^2)
    public int maxSubArrayLen(int[] nums, int k) {
        int length = 0;
        if (nums == null || nums.length == 0) {
            return length;
        }
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum == k) {
                    length = Math.max(length, j - i + 1);
                }
            }
        }
        return length;
    }

    // 2. HashMap solution O(N);
    public int maxSubArrayLenII(int[] nums, int k) {
        int length = 0;
        if (nums == null || nums.length == 0) {
            return length;
        }
        Map<Integer, Integer> sum = new HashMap<>();
        int preSum = 0;
        for (int i = 0; i < nums.length; i++) {
            int curSum = preSum + nums[i];
            sum.putIfAbsent(curSum, i);
            if (curSum == k) {
                length = Math.max(length, i + 1);
            }
            if (sum.containsKey(curSum - k)) {
                length = Math.max(length, i - sum.get(curSum - k));
            }
            preSum = curSum;
        }
        return length;
    }
}
