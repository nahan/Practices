package facebook.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/3sum/

// 15

public class TreeSum {
    
    // time complexity O(N^2)
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return result;
        }
        // return element not index, so we can sort it
        Arrays.sort(nums);
        // first element must not be a positive integer
        for (int i = 0; i < nums.length - 2 && nums[i] <= 0; i++) {
            // skip same element
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                if (nums[left] + nums[right] > (-1) * nums[i]) {
                    // skip same element
                    while (right > 0 && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    right--;
                } else if (nums[left] + nums[right] < (-1) * nums[i]) {
                    // skip same element
                    while (left < nums.length - 1 && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    left++;
                } else {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    // skip same element
                    while (right > 0 && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    right--;
                    // skip same element
                    while (left < nums.length - 1 && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    left++;
                }
            }
        }
        return result;
    }
}
