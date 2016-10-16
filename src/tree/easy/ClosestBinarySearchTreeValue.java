package tree.easy;

// https://leetcode.com/problems/closest-binary-search-tree-value/

// 270

/**
 * Created by Han on 10/16/16.
 */
public class ClosestBinarySearchTreeValue {

    // use a value to keep tracking the closet value in the tree
    public int closestValue(TreeNode root, double target) {
        int value = root.val;
        while (root != null) {
            if (Math.abs(root.val - target) <= Math.abs(value - target)) {
                value = root.val;
            }
            if (target >= root.val) {
                root = root.right;
            } else {
                root = root.left;
            }
        }
        return value;
    }
}
