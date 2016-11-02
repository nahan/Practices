package facebook.point;

//        Given a set of numbers, find the Length of the Longest Arithmetic Progression (LLAP) in it.
//
//        Examples:
//
//        set[] = {1, 7, 10, 15, 27, 29}
//        output = 3
//        The longest arithmetic progression is {1, 15, 29}
//
//        set[] = {5, 10, 15, 20, 25, 30}
//        output = 6
//        The whole set is in AP

import java.util.Arrays;

/**
 * Created by Han on 11/2/16.
 */
public class LongestArithmeticProgression {

    // dp solution
    // int[][] dp
    // dp[i][j] is the length of AP, which starts from nums[i] and nums[j]
    public int longestAP(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length < 3) {
            return nums.length;
        }
        int longest = 2;
        Arrays.sort(nums);
        int[][] dp = new int[nums.length][nums.length];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                dp[i][j] = 2;
            }
        }
        for (int j = nums.length - 2; j > 0; j--) {
            int i = j - 1;
            int k = j + 1;
            while (i >= 0 && k < nums.length) {
                if (nums[k] - nums[j] > nums[j] - nums[i]) {
                    i--;
                } else if (nums[k] - nums[j] < nums[j] - nums[i]) {
                    k++;
                } else {
                    dp[i][j] = dp[j][k] + 1;
                    longest = Math.max(longest, dp[i][j]);
                    i--;
                    k++;
                }
            }
        }
        return longest;
    }
    public static void main(String[] args) {
        int[] t1 = {1, 1, 3, 4, 5, 6, 7, 9, 1};
        int[] t2 = {};
        int[] t3 = {1};
        int[] t4 = {1, 3};
        int[] t5 = {1, 3, 5};
        int[] t6 = {1, 3, 7};
        LongestArithmeticProgression solution = new LongestArithmeticProgression();
        System.out.println(solution.longestAP(t1));
        System.out.println(solution.longestAP(t2));
        System.out.println(solution.longestAP(t3));
        System.out.println(solution.longestAP(t4));
        System.out.println(solution.longestAP(t5));
        System.out.println(solution.longestAP(t6));
    }
}
