package facebook.easy;

// https://leetcode.com/problems/move-zeroes/

// 283

public class MoveZeroes {
    
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                swap(nums, index++, i);
            }
        }
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
