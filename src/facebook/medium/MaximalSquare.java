package facebook.medium;

// https://leetcode.com/problems/maximal-square/

// 221

/**
 * Created by Han on 10/14/16.
 */
public class MaximalSquare {

    // DP solution, on each position, find the largest square area it can form
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int max = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] area = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    if (i > 0 && j > 0 && matrix[i - 1][j] == '1' && matrix[i][j - 1] == '1' && matrix[i - 1][j - 1] == '1') {
                        int pre = Math.min(area[i - 1][j], area[i][j - 1]);
                        pre = Math.min(pre, area[i - 1][j - 1]);
                        int side = (int) Math.sqrt(pre) + 1;
                        area[i][j] = side * side;
                    } else {
                        area[i][j] = 1;
                    }
                    max = Math.max(max, area[i][j]);
                }
            }
        }
        return max;
    }
}
