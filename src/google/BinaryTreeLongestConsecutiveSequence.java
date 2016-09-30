package google;

public class BinaryTreeLongestConsecutiveSequence {
    public int longestConsecutive(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return find(root, 0, root.val - 1);
    }
    private int find(TreeNode node, int length, int pre) {
        if (node == null) {
            return length;
        }
        int cur = node.val - pre == 1 ? length + 1 : 1;
        int left = find(node.left, cur, node.val);
        int right = find(node.right, cur, node.val);
        return Math.max(cur, Math.max(left, right));
    }
    
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
