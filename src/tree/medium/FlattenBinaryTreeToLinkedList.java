package tree.medium;

// https://leetcode.com/problems/flatten-binary-tree-to-linked-list/

// 114

/**
 * Created by Han on 10/16/16.
 */
public class FlattenBinaryTreeToLinkedList {

    // recursive solution
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        flatten(root.right);
        flatten(root.left);
        TreeNode node = root.left;
        if (node != null) {
            while (node.right != null) {
                node = node.right;
            }
            node.right = root.right;
            root.right = null;
        }
        if (root.left != null) {
            root.right = root.left;
            root.left = null;
        }
    }
}
