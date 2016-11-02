package facebook.point;

// https://leetcode.com/problems/longest-increasing-subsequence/
// 300

//        Given [10, 9, 2, 5, 3, 7, 101, 18],
//        The longest increasing subsequence is [2, 3, 7, 101], therefore the length is 4

/**
 * Created by Han on 11/2/16.
 */
public class LongestIncreasingSubsequence {

    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return nums == null ? 0 : nums.length == 0 ? 0 : 1;
        }
        int[] lis = new int[nums.length];
        int end = 0;
        lis[end] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > lis[end]) {
                end++;
                lis[end] = nums[i];
            } else {
                int pos = this.findFirstLarger(lis, 0, end, nums[i]);
                lis[pos] = nums[i];
            }
        }
        return end + 1;
    }
    public int findFirstLarger(int[] nums, int start, int end, int target) {
        if (start == end) {
            return start;
        } else {
            int mid = start + (end - start) / 2;
            if (nums[mid] < target) {
                return this.findFirstLarger(nums, mid + 1, end, target);
            } else {
                return this.findFirstLarger(nums, start, mid, target);
            }
        }
    }
}
