package facebook.point;

// http://www.1point3acres.com/bbs/thread-208453-1-1.html

// https://leetcode.com/problems/binary-tree-paths/
// 257

// https://leetcode.com/problems/minimum-window-substring/
// 76

// 2016(10-12月) 码农类 硕士 全职@Facebook - 内推 - 技术电面 |Otherfresh grad应届毕业生
// 刚刚面完，用了几天刷了所有9月10月的面经。两道都是面经题，感谢美国小哥：
//
// 0. 介绍最近的项目，最近的实习，比较细致
// 1. BT root to leave path
//
// 2. LC76, 字符串T变成了一个set
//
// 第一个问题，我还挺开心写完，结果问了半天时间空间复杂度，最坏情况啥的。。傻眼了，尴尬了半天。我用的recursive，这种一直很懵逼。


import java.util.*;

/**
 * Created by Han on 11/1/16.
 */
public class MinimumWindowSubstring {

    // 257
    // 1. recursive solution
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        dfs(result, root, "");
        return result;
    }
    private void dfs(List<String> result, TreeNode node, String path) {
        if (node.left == null && node.right == null) {
            result.add(path + node.val);
        }
        if (node.left != null) {
            dfs(result, node.left, path + node.val + "->");
        }
        if (node.right != null) {
            dfs(result, node.right, path + node.val + "->");
        }
    }
    // 257
    // 2. bfs solution
    public List<String> binaryTreePathsII(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<String> pathQueue = new LinkedList<>();
        nodeQueue.offer(root);
        pathQueue.offer("");
        while (!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.poll();
            String path = pathQueue.poll();
            if (node.left == null && node.right == null) {
                result.add(path + node.val);
            }
            if (node.left != null) {
                nodeQueue.offer(node.left);
                pathQueue.offer(path + node.val + "->");
            }
            if (node.right != null) {
                nodeQueue.offer(node.right);
                pathQueue.offer(path + node.val + "->");
            }
        }
        return result;
    }

    // 76
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.isEmpty() || t.isEmpty()) {
            return "";
        }
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int count = t.length();
        int length = s.length() + 1;
        int start = 0;
        int head = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
                if (map.get(c) >= 0) {
                    count--;
                }
            }
            while (count == 0) {
                if (i - head + 1 < length) {
                    length = i - head + 1;
                    start = head;
                }
                char first = s.charAt(head++);
                if (map.containsKey(first)) {
                    if (map.get(first) >= 0) {
                        count++;
                    }
                    map.put(first, map.get(first) + 1);
                }
            }
        }
        if (length == s.length() + 1) {
            return "";
        }
        return s.substring(start, start + length);
    }
}
