package facebook.medium;

import java.util.*;

// https://leetcode.com/problems/inorder-successor-in-bst/

// 285

public class InorderSuccessorInBST {

    
    // 1. HashMap solution
    // dfs traversal -> O(N)
    // on each node, find the max and min -> O(h)
    // total -> O(h * N);
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        Map<TreeNode, TreeNode> map = new HashMap<>();
        dfs(root, map);
        return map.getOrDefault(p, null);
    }
    private void dfs(TreeNode node, Map<TreeNode, TreeNode> map) {
        if (node == null) {
            return;
        }
        if (node.left != null) {
            TreeNode cur = node.left;
            while (cur.right != null) {
                cur = cur.right;
            }
            map.put(cur, node);
        }
        if (node.right != null) {
            TreeNode cur = node.right;
            while (cur.left != null) {
                cur = cur.left;
            }
            map.put(node, cur);
        }
        dfs(node.left, map);
        dfs(node.right, map);
    }
    
    // 2. recursive solution -> O(h)
    public TreeNode inorderSuccessorII(TreeNode root, TreeNode p) {
        if (root == null) {
            return null;
        }
        if (root.val <= p.val) {
            return inorderSuccessor(root.right, p);
        } else {
            TreeNode successor = inorderSuccessor(root.left, p);
            return successor == null ? root : successor;
        }
    }
    
    // 3. iterative solution
    public TreeNode inorderSuccessorIII(TreeNode root, TreeNode p) {
        TreeNode result = null;
        while (root != null) {
            if (root.val > p.val) {
                result = root;
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return result;
    }
    
    // recursive solution for Predecessor
    public TreeNode inorderPredecessor(TreeNode root, TreeNode p) {
        if (root == null) {
            return null;
        }
        if (root.val >= p.val) {
            return inorderPredecessor(root.left, p);
        } else {
            TreeNode predecessor = inorderPredecessor(root.right, p);
            return predecessor == null ? root : predecessor;
        }
    }
    
    // recursive solution for Predecessor
    public TreeNode inorderPredecessorII(TreeNode root, TreeNode p) {
        TreeNode result = null;
        while (root != null) {
            if (root.val < p.val) {
                result = root;
                root = root.right;
            } else {
                root = root.left;
            }
        }
        return result;
    }
}
