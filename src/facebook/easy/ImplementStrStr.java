package facebook.easy;

// https://leetcode.com/problems/implement-strstr/

// 28

public class ImplementStrStr {
    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null || needle.length() > haystack.length()) {
            return -1;
        }
        for (int i = 0; i + needle.length() <= haystack.length(); i++) {
            if (haystack.substring(i, i + needle.length()).equals(needle)) {
                return i;
            }
        }
        return -1;
    }
}
