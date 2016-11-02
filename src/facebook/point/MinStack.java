package facebook.point;

// https://leetcode.com/problems/min-stack/
// 155

import java.util.Stack;

/**
 * Created by Han on 11/2/16.
 */
public class MinStack {

    private Stack<Integer> stack;
    private int min;
    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<Integer>();
        min = Integer.MAX_VALUE;
    }
    public void push(int x) {
        if (x <= min) {
            stack.push(min);
            min = x;
        }
        stack.push(x);
    }
    public void pop() {
        if (stack.empty()) {
            return;
        }
        if (stack.peek() == min) {
            stack.pop();
            min = stack.pop();
        } else {
            stack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }

}
