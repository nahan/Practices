package facebook.medium;

// https://leetcode.com/problems/subsets-ii/

// 90

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Han on 10/7/16.
 */
public class SubsetsII {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null) {
            return result;
        }
        Arrays.sort(nums);
        List<Integer> item = new ArrayList<>();
        dfs(result, item, nums, 0);
        return result;
    }
    public void dfs(List<List<Integer>> result, List<Integer> item, int[] nums, int index) {
        result.add(new ArrayList<>(item));
        if (index == nums.length) {
            return;
        }
        for (int i = index; i < nums.length; i++) {
            item.add(nums[i]);
            dfs(result, item, nums, i + 1);
            item.remove(item.size() - 1);
            // there is no need to process a same element in the rest
            while (i < nums.length - 1 && nums[i] == nums[i + 1]) {
                i++;
            }
        }
    }
}
