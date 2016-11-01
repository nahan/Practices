package facebook.hard;

// https://leetcode.com/problems/maximal-rectangle/
// 85

import java.util.Stack;

/**
 * Created by Han on 10/27/16.
 */
public class MaximalRectangle {

    // go through the matrix from top to bottom
    // maintain an int array to store heights on each level
    // on each level, use a stack to store the ascending heights index
    // when hitting a descending height, pop the stack and compute the area
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int max = 0;
        int[] dp = new int[matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (i == 0) {
                    dp[j] = matrix[i][j] - '0';
                } else {
                    dp[j] = matrix[i][j] == '0' ? 0 : dp[j] + 1;
                }
            }
            max = Math.max(max, maxArea(dp));
        }
        return max;
    }
    private int maxArea(int[] heights) {
        int max = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i <= heights.length; i++) {
            while (!stack.isEmpty() && (i == heights.length || heights[i] < heights[stack.peek()])) {
                int height = heights[stack.pop()];
                int area = 0;
                if (!stack.isEmpty()) {
                    area = height * (i - stack.peek() - 1);
                } else {
                    area = height * i;
                }
                max = Math.max(max, area);
            }
            stack.push(i);
        }
        return max;
    }
}
