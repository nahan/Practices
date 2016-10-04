package facebook.easy;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/two-sum/

// 1
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        int[] result = {-1, -1};
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                result[0] = map.get(target - nums[i]);
                result[1] = i;
                return result;
            }
            map.put(nums[i], i);
        }
        return result;
    }
    
}
