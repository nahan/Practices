package facebook.hard;

// https://leetcode.com/problems/regular-expression-matching/
// 10

/**
 * Created by Han on 10/26/16.
 */
public class RegularExpressionMatching {

    public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }
        // case 1: p is emtpy
        if (p.isEmpty()) {
            return s.isEmpty();
        }
        // case 2: p is a character
        if (p.length() == 1) {
            return s.length() == 1 && (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.');
        }
        if (p.charAt(0) == '*') {
            return false;
        }
        // dp solution
        // dp[i][j] means whether s[0, i - 1] matches p[0, j - 1], here i, j starts from index 1
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        // set each '*' as the same status as remove it and its preceding
        // for example: ab*c, the status on '*' is same as the status on 'a'
        for (int i = 1; i < n + 1; i++) {
            if (p.charAt(i - 1) == '*') {
                dp[0][i] = dp[0][i - 2];
            }
        }
        // dp starts
        // i and j starts from index 1, so we need to see i - 1 and j - 1 on the strings
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                // if p[j - 1] == s[j - 1] or p[j - 1] == '.',
                // then, dp[i][j] = dp[i - 1][j - 1]
                if (p.charAt(j - 1) == s.charAt(i - 1) || p.charAt(j - 1) == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                }
                // if p[j - 1] == '*'
                if (p.charAt(j - 1) == '*') {
                    // if p[j - 2] cannot match s[i - 1],
                    // then set '*' as the same status as remove it and its preceding
                    if (p.charAt(j - 2) != s.charAt(i - 1) && p.charAt(j - 2) != '.') {
                        dp[i][j] = dp[i][j - 2];
                    } else {
                        // if p[j - 2] matches s[i - 1],
                        // for example, "a*" and "aaa"
                        // "a*" = "" -> dp[i][j - 2], empty
                        // "a*" = "a" -> dp[i][j - 1], one character
                        // "a*" = "aaa" -> dp[i - 1][j], multiple characters
                        dp[i][j] = dp[i][j - 2] || dp[i][j - 1] || dp[i - 1][j];
                    }
                }
            }
        }
        return dp[m][n];
    }
}
