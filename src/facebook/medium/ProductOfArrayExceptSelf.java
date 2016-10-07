package facebook.medium;

// https://leetcode.com/problems/product-of-array-except-self/

// 238

/**
 * Created by Han on 10/7/16.
 */
public class ProductOfArrayExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        result[0] = 1;
        int pre = 1;
        for (int i = 1; i < nums.length; i++) {
            pre *= nums[i - 1];
            result[i] = pre;
        }
        int post = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            post *= nums[i + 1];
            result[i] *= post;
        }
        return result;
    }
}
