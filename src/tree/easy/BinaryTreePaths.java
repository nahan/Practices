package tree.easy;

// https://leetcode.com/problems/binary-tree-paths/

// 257

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Han on 10/16/16.
 */
public class BinaryTreePaths {

    // use StringBuilder
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

    // use String
    public List<String> binaryTreePathsII(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        dfs(result, "", root);
        return result;
    }
    private void dfs(List<String> result, String path, TreeNode node) {
        if (node.left == null && node.right == null) {
            result.add(path + node.val);
        }
        if (node.left != null) {
            dfs(result, path + node.val + "->", node.left);
        }
        if (node.right != null) {
            dfs(result, path + node.val + "->", node.right);
        }
    }
}
