package facebook.easy;

// https://leetcode.com/problems/add-binary/

// 67

public class AddBinary {
    public String addBinary(String a, String b) {
        if (a == null || b == null) {
            return a != null ? a : b;
        }
        if (a.length() < b.length()) {
            return addBinary(b, a);
        }
        int[] n = new int[a.length()];
        for (int i = a.length() - 1; i >= 0; i--) {
            n[a.length() - 1 - i] = a.charAt(i) - '0';
        }
        for (int i = b.length() - 1; i >= 0; i--) {
            n[b.length() - 1 - i] += b.charAt(i) - '0';
        }
        for (int i = 0; i < n.length - 1; i++) {
            if (n[i] > 1) {
                n[i + 1] += n[i] / 2;
                n[i] = n[i] % 2;
            }
        }
        String head = "";
        if (n[n.length - 1] > 1) {
            n[n.length - 1] %= 2;
            head = "1";
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < n.length; i++) {
            builder.append(n[i]);
        }
        builder.append(head);
        return builder.reverse().toString();
    }
}
