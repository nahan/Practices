package dfs.hard;

// https://leetcode.com/problems/longest-increasing-path-in-a-matrix/
// 329

/**
 * Created by Han on 10/31/16.
 */
public class LongestIncreasingPathInAMatrix {

    // a dfs solution
    // cache the max length on each position
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int max = 1;
        int[][] cache = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                int len = dfs(matrix, i, j, cache);
                max = Math.max(max, len);
            }
        }
        return max;
    }
    private int dfs(int[][] matrix, int i, int j, int[][] cache) {
        if (cache[i][j] != 0) {
            return cache[i][j];
        }
        int max = 1;
        if (i > 0 && matrix[i - 1][j] > matrix[i][j]) {
            max = Math.max(max, 1 + dfs(matrix, i - 1, j, cache));
        }
        if (i < matrix.length - 1 && matrix[i + 1][j] > matrix[i][j]) {
            max = Math.max(max, 1 + dfs(matrix, i + 1, j, cache));
        }
        if (j > 0 && matrix[i][j - 1] > matrix[i][j]) {
            max = Math.max(max, 1 + dfs(matrix, i, j - 1, cache));
        }
        if (j < matrix[0].length - 1 && matrix[i][j + 1] > matrix[i][j]) {
            max = Math.max(max, 1 + dfs(matrix, i, j + 1, cache));
        }
        cache[i][j] = max;
        return max;
    }
}
