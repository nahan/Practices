package facebook.medium;

// https://leetcode.com/problems/multiply-strings/

// 43

public class MultiplyStrings {

    // take the reversed string to int arrays
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        if (num1.length() < num2.length()) {
            return multiply(num2, num1);
        }
        int[] n1 = toIntArray(new StringBuilder(num1).reverse().toString());
        int[] n2 = toIntArray(new StringBuilder(num2).reverse().toString());
        int[] result = new int[n1.length + n2.length];
        for (int i = 0; i < n2.length; i++) {
            int k = i;
            for (int j = 0; j < n1.length; j++) {
                result[k++] += (n1[j] * n2[i]);
            }
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < result.length - 1; i++) {
            if (result[i] > 9) {
                result[i + 1] += result[i] / 10;
                result[i] %= 10;
            }
            builder.append(result[i]);
        }
        if (result[result.length - 1] != 0) {
            builder.append(result[result.length - 1]);
        }
        return builder.reverse().toString();
    }
    public int[] toIntArray(String s) {
        int[] n = new int[s.length()];
        for (int i = 0; i < n.length; i++) {
            n[i] = s.charAt(i) - '0';
        }
        return n;
    }
}
