package facebook.medium;

// https://leetcode.com/problems/subsets/

// 78

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Han on 10/7/16.
 */
public class Subsets {

    // 1. dfs using HashSet
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null) {
            return result;
        }
        Set<List<Integer>> set = new HashSet<>();
        List<Integer> item = new ArrayList<>();
        dfs(set, item, nums, 0);
        result.addAll(set);
        return result;
    }
    public void dfs(Set<List<Integer>> set, List<Integer> item, int[] nums, int index) {
        set.add(new ArrayList<>(item));
        if (index == nums.length) {
            return;
        }
        for (int i = index; i < nums.length; i++) {
            item.add(nums[i]);
            dfs(set, item, nums, i + 1);
            item.remove(item.size() - 1);
        }
    }

    // 2. dfs using List
    public List<List<Integer>> subsetsII(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null) {
            return result;
        }
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
        }
    }
}
