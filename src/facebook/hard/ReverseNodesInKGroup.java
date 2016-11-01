package facebook.hard;

// https://leetcode.com/problems/reverse-nodes-in-k-group/
// 25

/**
 * Created by Han on 10/31/16.
 */
public class ReverseNodesInKGroup {

    // a recursive solution
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k < 2) {
            return head;
        }
        int count = 0;
        ListNode node = head;
        while (node != null && count != k) {
            count++;
            node = node.next;
        }
        if (count != k) {
            return head;
        }
        ListNode pre = null;
        ListNode cur = head;
        while (cur != node) {
            ListNode temp = cur;
            cur = cur.next;
            temp.next = pre;
            pre = temp;
        }
        head.next = reverseKGroup(node, k);
        return pre;
    }
}
