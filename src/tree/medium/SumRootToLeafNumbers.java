package tree.medium;

// https://leetcode.com/problems/sum-root-to-leaf-numbers/

// 129

public class SumRootToLeafNumbers {
    
    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return sum(root, 0);
    }
    public int sum(TreeNode node, int sum) {
        if (node.left == null && node.right == null) {
            return sum * 10 + node.val;
        }
        int left = node.left == null ? 0 : sum(node.left, sum * 10 + node.val);
        int right = node.right == null ? 0 : sum(node.right, sum * 10 + node.val);
        return left + right;
    }
}
