package facebook.medium;

// https://leetcode.com/problems/sort-colors/

// 75

/**
 * Created by Han on 10/6/16.
 */
public class SortColors {

    // 1. two-pass solution
    public void sortColors(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }
        int red = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                swap(nums, red++, i);
            }
        }
        int blue = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] == 2) {
                swap(nums, blue--, i);
            }
        }
    }
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    // 2. one-pass solution
    public void sortColorsII(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }
        int red = 0;
        int white = 0;
        int blue = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                nums[blue++] = 2;
                nums[white++] = 1;
                nums[red++] = 0;
            } else if (nums[i] == 1) {
                nums[blue++] = 2;
                nums[white++] = 1;
            } else {
                nums[blue++] = 2;
            }
        }
    }
}
