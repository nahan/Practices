package facebook.medium;

// https://leetcode.com/problems/word-break/

// 139

import java.util.Set;

/**
 * Created by Han on 10/6/16.
 */
public class WordBreak {

    public boolean wordBreak(String s, Set<String> wordDict) {
        if (s == null || s.isEmpty() || wordDict == null || wordDict.size() == 0) {
            return false;
        }
        boolean[] dp = new boolean[s.length()];
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                if (dp[j - 1]) {
                    continue;
                }
                String sub = s.substring(i, j);
                if (wordDict.contains(sub)) {
                    if (i == 0 || dp[i - 1]) {
                        dp[j - 1] = true;
                    }
                }
            }
        }
        return dp[dp.length - 1];
    }
}
