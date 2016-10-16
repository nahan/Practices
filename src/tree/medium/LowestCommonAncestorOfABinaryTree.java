package tree.medium;

// https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/

// 236

import java.util.*;

/**
 * Created by Han on 10/16/16.
 */
public class LowestCommonAncestorOfABinaryTree {

    // iterative solution
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        Map<TreeNode, TreeNode> map = new HashMap<>();
        map.put(root, null);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left != null) {
                queue.offer(node.left);
                map.put(node.left, node);
            }
            if (node.right != null) {
                queue.offer(node.right);
                map.put(node.right, node);
            }
            if (map.containsKey(p) && map.containsKey(q)) {
                break;
            }
        }
        Set<TreeNode> set = new HashSet<>();
        TreeNode node = p;
        while (node != null) {
            set.add(node);
            node = map.get(node);
        }
        node = q;
        while (!set.contains(node)) {
            node = map.get(node);
        }
        return node;
    }

    // recursive solution
    public TreeNode lowestCommonAncestorII(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestorII(root.left, p, q);
        TreeNode right = lowestCommonAncestorII(root.right, p, q);
        if (left != null && right != null) {
            return root;
        }
        return left != null ? left : right;
    }
}
