package facebook.medium;

// https://leetcode.com/problems/validate-binary-search-tree/

// 98

/**
 * Created by Han on 10/7/16.
 */
public class ValidateBinarySearchTree {

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.left != null) {
            TreeNode node = root.left;
            while (node.right != null) {
                node = node.right;
            }
            if (node.val >= root.val) {
                return false;
            }
        }
        if (root.right != null) {
            TreeNode node = root.right;
            while (node.left != null) {
                node = node.left;
            }
            if (node.val <= root.val) {
                return false;
            }
        }
        return isValidBST(root.left) && isValidBST(root.right);
    }
}
