package walmart;
import java.util.*;
//    http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=189728&highlight=walmart

//    上周刚刚面完Walmartlabs intern。一天面了两个组，4轮：
//    第一组，backend engineer position，上来印度小哥聊了下BST，让后写了个验证BST原题，秒完成，顺利通过。接下来了哥欧洲小哥，上来聊项目，着重聊了下我那个多线程crawler的项目以及停车场项目，怎么优化，OS，Network基本概念，聊了下各种框架。
//    休息45mins后，第二组，information security，一印度小哥，上来让我做两数相加，开始给出的是数组，后来follow up一下数组前面有零怎么办，后来follow up成了用链表表示数。顺利完成。
//    第二个印度小哥，上来聊他们的项目，说如访问很多，只有一台服务器怎么办，一开始想负载均均衡，但是只有一个服务器，恰好想到最近做的一个app，只有一台服务器，说可以用消息队列。没有再问下去，剩下的30mins居然在和我聊天，说他们组怎么好。
//    
//    两天后来了两个offer，选择了第一组。

// https://leetcode.com/problems/validate-binary-search-tree/

public class ValidBST {
    
    // recursion
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.left != null) {
            TreeNode maxOnLeft = max(root.left);
            if (maxOnLeft.val >= root.val) {
                return false;
            }
        }
        if (root.right != null) {
            TreeNode minOnRight = min(root.right);
            if (minOnRight.val <= root.val) {
                return false;
            }
        }
        return isValidBST(root.left) && isValidBST(root.right);
    }
    public TreeNode max(TreeNode node) {
        if (node.right == null) {
            return node;
        }
        return max(node.right);
    }
    public TreeNode min(TreeNode node) {
        if (node.left == null) {
            return node;
        }
        return min(node.left);
    }
    
    // list
    public boolean isValidBST2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorder(root, list);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i - 1) >= list.get(i)) {
                return false;
            }
        }
        return true;
    }
    
    private void inorder(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        inorder(node.left, list);
        list.add(node.val);
        inorder(node.right, list);
    }
    
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
