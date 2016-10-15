package facebook.medium;

// https://leetcode.com/problems/random-pick-index/

// 398

import java.util.*;

/**
 * Created by Han on 10/15/16.
 */
public class RandomPickIndex {

    // 1. use HashMap, store index for a certain number
    // Time: O(N), Space: O(N)
    // Memory Limit Exceeded
    private Map<Integer, List<Integer>> map;
    Random rand = new Random();

    public RandomPickIndex(int[] nums) {
        map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.putIfAbsent(nums[i], new ArrayList<>());
            map.get(nums[i]).add(i);
        }
    }

    public int pick(int target) {
        List<Integer> list = map.get(target);
        int i = rand.nextInt(list.size());
        return list.get(i);
    }

    // 2. only store target's index in one ArrayList
    // Time: O(N), Space: worst O(N)
    int[] nums;
    Random randII;

    public RandomPickIndex(int[] nums, boolean secondSolution) {
        this.nums = nums;
        randII = new Random();
    }

    public int pickII(int target) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                list.add(i);
            }
        }
        int index = randII.nextInt(list.size());
        return list.get(index);
    }

    // 3. Reservoir Sampling
    // Time: O(N), Space: O(1)
    int[] numsIII;
    Random randIII;

    public RandomPickIndex(int[] nums, String thirdSolution) {
        this.numsIII = nums;
        randIII = new Random();
    }

    public int pickIII(int target) {
        int index = -1;
        int count = 0;
        for (int i = 0; i < numsIII.length; i++) {
            if (numsIII[i] == target) {
                count++;
                if (randIII.nextInt(count) == 0) {
                    index = i;
                }
            }
        }
        return index;
    }

}
