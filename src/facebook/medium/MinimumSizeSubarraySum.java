package facebook.medium;

public class MinimumSizeSubarraySum {
    
    // 1. brute-force solution, O(N^2) TLE
    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int length = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int sum = nums[i];
            for (int j = i + 1; j <= nums.length; j++) {
                if (j < nums.length && sum < s) {
                    sum += nums[j];
                    continue;
                } else if (sum >= s) {
                    length = Math.min(length, j - i);
                    break;
                }
            }
        }
        return length == Integer.MAX_VALUE ? 0 : length;
    }
    
    // 2. window slice solution, O(N)
    public int minSubArrayLenII(int s, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int length = Integer.MAX_VALUE;
        int start = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            while (sum >= s) {
                length = Math.min(length, i - start + 1);
                sum -= nums[start++];
            }
        }
        return length == Integer.MAX_VALUE ? 0 : length;
    }

}
