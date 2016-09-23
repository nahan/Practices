package godaddy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class CountDuplicates {
    public int count(int[] nums) {
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i: nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        for (int k: map.keySet()) {
            if (map.get(k) > 1) {
                count++;
            }
        }
        return count;
    }
    
    public static void main(String[] args) {
        CountDuplicates solution = new CountDuplicates();
        int[] nums = new int[10];
        Random rand = new Random();
        for (int i = 0; i < nums.length; i++) {
            nums[i] = rand.nextInt(11);
        }
        System.out.println(Arrays.toString(nums));
        System.out.println(solution.count(nums));
    }
}
