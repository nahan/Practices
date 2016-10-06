package facebook.easy;

import java.util.*;

// https://leetcode.com/problems/sum-of-left-leaves/

// 404

public class SumOfLeftLeaves {
    
    // using O(N) extra space
    public int sumOfLeftLeaves(TreeNode root) {
        int sum = 0;
        List<TreeNode> leftChildren = new ArrayList<>();
        dfs(root, leftChildren);
        for (TreeNode node: leftChildren) {
            if (node.left == null && node.right == null) {
                sum += node.val;
            }
        }
        return sum;
    }
    public void dfs(TreeNode node, List<TreeNode> leftChildren) {
        if (node == null) {
            return;
        }
        if (node.left != null) {
            leftChildren.add(node.left);
        }
        dfs(node.left, leftChildren);
        dfs(node.right, leftChildren);
    }
    
    // using O(1) extra space
    public int sumOfLeftLeaves2(TreeNode root) {
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
}
