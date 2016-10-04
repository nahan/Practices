package facebook.easy;

import java.util.Stack;

// https://leetcode.com/problems/valid-parentheses/

// 20

public class ValidParentheses {

    public boolean isValid(String s) {
        if (s == null || s.length() % 2 != 0) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (stack.isEmpty() || c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else if (c == ')') {
                if (stack.pop() != '(') {
                    return false;
                }
            } else if (c == ']') {
                if (stack.pop() != '[') {
                    return false;
                }
            } else if (c == '}') {
                if (stack.pop() != '{') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
    
}
