package facebook.point;

// https://leetcode.com/problems/search-for-a-range/
// 34

/**
 * Created by Han on 11/2/16.
 */
public class SearchRange {

    public int[] searchRange(int[] nums, int target) {

        int[] result = {-1, -1};
        int i = 0;
        int j = nums.length - 1;
        while (i < j) {
            int mid = (i + j) / 2;
            if (nums[mid] == target) {
                j = mid;
            } else if (nums[mid] < target) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }
        if (nums[i] != target) {
            return result;
        }
        result[0] = i;
        i = 0;
        j = nums.length - 1;
        while (i < j) {
            int mid = (i + j) / 2 + 1;
            if (nums[mid] == target) {
                i = mid;
            } else if (nums[mid] < target) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }
        result[1] = i;
        return result;
    }
}
