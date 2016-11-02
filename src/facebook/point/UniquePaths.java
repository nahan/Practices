package facebook.point;


// https://leetcode.com/problems/unique-paths/
// 62

// https://leetcode.com/problems/unique-paths-ii/
// 63

/**
 * Created by Han on 11/2/16.
 */
public class UniquePaths {

    // 62.
    public int uniquePaths(int m, int n) {
        int[] dp = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    dp[j] = 1;
                } else {
                    dp[j] += dp[j - 1];
                }
            }
        }
        return dp[n - 1];
    }

    // 63.
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0) {
            return 0;
        }
        int[] dp = new int[obstacleGrid[0].length];
        for (int i = 0; i < obstacleGrid.length; i++) {
            for (int j = 0; j < obstacleGrid[0].length; j++) {
                if (i == 0 && j == 0) {
                    dp[j] = obstacleGrid[i][j] == 1 ? 0 : 1;
                } else if (i == 0) {
                    dp[j] = obstacleGrid[i][j] == 1 ? 0 : dp[j - 1];
                } else if (j == 0) {
                    dp[j] = obstacleGrid[i][j] == 1 ? 0 : dp[j];
                } else {
                    dp[j] = obstacleGrid[i][j] == 1 ? 0 : dp[j] + dp[j - 1];
                }
            }
        }
        return dp[dp.length - 1];
    }

}
