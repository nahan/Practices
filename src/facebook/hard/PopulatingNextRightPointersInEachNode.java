package facebook.hard;

// https://leetcode.com/problems/populating-next-right-pointers-in-each-node/

// 116

// https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/

// 117

public class PopulatingNextRightPointersInEachNode {

    // 116. recursive solution
    // You may assume that it is a perfect binary tree 
    // (ie, all leaves are at the same level, and every parent has two children).
    public void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            root.left.next = root.right;
        }
        if (root.right != null && root.next != null) {
            root.right.next = root.next.left;
        }
        connect(root.left);
        connect(root.right);
    }
    
    // 117. follow up
    // What if the given tree could be any binary tree?
    public void connect2(TreeLinkNode root) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            if (root.right != null) {
                root.left.next = root.right;
            } else {
                TreeLinkNode node = root.next;
                while (node != null && node.left == null && node.right == null) {
                    node = node.next;
                }
                if (node != null) {
                    root.left.next = node.left != null ? node.left : node.right;
                }
            }
        }
        if (root.right != null) {
            TreeLinkNode node = root.next;
            while (node != null && node.left == null && node.right == null) {
                node = node.next;
            }
            if (node != null) {
                root.right.next = node.left != null ? node.left : node.right;
            }
        }
        // recur right subtree first
        connect2(root.right);
        connect2(root.left);
    }
}
