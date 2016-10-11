package facebook.medium;

import java.util.*;

// https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/

// 236

public class LowestCommonAncestorOfABinaryTree {

    // post-order traversal
    // O(N);
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) {
            return root;
        }
        return left != null ? left : right;
    }
    
    // BFS iterative
    // O(N)
    public TreeNode lowestCommonAncestorII(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (root == p || root == q) {
            return root;
        }
        Map<TreeNode, TreeNode> parents = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        parents.put(root, null);
        queue.offer(root);
        while (!parents.containsKey(p) || !parents.containsKey(q)) {
            TreeNode cur = queue.poll();
            if (cur.left != null) {
                queue.offer(cur.left);
                parents.put(cur.left, cur);
            }
            if (cur.right != null) {
                queue.offer(cur.right);
                parents.put(cur.right, cur);
            }
        }
        Set<TreeNode> set = new HashSet<>();
        while (p != null) {
            set.add(p);
            p = parents.get(p);
        }
        while (!set.contains(q)) {
            q = parents.get(q);
        }
        return q;
    }
}
