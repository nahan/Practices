package facebook.hard;

import java.util.*;

// https://leetcode.com/problems/insert-delete-getrandom-o1/

// 380

public class RandomizedSet {

    private Random rand;
    private List<Integer> list;
    private Map<Integer, Integer> map;
    private int lastIndex;

    /** Initialize your data structure here. */
    public RandomizedSet() {
        rand = new Random();
        list = new ArrayList<>();
        map = new HashMap<>();
        lastIndex = -1;
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }
        list.add(val);
        map.put(val, ++lastIndex);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    // find the last element, swap the last element and the deleting element in both map and list
    // then remove the last element in both map and list
    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }
        int lastElement = list.get(lastIndex);
        if (lastElement != val) {
            int valIndex = map.get(val);
            map.put(lastElement, valIndex);
            list.set(valIndex, lastElement);
            map.put(val, lastIndex);
            list.set(lastIndex, val);
        }
        removeLast();
        return true;
    }
    
    private void removeLast() {
        int lastElement = list.get(lastIndex);
        map.remove(lastElement);
        list.remove(lastIndex--);
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        int index = rand.nextInt(lastIndex + 1);
        return list.get(index);
    }
}
