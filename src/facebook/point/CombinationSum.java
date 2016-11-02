package facebook.point;

// https://leetcode.com/problems/combination-sum/
// 39

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Han on 11/2/16.
 */
public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        if (target < candidates[0]) {
            System.out.println("here");
            return result;
        }
        List<Integer> item = new ArrayList<>();
        backtracking(result, item, candidates, target, 0);
        return result;
    }

    private void backtracking(List<List<Integer>> result, List<Integer> item, int[] nums, int target, int index) {
        if (target == 0 && !result.contains(item)) {
            result.add(new ArrayList<Integer>(item));
        }
        for (int i = index; i < nums.length; i++) {
            if (target >= nums[i]) {
                item.add(nums[i]);
                backtracking(result, item, nums, target - nums[i], i);
                item.remove(item.get(item.size() - 1));
            }
        }
    }

    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        Arrays.sort(nums);
        for (int i = 1; i <= target; i++) {
            for (int n: nums) {
                if (i >= n) {
                    dp[i] += dp[i - n];
                }
            }
        }
        return dp[target];
    }
}
