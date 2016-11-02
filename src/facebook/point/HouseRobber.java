package facebook.point;

/**
 * 2016(10-12月) 码农类 硕士 全职@Facebook - 内推 - 技术电面 |Otherfresh grad应届毕业生
 * 刚刚面完的fb店面 开始前10分钟hr发邮件说面试官可能有事冲突 问我明天有没有空 我以为不面了
 * 结果约定时间过了6分钟电话又打来了 匆忙开始面试是一个姐姐 人挺好的
 * 第一题 robber house
 * 第二题 给两个string string是一串数字 再给一个int base, assume base <= 10
 * 就是给两串数字 数字是base进制的 然后加起来 返回sum
 */

// https://leetcode.com/problems/house-robber/
// 198

// https://leetcode.com/problems/house-robber-ii/
// 213

// https://leetcode.com/problems/house-robber-iii/
// 337


import java.util.HashMap;
import java.util.Map;

/**
 * Created by Han on 11/1/16.
 */
public class HouseRobber {

    // 198. House Robber
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length + 1];
        dp[1] = nums[0];
        for (int i = 2; i < dp.length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i - 1], dp[i - 1]);
        }
        return dp[nums.length];
    }

    // 213. circle
    public int robII(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length < 3) {
            return Math.max(nums[0], nums[nums.length - 1]);
        }
        int max1 = rob(nums, 0, nums.length - 2);
        int max2 = rob(nums, 1, nums.length - 1);
        return Math.max(max1, max2);
    }
    private int rob(int[] nums, int start, int end) {
        int[] dp = new int[nums.length];
        dp[start] = nums[start];
        dp[start + 1] = Math.max(nums[start], nums[start + 1]);
        for (int i = start + 2; i <= end; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[end];
    }

    // 337
    public int robIII(TreeNode root) {
        Map<TreeNode, Integer> map = new HashMap<>();
        return dfs(root, map);
    }
    private int dfs(TreeNode node, Map<TreeNode, Integer> map) {
        if (node == null) {
            return 0;
        }
        if (map.containsKey(node)) {
            return map.get(node);
        }
        int val = 0;
        if (node.left != null) {
            val += dfs(node.left.left, map) + dfs(node.left.right, map);
        }
        if (node.right != null) {
            val += dfs(node.right.left, map) + dfs(node.right.right, map);
        }
        val = Math.max(node.val + val, dfs(node.left, map) + dfs(node.right, map));
        map.put(node, val);
        return val;
    }
}
