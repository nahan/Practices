package facebook.hard;

public class SearchInRotatedSortedArray {

    // binary search O(lgN)
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            // if mid is target then return mid
            if (nums[mid] == target) {
                return mid;
            }
            // if first half is sorted
            if (nums[mid] >= nums[right]) {
                if (target > nums[mid] || target < nums[left]) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            } else {
            // if second half is sorted
                if (target < nums[mid] || target > nums[right]) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
        }
        return nums[left] == target ? left : -1;
    }
}
