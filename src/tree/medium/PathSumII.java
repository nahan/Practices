package tree.medium;

import java.util.*;

// https://leetcode.com/problems/path-sum-ii/

// 113

public class PathSumII {

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        List<Integer> list = new ArrayList<>();
        dfs(result, list, root, sum);
        return result;
    }
    private void dfs(List<List<Integer>> result, List<Integer> list, TreeNode node, int sum) {
        list.add(node.val);
        if (node.left == null && node.right == null && node.val == sum) {
            result.add(new ArrayList<>(list));
        }
        if (node.left != null) {
            dfs(result, list, node.left, sum - node.val);
        }
        if (node.right != null) {
            dfs(result, list, node.right, sum - node.val);
        }
        list.remove(list.size() - 1);
    }
}
