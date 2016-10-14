package facebook.medium;

// https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/

// 80

/**
 * Created by Han on 10/14/16.
 */
public class RemoveDuplicatesFromSortedArrayII {

    // 1. basic problem: no duplicate
    public int removeDuplicates1(int[] nums) {
        if (nums == null) {
            return 0;
        }
        int start = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[start] != nums[i]) {
                nums[++start] = nums[i];
            }
        }
        return start + 1;
    }

    // 2. followup: What if duplicates are allowed at most twice?
    // use a boolean to track if exists duplicate
    public int removeDuplicates(int[] nums) {
        if (nums == null) {
            return 0;
        }
        if (nums.length < 3) {
            return nums.length;
        }
        int start = 0;
        boolean dup = false;
        for (int i = 1; i < nums.length; i++) {
            if (nums[start] == nums[i]) {
                if (!dup) {
                    nums[++start] = nums[i];
                    dup = true;
                }
            } else {
                nums[++start] = nums[i];
                dup = false;
            }
        }
        return start + 1;
    }
}
