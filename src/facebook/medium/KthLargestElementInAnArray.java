package facebook.medium;

import java.util.Arrays;
import java.util.PriorityQueue;

// https://leetcode.com/problems/kth-largest-element-in-an-array/

// 215

public class KthLargestElementInAnArray {

    // minHeap, go through the array and keep the minHeap'size as k at most
    // then the top element on the minHeap will be the smallest among the top k largest
    // return it
    // O(NlgN) + O(K)
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException();
        }
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int n: nums) {
            minHeap.offer(n);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        return minHeap.poll();
    }
    
    // sort the array
    // O(NlgN) + O(1)
    public int findKthLargestII(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException();
        }
        Arrays.sort(nums);
        return nums[nums.length - k];
    }
    
    // divide conquer based on quick sort
    // O(N) + O(1)
    public int findKthLargestIII(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException();
        }
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int pivot = partition(nums, left, right);
            if (pivot == k - 1) {
                break;
            } else if (pivot < k - 1) {
                left = pivot + 1;
            } else {
                right = pivot - 1;
            }
        }
        return nums[k - 1];
    }
    public int partition(int[] nums, int left, int right) {
        int i = left - 1;
        int j = right;
        while (true) {
            while (nums[++i] > nums[right]);
            while (j > 0 && nums[--j] < nums[right]);
            if (i >= j) {
                break;
            } else {
                swap(nums, i, j);
            }
        }
        swap(nums, i, right);
        return i;
    }
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
