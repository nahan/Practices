package facebook.hard;

// https://leetcode.com/problems/split-array-largest-sum/
// 410

/**
 * Created by Han on 10/31/16.
 */
public class SplitArrayLargestSum {

    // use binary search to find the minimum sum
    public int splitArray(int[] nums, int m) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        long sum = 0;
        long max = 0;
        for (int n: nums) {
            sum += n;
            max = Math.max(max, n);
        }
        if (m == 1) {
            return (int) sum;
        }
        while (max <= sum) {
            long mid = max + (sum - max) / 2;
            if (valid(mid, nums, m)) {
                sum = mid - 1;
            } else {
                max = mid + 1;
            }
        }
        return (int) max;
    }
    private boolean valid(long target, int[] nums, int m) {
        long total = 0;
        int count = 1;
        for (int n: nums) {
            total += n;
            if (total > target) {
                total = n;
                count++;
                if (count > m) {
                    return false;
                }
            }
        }
        return true;
    }
}
