package tree.easy;

// https://leetcode.com/problems/minimum-depth-of-binary-tree/

// 111

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Han on 10/16/16.
 */
public class MinimumDepthOfBinaryTree {

    // BFS solution
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int min = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            min++;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left == null && node.right == null) {
                    return min;
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return min;
    }

    // DFS solution with an instance variable
    private int min = Integer.MAX_VALUE;
    public int minDepthII(TreeNode root) {
        if (root == null) {
            return 0;
        }
        dfs(root, 1);
        return min;
    }
    private void dfs(TreeNode node, int depth) {
        if (node.left == null && node.right == null) {
            min = Math.min(min, depth);
        }
        if (node.left != null) {
            dfs(node.left, 1 + depth);
        }
        if (node.right != null) {
            dfs(node.right, 1 + depth);
        }
    }

    // DFS solution with the instance variable
    public int minDepthIII(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = minDepthIII(root.left);
        int right = minDepthIII(root.right);
        if (left == 0 || right == 0) {
            return left + right + 1;
        }
        return Math.min(left, right) + 1;
    }
}
