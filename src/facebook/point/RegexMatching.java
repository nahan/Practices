package facebook.point;

//    http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=206905&extra=page%3D1%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3086%5D%5Bvalue%5D%3D6%26searchoption%5B3086%5D%5Btype%5D%3Dradio%26searchoption%5B3087%5D%5Bvalue%5D%3D4%26searchoption%5B3087%5D%5Btype%5D%3Dradio%26searchoption%5B3089%5D%5Bvalue%5D%5B3%5D%3D3%26searchoption%5B3089%5D%5Btype%5D%3Dcheckbox%26searchoption%5B3046%5D%5Bvalue%5D%3D2%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D311
//    
//    2016(10-12月) 码农类 硕士 全职@Facebook - 内推 - Onsite |Passfresh grad应届毕业生
//    今天刚收到fb的offer。进度条：8.23内推 - 9.20约 on campus - 9.23 on campus面试 - 9.26 通知onsit - 10.14 on site - 10.21 收到offer
//    由于签了NDA，这里就只说一下我个人觉得比较有意思的题目。
//    climbing stairs， rotate matrix
//    Populating Next Right Pointers in Each Node II, regex matching, decoding ways, two sums
//    我碰到了两轮behavior...应该有一轮是加面
//    ----------------------------------------
//    其实完全没想到能拿到Offer，只能说感谢behavior的三哥没有黑我吧，当然还有其他的面试官手下留情。

// https://leetcode.com/problems/regular-expression-matching/
// 10

//        '.' Matches any single character.
//        '*' Matches zero or more of the preceding element.
//
//        The matching should cover the entire input string (not partial).
//
//        The function prototype should be:
//        bool isMatch(const char *s, const char *p)
//
//        Some examples:
//        isMatch("aa","a") -> false
//        isMatch("aa","aa") -> true
//        isMatch("aaa","aa") -> false
//        isMatch("aa", "a*") -> true
//        isMatch("aa", ".*") -> true
//        isMatch("ab", ".*") -> true
//        isMatch("aab", "c*a*b") -> true
//        isMatch("a", "ab*") -> true

public class RegexMatching {

    // a recursive solution
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }
        // case 1: p is empty
        if (p.isEmpty()) {
            return s.isEmpty();
        }
        // case 2: p is a character
        if (p.length() == 1) {
            if (s.length() == 1 && (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.')) {
                return true;
            }
            return false;
        }
        // case 3: p contains at least two characters
        // case 3.1: the second character is not '*' in p
        if (p.charAt(1) != '*') {
            if (!s.isEmpty() && (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.')) {
                return isMatch(s.substring(1), p.substring(1));
            }
            return false;
        }
        // case 3.2: the second character is '*' in p
        while (!s.isEmpty() && (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.')) {
            if (isMatch(s, p.substring(2))) {
                return true;
            }
            s = s.substring(1);
        }
        return isMatch(s, p.substring(2));
    }

    // a dp solution
    public boolean isMatchDP(String s, String p) {
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
