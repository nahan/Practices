package facebook.medium;

import java.util.*;

// https://leetcode.com/problems/combination-sum-iv/

// 377

public class CombinationSumIV {

    // dp solution
    // Sum(n) = Sum(n - 1) + Sum(n - 2) + ... + Sum(1)
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        Arrays.sort(nums);
        dp[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int n: nums) {
                if (n > i) {
                    break;
                }
                dp[i] += dp[i - n];
            }
        }
        return dp[target];
    }
}
