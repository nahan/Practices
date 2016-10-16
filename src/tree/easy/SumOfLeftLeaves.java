package tree.easy;

// https://leetcode.com/problems/sum-of-left-leaves/

// 404

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Han on 10/16/16.
 */
public class SumOfLeftLeaves {

    // recursive solution
    public int sumOfLeftLeaves(TreeNode root) {
        int[] sum = new int[1];
        dfs(root, sum);
        return sum[0];
    }
    public void dfs(TreeNode node, int[] sum) {
        if (node == null) {
            return;
        }
        if (node.left != null) {
            if (node.left.left == null && node.left.right == null) {
                sum[0] += node.left.val;
            }
        }
        dfs(node.left, sum);
        dfs(node.right, sum);
    }

    // bfs solution
    public int sumOfLeftLeavesII(TreeNode root) {
        int sum = 0;
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left != null) {
                if (node.left.left == null && node.left.right == null) {
                    sum += node.left.val;
                }
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        return sum;
    }
}
