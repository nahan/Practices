package facebook.medium;

// https://leetcode.com/problems/h-index-ii/

// 275

import java.util.Arrays;

/**
 * Created by Han on 10/15/16.
 */
public class HIndexII {

    // a binary search solution
    // because the given array is sorted
    // so we can convert this problem to:
    // find the largest index, from there
    // the number of elements to the end is less than the citation on this index
    // a corner case in this solution is: [0, 0, 0]
    // in this case, the left will always add to 1 till it hits the last index: 2
    // but no more element left, so we need to add 1 to left so it becomes 3
    // then return citations.length - left = 0
    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) {
            return 0;
        }
        int left = 0;
        int right = citations.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (citations[mid] >= citations.length - mid) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        if (citations[left] < citations.length - left) {
            return citations.length - left - 1;
        }
        return citations.length - left;
    }

    public static void main(String[] args) {
        HIndexII solution = new HIndexII();
        int[] t1 = {};
        int[] t2 = {0};
        int[] t3 = {1};
        int[] t4 = {0, 2, 5, 7, 9};
        int[] t5 = {0, 0, 1, 2, 3, 4, 5};

        System.out.println(Arrays.toString(t1) + " -> " + solution.hIndex(t1));
        System.out.println(Arrays.toString(t2) + " -> " + solution.hIndex(t2));
        System.out.println(Arrays.toString(t3) + " -> " + solution.hIndex(t3));
        System.out.println(Arrays.toString(t4) + " -> " + solution.hIndex(t4));
        System.out.println(Arrays.toString(t5) + " -> " + solution.hIndex(t5));
    }
}
