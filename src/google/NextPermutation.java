package google;

import java.util.Arrays;

public class NextPermutation {
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        if (i == -1) {
            reverse(nums, 0, nums.length - 1);
            return;
        }
        int j = nums.length - 1;
        while (j >= 0 && nums[j] <= nums[i]) {
            j--;
        }
        swap(nums, i, j);
        reverse(nums, i + 1, nums.length - 1);
    }
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    private void reverse(int[] nums, int i, int j) {
        while (i < j) {
            swap(nums, i++, j--);
        }
    }
    
    public static void main(String[] args) {
        NextPermutation solution = new NextPermutation();
        int[] n1 = {1};
        int[] n2 = {1,0,2,4};
        int[] n3 = {1,0,4,2};
        int[] n4 = {1,2,0,4};
        int[] n5 = {1,2,4,0};
        
        System.out.println(Arrays.toString(n1));
        System.out.println(Arrays.toString(n2));
        System.out.println(Arrays.toString(n3));
        System.out.println(Arrays.toString(n4));
        System.out.println(Arrays.toString(n5));
        
        solution.nextPermutation(n1);
        solution.nextPermutation(n2);
        solution.nextPermutation(n3);
        solution.nextPermutation(n4);
        solution.nextPermutation(n5);
        
        System.out.println(Arrays.toString(n1));
        System.out.println(Arrays.toString(n2));
        System.out.println(Arrays.toString(n3));
        System.out.println(Arrays.toString(n4));
        System.out.println(Arrays.toString(n5));
        
    }
}
