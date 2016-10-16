package tree.easy;

// https://leetcode.com/problems/maximum-depth-of-binary-tree/

// 104

/**
 * Created by Han on 10/16/16.
 */
public class MaximumDepthOfBinaryTree {

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}
