package facebook.easy;

// https://leetcode.com/problems/count-and-say/

public class CountAndSay {
    public String countAndSay(int n) {
        String pre = "1";
        for (int i = 1; i < n; i++) {
            StringBuilder builder = new StringBuilder();
            int count = 0;
            int start = 0;
            for (int j = 0; j < pre.length(); j++) {
                char c = pre.charAt(j);
                if (c == pre.charAt(start)) {
                    count++;
                } else {
                    builder.append(count).append(pre.charAt(start));
                    start = j;
                    count = 1;
                }
            }
            builder.append(count).append(pre.charAt(start));
            pre = builder.toString();
        }
        return pre;
    }
}
