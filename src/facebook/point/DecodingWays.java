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

public class DecodingWays {

    // dp[i] = dp[i + 1] + dp[i + 2], if s.substring(i, i + 2) <= 26
    // dp[i] = dp[i + 1], else
    // go through from the end to the start
    // if we go through from the start, it doesn't work. for example: 102 can only be decoded as 10 and 2
    public int numDecodings(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        int[] dp = new int[s.length() + 1];
        dp[s.length()] = 1;
        dp[s.length() - 1] = s.charAt(s.length() - 1) == '0' ? 0 : 1;
        for (int i = s.length() - 2; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                continue;
            }
            if (Integer.parseInt(s.substring(i, i + 2)) <= 26) {
                dp[i] = dp[i + 1] + dp[i + 2];
            } else {
                dp[i] = dp[i + 1];
            }
        }
        return dp[0];
    }
}
