package facebook.hard;

import java.util.*;

// https://leetcode.com/problems/lru-cache/

// 146

public class LRUCache {

    private Node head;
    private Node tail;
    private int capacity;
    private int size;
    private Map<Integer, Node> map;
    
    public LRUCache(int cap) {
        head = null;
        tail = null;
        capacity = cap;
        size = 0;
        map = new HashMap<>();
    }
    
    public int get(int key) {
        Node node = map.get(key);
        if (node == null) {
            return -1;
        } else {
            refresh(node);
            return node.val;
        }
    }
    
    public void set(int key, int value) {
        Node node = map.get(key);
        if (node == null) {
            node = new Node(key, value);
            add(node);
        } else {
            node.val = value;
            refresh(node);
        }
    }
    
    private void refresh(Node node) {
        remove(node);
        add(node);
    }
    
    private void add(Node node) {
        if (size == capacity) {
            remove(head);
        }
        if (size == 0) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            node.pre = tail;
            tail = node;
        }
        map.put(node.key, node);
        size++;
    }
    
    private void remove(Node node) {
        if (size == 0) {
            return;
        }
        if (size == 1) {
            head = null;
            tail = null;
        } else if (node == head) {
            head = head.next;
            head.pre = null;
        } else if (node == tail) {
            tail = tail.pre;
            tail.next = null;
        } else {
            Node pre = node.pre;
            Node next = node.next;
            pre.next = next;
            next.pre = pre;
        }
        map.remove(node.key);
        size--;
    }
    
    private static class Node {
        int key;
        int val;
        Node pre;
        Node next;
        Node(int k, int v) {
            key = k;
            val = v;
        }
    }
}
