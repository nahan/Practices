package facebook.medium;

/**
 * Created by Han on 10/6/16.
 */

//    https://leetcode.com/problems/one-edit-distance/
//
//    161

public class OneEditDistance {

    // 1. recursive solution
    public boolean isOneEditDistance(String s, String t) {
        if (s == null || t == null) {
            return false;
        }
        if (s.length() > t.length()) {
            return isOneEditDistance(t, s);
        }
        if (s.isEmpty()) {
            return t.length() == 1;
        }
        if (s.charAt(0) == t.charAt(0)) {
            return isOneEditDistance(s.substring(1), t.substring(1));
        } else {
            if (s.length() == t.length()) {
                return s.substring(1).equals(t.substring(1));
            } else {
                return s.equals(t.substring(1));
            }
        }
    }

    // 2. brute-force solution
    public boolean isOneEditDistanceII(String s, String t) {
        if (s == null || t == null) {
            return false;
        }
        if (s.length() > t.length()) {
            return isOneEditDistance(t, s);
        }
        if (t.length() - s.length() > 1) {
            return false;
        }
        int diff = 0;
        int i = 0;
        int j = 0;
        if (s.length() == t.length()) {
            while (i < s.length()) {
                if (s.charAt(i++) != t.charAt(j++)) {
                    diff++;
                }
            }
            return diff == 1;
        } else {
            while (i < s.length() && j < t.length()) {
                if (s.charAt(i) != t.charAt(j++)) {
                    diff++;
                } else {
                    i++;
                }
            }
        }
        return diff <= 1;
    }

    // 3. substring
    public boolean isOneEditDistanceIII(String s, String t) {
        if (s == null || t == null) {
            return false;
        }
        if (s.length() > t.length()) {
            return isOneEditDistance(t, s);
        }
        if (t.length() - s.length() > 1) {
            return false;
        }
        int i = 0;
        int j = 0;
        if (s.length() == t.length()) {
            while (i < s.length()) {
                if (s.charAt(i++) != t.charAt(j++)) {
                    return s.substring(i).equals(t.substring(j));
                }
            }
            return false;
        } else {
            while (i < s.length() && j < t.length()) {
                if (s.charAt(i) != t.charAt(j++)) {
                    return s.substring(i).equals(t.substring(j));
                } else {
                    i++;
                }
            }
            return true;
        }
    }
}
