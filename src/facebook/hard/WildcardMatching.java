package facebook.hard;

// https://leetcode.com/problems/wildcard-matching/
// 44

//        '?' Matches any single character.
//        '*' Matches any sequence of characters (including the empty sequence).
//
//        The matching should cover the entire input string (not partial).
//
//        The function prototype should be:
//        bool isMatch(const char *s, const char *p)
//
//        Some examples:
//        isMatch("aa","a") → false
//        isMatch("aa","aa") → true
//        isMatch("aaa","aa") → false
//        isMatch("aa", "*") → true
//        isMatch("aa", "a*") → true
//        isMatch("ab", "?*") → true
//        isMatch("aab", "c*a*b") → false

/**
 * Created by Han on 10/26/16.
 */
public class WildcardMatching {

    // 1. a dp solution using a 2D array
    // cannot use a 1D array, think about "aaa" and "aa"
    // O(M * N)
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
            return (s.length() == 1 && (p.equals(s) || p.equals("?"))) || p.equals("*");
        }
        // dp starts
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int i = 1; i < n + 1; i++) {
            if (p.charAt(i - 1) == '*') {
                dp[0][i] = dp[0][i - 1];
            }
        }
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (p.charAt(j - 1) == s.charAt(i - 1) || p.charAt(j - 1) == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                }
                if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i - 1][j - 1] || dp[i][j - 1] || dp[i - 1][j];
                }
            }
        }
        return dp[m][n];
    }

    // 2. a linear solution
    // O(M)
    public boolean isMatchII(String s, String p) {
        int sIndex = 0;
        int pIndex = 0;
        int match = 0;
        int starIndex = -1;
        while (sIndex < s.length()) {
            // if p[pIndex] matches s[sIndex]
            // move forward both indexes
            if (pIndex < p.length() && (p.charAt(pIndex) == '?' || p.charAt(pIndex) == s.charAt(sIndex))) {
                sIndex++;
                pIndex++;
            } else if (pIndex < p.length() && p.charAt(pIndex) == '*') {
                // if hit a '*',
                // record its index
                // set matched index starts from current s index
                // move forward p index
                starIndex = pIndex;
                match = sIndex;
                pIndex++;
            } else if (starIndex != -1) {
                // set p index as star index + 1
                // extend matched space
                // set s index as match
                pIndex = starIndex + 1;
                match++;
                sIndex = match;
            } else {
                // no start found, no matching found
                // return false;
                return false;
            }
        }
        while (pIndex < p.length() && p.charAt(pIndex) == '*') {
            pIndex++;
        }
        return pIndex == p.length();
    }
}
