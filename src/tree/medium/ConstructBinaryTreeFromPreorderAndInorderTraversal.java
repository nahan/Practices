package tree.medium;

// https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/

// 105

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {

    // recursive solution
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }
    private TreeNode buildTree(int[] pre, int p_start, int p_end, int[] in, int i_start, int i_end) {
        if (p_start > p_end || i_start > i_end) {
            return null;
        }
        TreeNode root = new TreeNode(pre[p_start]);
        int pivot = i_start - 1;
        while (in[++pivot] != pre[p_start]);
        int leftLength = pivot - i_start;
        int rightLength = i_end - pivot;
        root.left = buildTree(pre, p_start + 1, p_start + leftLength, in, i_start, pivot - 1);
        root.right = buildTree(pre, p_end - rightLength + 1, p_end, in, pivot + 1, i_end);
        return root;
    }
}
