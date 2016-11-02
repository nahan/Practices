package facebook.point;

// https://leetcode.com/problems/median-of-two-sorted-arrays/
// 4

/**
 * Created by Han on 11/2/16.
 */
public class MedianOfTwoSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }
        int left = 0;
        int right = nums1.length;
        int mid = (nums1.length + nums2.length + 1) / 2;
        while (left <= right) {
            int i = (left + right) / 2;
            int j = mid - i;
            if (j > 0 && i < nums1.length && nums2[j - 1] > nums1[i]) {
                left = i + 1;
            } else if (i > 0 && j < nums2.length && nums1[i - 1] > nums2[j]) {
                right = i - 1;
            } else {
                int leftMax = Integer.MIN_VALUE;
                if (i == 0) {
                    leftMax = nums2[j - 1];
                } else if (j == 0) {
                    leftMax = nums1[i - 1];
                } else {
                    leftMax = Math.max(nums1[i - 1], nums2[j - 1]);
                }
                if ((nums1.length + nums2.length) % 2 == 1) {
                    return leftMax;
                }
                int rightMin = Integer.MAX_VALUE;
                if (i == nums1.length) {
                    rightMin = nums2[j];
                } else if (j == nums2.length) {
                    rightMin = nums1[i];
                } else {
                    rightMin = Math.min(nums1[i], nums2[j]);
                }
                return (double) (leftMax + rightMin) / 2;
            }
        }
        return -1;
    }

}
