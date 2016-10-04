package facebook.easy;

import java.util.*;

// https://leetcode.com/problems/binary-tree-paths/

// 257

public class BinaryTreePaths {
    
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        StringBuilder builder = new StringBuilder();
        dfs(result, builder, root);
        return result;
    }
    private void dfs(List<String> result, StringBuilder builder, TreeNode node) {
        builder.append(node.val);
        if (node.left == null && node.right == null) {
            result.add(builder.toString());
            return;
        }
        int length = builder.length();
        if (node.left != null) {
            builder.append("->");
            dfs(result, builder, node.left);
        }
        builder.setLength(length);
        if (node.right != null) {
            builder.append("->");
            dfs(result, builder, node.right);
        }
    }

}
