package facebook.hard;

import java.util.*;

// https://leetcode.com/problems/remove-invalid-parentheses/

// 301

public class RemoveInvalidParentheses {

    // a BFS solution
    // T(n) = n x C(n, n) + (n-1) x C(n, n-1) + ... + 1 x C(n, 1) = n x 2^(n-1).
    public List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<>();
        if (s == null) {
            return result;
        }
        Queue<String> queue = new LinkedList<>();
        Set<String> invalid = new HashSet<>();
        queue.offer(s);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();
                if (isValid(cur)) {
                    result.add(cur);
                    continue;
                } else {
                    for (int j = 0; j < cur.length(); j++) {
                        if (cur.charAt(j) != '(' && cur.charAt(j) != ')') {
                            continue;
                        }
                        invalid.add(cur);
                        String sub = cur.substring(0, j) + cur.substring(j + 1);
                        if (invalid.add(sub)) {
                            queue.offer(sub);
                        }
                    }
                }
            }
            if (result.size() != 0) {
                break;
            }
        }
        return result;
    }
    private boolean isValid(String s) {
        int open = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                open++;
            } else if (c == ')') {
                if (open <= 0) {
                    return false;
                }
                open--;
            }
        }
        return open == 0;
    }
    
    public static void main(String[] args) {
        RemoveInvalidParentheses solution = new RemoveInvalidParentheses();
        System.out.println(solution.removeInvalidParentheses("()(((((((()"));
        System.out.println(solution.removeInvalidParentheses("()())()"));
    }
}
