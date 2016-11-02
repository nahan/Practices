package facebook.point;

// https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/
// 109

/**
 * Created by Han on 11/2/16.
 */
public class ConvertSortedListToBinarySearchTree {

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode previous = null;
        ListNode middle = head;
        ListNode tail = head;
        while (tail != null && tail.next != null) {
            previous = middle;
            middle = middle.next;
            tail = tail.next.next;
        }
        TreeNode root = new TreeNode(middle.val);
        if (previous != null) {
            previous.next = null;
        } else {
            head = null;
        }
        root.left = this.sortedListToBST(head);
        root.right = this.sortedListToBST(middle.next);
        return root;
    }
}
