package facebook.medium;

import java.util.Stack;

public class SimplifyPath {

    public String simplifyPath(String path) {
        if (path == null || path.isEmpty()) {
            return "/";
        }
        Stack<String> stack = new Stack<>();
        String[] list = path.split("/");
        for (String item: list) {
            if (item.isEmpty() || item.equals(".")) {
                continue;
            }
            if (item.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push("/" + item);
            }
        }
        if (stack.isEmpty()) {
            return "/";
        }
        StringBuilder builder = new StringBuilder();
        for (String item: stack) {
            builder.append(item);
        }
        return builder.toString();
    }
}
