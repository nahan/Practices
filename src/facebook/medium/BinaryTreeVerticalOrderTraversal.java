package facebook.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class BinaryTreeVerticalOrderTraversal {

    // BFS solution, keep tracking each node's weight
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Map<TreeNode, Integer> weights = new HashMap<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        int min = Integer.MAX_VALUE;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        weights.put(root, 0);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            int weight = weights.get(node);
            min = Math.min(min, weight);
            map.putIfAbsent(weight, new ArrayList<>());
            map.get(weight).add(node.val);
            if (node.left != null) {
                queue.offer(node.left);
                weights.put(node.left, weight - 1);
            }
            if (node.right != null) {
                queue.offer(node.right);
                weights.put(node.right, weight + 1);
            }
        }
        while (map.containsKey(min)) {
            result.add(map.get(min++));
        }
        return result;
    }
}
