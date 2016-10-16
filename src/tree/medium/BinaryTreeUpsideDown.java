package tree.medium;

// https://leetcode.com/problems/binary-tree-upside-down/

// 156

/**
 * Created by Han on 10/16/16.
 */
public class BinaryTreeUpsideDown {

    // recursive solution
    // O(logN) space
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if (root == null || root.left == null) {
            return root;
        }
        TreeNode newRoot = upsideDownBinaryTree(root.left);
        root.left.left = root.right;
        root.left.right = root;
        root.left = null;
        root.right = null;
        return newRoot;
    }

    // iterative solution
    // O(1) space
    public TreeNode upsideDownBinaryTreeII(TreeNode root) {
        TreeNode cur = root;
        TreeNode pre = null;
        TreeNode next = null;
        TreeNode temp = null;
        while (cur != null) {
            next = cur.left;
            cur.left = temp;
            temp = cur.right;
            cur.right = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
