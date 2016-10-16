package tree.easy;

// https://leetcode.com/problems/invert-binary-tree/

// 226

/**
 * Created by Han on 10/16/16.
 */
public class InvertBinaryTree {

    // recursive solution
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}
