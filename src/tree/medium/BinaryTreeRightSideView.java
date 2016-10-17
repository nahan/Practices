package tree.medium;

import java.util.*;

// https://leetcode.com/problems/binary-tree-right-side-view/

// 199

public class BinaryTreeRightSideView {

    
    // BFS solution
    // traversal the tree level by level
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                if (i == size - 1) {
                    result.add(node.val);
                }
            }
        }
        return result;
    }
    
    // DFS solution
    // keep track the result size and current level
    public List<Integer> rightSideViewII(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        dfs(result, root, 0);
        return result;
    }
    private void dfs(List<Integer> result, TreeNode node, int depth) {
        if (node == null) {
            return;
        }
        if (depth == result.size()) {
            result.add(node.val);
        }
        dfs(result, node.right, depth + 1);
        dfs(result, node.left, depth + 1);
    }
}
