package facebook.medium;

// https://leetcode.com/problems/increasing-triplet-subsequence/

// 334

public class IncreasingTripletSubsequence {

    // use two variables to track the first and second minimum value
    // if there is a value bigger than them, then return true
    // O(N)
    public boolean increasingTriplet(int[] nums) {
        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= first) {
                first = nums[i];
            } else if (nums[i] <= second) {
                second = nums[i];
            } else {
                return true;
            }
        }
        return false;
    }
}
