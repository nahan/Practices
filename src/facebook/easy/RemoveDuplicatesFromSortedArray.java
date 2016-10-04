package facebook.easy;

// https://leetcode.com/problems/remove-duplicates-from-sorted-array/

// 26

public class RemoveDuplicatesFromSortedArray {

    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int last = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[last]) {
                nums[++last] = nums[i];
            }
        }
        return last + 1;
    }
    
}
