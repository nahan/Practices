package facebook.hard;

// https://leetcode.com/problems/paint-house-ii/
// 265

// https://leetcode.com/problems/paint-house/
// 256

// https://leetcode.com/problems/paint-fence/
// 276

/**
 * Created by Han on 10/31/16.
 */
public class PaintHouseII {

    // a brute force solution using O(M * N * N) time
    public int minCostII(int[][] costs) {
        if (costs == null || costs.length == 0 || costs[0].length == 0) {
            return 0;
        }
        int result = Integer.MAX_VALUE;
        if (costs.length == 1) {
            for (int i = 0; i < costs[0].length; i++) {
                result = Math.min(result, costs[0][i]);
            }
            return result;
        }
        int[][] dp = new int[costs.length + 1][costs[0].length];
        for (int i = 0; i < costs.length; i++) {

            for (int j = 0; j < costs[0].length; j++) {
                int cost = Integer.MAX_VALUE;
                for (int k = 0; k < dp[0].length; k++) {
                    if (k != j) {
                        cost = Math.min(cost, dp[i][k]);
                    }
                }
                dp[i + 1][j] = costs[i][j] + cost;
            }

        }
        for (int i = 0; i < dp[0].length; i++) {
            result = Math.min(result, dp[dp.length - 1][i]);
        }
        return result;
    }

    // a dp solution
    public int minCostII2(int[][] costs) {
        if (costs == null || costs.length == 0 || costs[0].length == 0) {
            return 0;
        }
        int n = costs.length;
        int k = costs[0].length;
        if (k == 1) {
            return n == 1 ? costs[0][0] : -1;
        }
        int preMin = 0;
        int preMinIndex = -1;
        int preSecMin = 0;
        for (int i = 0; i < n; i++) {
            int min = Integer.MAX_VALUE;
            int minIndex = -1;
            int secMin = Integer.MAX_VALUE;
            for (int j = 0; j < k; j++) {
                // if j == preMinIndex, then set val as current cost + preSecMin
                int val = costs[i][j] + (j == preMinIndex ? preSecMin : preMin);
                if (minIndex < 0) {
                    // min is not initialized
                    minIndex = j;
                    min = val;
                } else if (val < min) {
                    // find a new minimum
                    secMin = min;
                    min = val;
                    minIndex = j;
                } else if (val < secMin) {
                    // find a new second minimum
                    secMin = val;
                }
            }
            preMin = min;
            preMinIndex = minIndex;
            preSecMin = secMin;
        }
        return preMin;
    }

    // 256
    public int minCost(int[][] costs) {
        if (costs == null || costs.length == 0 || costs[0].length == 0) {
            return 0;
        }
        int n = costs.length;
        for (int i = 1; i < n; i++) {
            costs[i][0] += Math.min(costs[i - 1][1], costs[i - 1][2]);
            costs[i][1] += Math.min(costs[i - 1][0], costs[i - 1][2]);
            costs[i][2] += Math.min(costs[i - 1][0], costs[i - 1][1]);
        }
        return Math.min(costs[n - 1][0], Math.min(costs[n - 1][1], costs[n - 1][2]));
    }

    // 276
    public int numWays(int n, int k) {
        if (n == 0 || k == 0) {
            return 0;
        }
        if (n == 1) {
            return k;
        }
        int same = k;
        int diff = k * (k - 1);
        for (int i = 2; i < n; i++) {
            int diffValue = diff;
            int sameValue = (same + diff) * (k - 1);
            same = diffValue;
            diff = sameValue;
        }
        return same + diff;
    }
}
