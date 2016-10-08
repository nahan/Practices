package facebook.medium;

// https://leetcode.com/problems/decode-ways/

// 91

public class DecodeWays {

    // DP solution
    // dp[i]:
    // 1. dp[i + 1], if s[i, i + 1] cannot be encoded
    // 2. dp[i + 1] + dp[i + 2], if s[i, i + 1] can be encoded
    public int numDecodings(String s) {
        if (s == null || s.isEmpty() || s.equals("0")) {
            return 0;
        }
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[n] = 1;
        dp[n - 1] = s.charAt(n - 1) == '0' ? 0 : 1;
        for (int i = n - 2; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                continue;
            }
            int num = Integer.parseInt(s.substring(i, i + 2));
            if (num <= 26) {
                dp[i] = dp[i + 2] + dp[i + 1];
            } else {
                dp[i] = dp[i + 1];
            }
        }
        return dp[0];
    }
}
