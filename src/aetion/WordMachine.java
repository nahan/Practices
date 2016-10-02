package aetion;

import java.util.Stack;

public class WordMachine {
    
    public int solution(String S) {
        if (S == null || S.isEmpty()) {
            return -1;
        }
        String[] list = S.split(" ");
        Stack<Long> stack = new Stack<>();
        for (String item: list) {
            try {
                if (item.equals("POP")) {
                    stack.pop();
                } else if (item.equals("DUP")) {
                    stack.push(stack.peek());
                } else if (item.equals("+")) {
                    long n1 = stack.pop();
                    long n2 = stack.pop();
                    long n = n1 + n2;
                    if (!valid(n)) {
                        return -1;
                    }
                    stack.push(n1 + n2);
                } else if (item.equals("-")) {
                    long n1 = stack.pop();
                    long n2 = stack.pop();
                    long n = n1 - n2;
                    if (!valid(n)) {
                        return -1;
                    }
                    stack.push(n1 - n2);
                } else {
                    long n = Long.parseLong(item);
                    if (!valid(n)) {
                        return -1;
                    }
                    stack.push(n);
                }
            } catch (Exception e) {
                return -1;
            }
        }
        if (stack.isEmpty()) {
            return -1;
        }
        if (!valid(stack.peek())) {
            return -1;
        }
        long result = stack.peek();
        return (int) result;
    }
    
    private boolean valid(long n) {
        if (n >= 0 && n <= Math.pow(2, 20) - 1) {
            return true;
        }
        return false;
    }
    
    public static void main(String[] args) {
        WordMachine solution = new WordMachine();
        String s1 = "13 DUP 4 POP 5 DUP + DUP + -";
        String s2 = "5 6 + -";
        String s3 = "3 DUP 5 - -";
        String s4 = "";
        String s5 = null;
        String s6 = "4";
        String s7 = "DUP";
        System.out.println(String.format("input: %s, get: %s", s1, solution.solution(s1)));
        System.out.println(String.format("input: %s, get: %s", s2, solution.solution(s2)));
        System.out.println(String.format("input: %s, get: %s", s3, solution.solution(s3)));
        System.out.println(String.format("input: %s, get: %s", s4, solution.solution(s4)));
        System.out.println(String.format("input: %s, get: %s", s5, solution.solution(s5)));
        System.out.println(String.format("input: %s, get: %s", s6, solution.solution(s6)));
        System.out.println(String.format("input: %s, get: %s", s7, solution.solution(s7)));
        System.out.println(Integer.MAX_VALUE);
        long n = (long) Math.pow(2, 20);
        System.out.println(n - 1);
    }

}
