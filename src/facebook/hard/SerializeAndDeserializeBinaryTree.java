package facebook.hard;

import java.util.*;

// https://leetcode.com/problems/serialize-and-deserialize-binary-tree/

// 297

public class SerializeAndDeserializeBinaryTree {

    // 1. recursive solution
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder builder = new StringBuilder();
        serialize(root, builder);
        return builder.toString();
    }
    
    private void serialize(TreeNode node, StringBuilder builder) {
        if (node == null) {
            builder.append("null;");
            return;
        }
        builder.append(node.val + ";");
        serialize(node.left, builder);
        serialize(node.right, builder);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.isEmpty()) {
            return null;
        }
        String[] list = data.split(";");
        Queue<String> queue = new LinkedList<>();
        for (String s: list) {
            queue.offer(s);
        }
        return deserialize(queue);
    }
    
    private TreeNode deserialize(Queue<String> queue) {
        if (queue.isEmpty()) {
            return null;
        }
        String cur = queue.poll();
        if (cur.equals("null")) {
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(cur));
        node.left = deserialize(queue);
        node.right = deserialize(queue);
        return node;
    }
}
