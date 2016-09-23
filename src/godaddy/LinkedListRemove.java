package godaddy;

import java.util.Random;

public class LinkedListRemove {

    public static void main(String[] args) {
        
        LinkedListRemove solution = new LinkedListRemove();
        
        Random rand = new Random();
        
        ListNode n1 = new ListNode(rand.nextInt(20));
        ListNode n2 = new ListNode(rand.nextInt(20));
        ListNode n3 = new ListNode(rand.nextInt(20));
        ListNode n4 = new ListNode(rand.nextInt(20));
        ListNode n5 = new ListNode(rand.nextInt(20));
        ListNode n6 = new ListNode(rand.nextInt(20));
        ListNode n7 = new ListNode(rand.nextInt(20));
        ListNode n8 = new ListNode(rand.nextInt(20));
        ListNode n9 = new ListNode(rand.nextInt(20));
        ListNode n10 = new ListNode(rand.nextInt(20));
        
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;
        n7.next = n8;
        n8.next = n9;
        n9.next = n10;
        
        print(n1);
        int target = rand.nextInt(20);
        System.out.println("target: " + target);
        ListNode result = solution.remove(n1, target);
        print(result);
        
    }
    
    public ListNode remove(ListNode head, int value) {
        ListNode cur = head;
        while (cur != null) {
            if (cur.next != null && cur.val > value) {
                remove(cur);
            } else {
                cur = cur.next;
            }
        }
        cur = head;
        while (cur != null && cur.next != null) {
            if (cur.next.next == null && cur.next.val > value) {
                cur.next = null;
            }
            cur = cur.next;
        }
        cur = head;
        if (cur.next == null && cur.val > value) {
            head = null;
        }
        return head;
    }
    
    private void remove(ListNode node) {
        if (node.next != null) {
            node.val = node.next.val;
            node.next = node.next.next;
        }
    }
    
    static void print(ListNode node) {
        while (node != null) {
            System.out.print(node.val + "->");
            node = node.next;
        }
        System.out.println();
    }
    
    static class ListNode {
        int val;
        ListNode next;
        public ListNode(int v) {
            val = v;
            next = null;
        }
    }
    
}
