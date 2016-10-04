package facebook.easy;

// https://leetcode.com/problems/reverse-linked-list/

public class ReverseLinkedList {

    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode pre = null;
        while (head != null) {
            ListNode temp = head;
            head = head.next;
            temp.next = pre;
            pre = temp;
        }
        return pre;
    }
    
}
