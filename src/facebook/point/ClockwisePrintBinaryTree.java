package facebook.point;

// http://www.1point3acres.com/bbs/thread-203983-1-1.html
// 顺时针的print binary tree boundary, 就是从根开始，先打右边界，再打叶子，最后打左边界。
/**
 * Created by Han on 11/2/16.
 */
public class ClockwisePrintBinaryTree {

    public void clockwisePrint(TreeNode root) {
        if (root == null) {
            return;
        }
        preorderLeft(root);
        inorderLeaf(root);
        postorderRight(root);
        System.out.println();
    }
    private void preorderLeft(TreeNode node) {
        if (node == null) {
            return;
        }
        if (!isLeaf(node)) {
            System.out.print(node.val + "->");
        }
        preorderLeft(node.left);
    }
    private void inorderLeaf(TreeNode node) {
        if (node == null) {
            return;
        }
        inorderLeaf(node.left);
        if (node.left == null && node.right == null) {
            System.out.print(node.val + "->");
        }
        inorderLeaf(node.right);
    }
    private void postorderRight(TreeNode node) {
        if (node == null) {
            return;
        }
        postorderRight(node.right);
        if (!isLeaf(node)) {
            System.out.print(node.val + "->");
        }
    }
    private boolean isLeaf(TreeNode node) {
        return node != null && node.left == null && node.right == null;
    }

    public static void main(String[] args) {
        ClockwisePrintBinaryTree solution = new ClockwisePrintBinaryTree();
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        solution.clockwisePrint(root);
        root.left.right.left = new TreeNode(7);
        solution.clockwisePrint(root);
        root.right.left.right = new TreeNode(8);
        solution.clockwisePrint(root);
    }
}
