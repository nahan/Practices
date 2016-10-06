package facebook.easy;

// https://leetcode.com/problems/first-bad-version/

// 278

public class FirstBadVersion {
    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (!isBadVersion(mid)) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
    
    // dummy method
    boolean isBadVersion(int version) {
        return false;
    }
}
