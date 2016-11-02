package facebook.point;


// https://leetcode.com/problems/maximum-subarray/
// 53

/**
 * Created by Han on 11/2/16.
 */
public class MaximumSubarray {

    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length < 2) {
            return nums == null || nums.length == 0 ? 0 : nums[0];
        }
        int max = nums[0];
        int curMax = nums[0];
        for (int i = 1; i < nums.length; i++) {
            curMax = Math.max(nums[i], curMax + nums[i]);
            max = Math.max(max, curMax);
        }
        return max;
    }

    // divide conquer
    public int maxSubArrayII(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        return maxSubArray(nums, 0, nums.length - 1);
    }
    private int maxSubArray(int[] nums, int left, int right) {
        if (left == right) {
            return nums[left];
        }
        int mid = (left + right) / 2;
        int leftAns = maxSubArray(nums, left, mid);
        int rightAns = maxSubArray(nums, mid + 1, right);
        int leftMax = nums[mid];
        int rightMax = nums[mid + 1];
        int temp = 0;
        for (int i = mid; i >= left; i--) {
            temp += nums[i];
            leftMax = Math.max(leftMax, temp);
        }
        temp = 0;
        for (int i = mid + 1; i <= right; i++) {
            temp += nums[i];
            rightMax = Math.max(rightMax, temp);
        }
        return Math.max(Math.max(leftAns, rightAns), leftMax + rightMax);
    }

}
