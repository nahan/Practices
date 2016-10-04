package facebook.easy;

// https://leetcode.com/problems/valid-palindrome/

// 125

public class ValidPalindrome {

    public boolean isPalindrome(String s) {
        if (s == null || s.isEmpty()) {
            return true;
        }
        s = s.toLowerCase();
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            char l = s.charAt(left);
            char r = s.charAt(right);
            if (!valid(l)) {
                left++;
                continue;
            }
            if (!valid(r)) {
                right--;
                continue;
            }
            if (l != r) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    
    private boolean valid(char c) {
        return (c >= 'a' && c <= 'z') || (c >= '0' && c <='9');
    }
    
}
