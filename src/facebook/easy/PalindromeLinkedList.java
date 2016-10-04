package facebook.easy;

// https://leetcode.com/problems/palindrome-linked-list/

// 234

public class PalindromeLinkedList {

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast != null) {
            fast = slow.next;
        } else {
            fast = slow;
        }
        slow = head;
        fast = reverse(fast);
        while (fast != null) {
            if (slow.val != fast.val) {
                return false;
            }
            slow = slow.next;
            fast = fast.next;
        }
        return true;
    }
    private ListNode reverse(ListNode head) {
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
