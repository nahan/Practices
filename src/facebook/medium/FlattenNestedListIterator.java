package facebook.medium;

// https://leetcode.com/problems/flatten-nested-list-iterator/

// 341

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 * Created by Han on 10/14/16.
 */
public class FlattenNestedListIterator implements Iterator<Integer> {

    private Stack<Integer> stack;

    public FlattenNestedListIterator(List<NestedInteger> nestedList) {
        stack = new Stack<>();
        pushNestedInteger(nestedList);
    }

    // push each node in a DFS way
    private void pushNestedInteger(List<NestedInteger> nestedList) {
        for (int i = nestedList.size() - 1; i >= 0; i--) {
            NestedInteger node = nestedList.get(i);
            // if the current node is an integer, push it into the stack
            if (node.isInteger()) {
                stack.push(node.getInteger());
            } else {
                // the current node is a list
                List<NestedInteger> list = node.getList();
                // skip empty list
                if (list.isEmpty()) {
                    continue;
                }
                // recursively push this list
                pushNestedInteger(list);
            }
        }
    }

    @Override
    public Integer next() {
        return stack.pop();
    }

    @Override
    public boolean hasNext() {
        return !stack.isEmpty();
    }
}
