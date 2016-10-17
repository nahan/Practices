package tree.medium;

// https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/

// 106

public class ConstructBinaryTreeFromInorderAndPostorderTraversal {

    // recursive solution
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || inorder.length == 0) {
            return null;
        }
        return buildTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }
    private TreeNode buildTree(int[] in, int i_start, int i_end, int[] po, int p_start, int p_end) {
        if (i_start > i_end || p_start > p_end) {
            return null;
        }
        TreeNode root = new TreeNode(po[p_end]);
        int pivot = i_start - 1;
        while (in[++pivot] != po[p_end]);
        int leftLength = pivot - i_start;
        int rightLength = i_end - pivot;
        root.left = buildTree(in, i_start, pivot - 1, po, p_start, p_start + leftLength - 1);
        root.right = buildTree(in, pivot + 1, i_end, po, p_end - rightLength, p_end - 1);
        return root;
    }
}
