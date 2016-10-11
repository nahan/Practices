package facebook.medium;

// https://leetcode.com/problems/sqrtx/

// 69

public class Sqrt {

    // multipy
    public int mySqrt(int x) {
        if (x < 0) {
            throw new IllegalArgumentException();
        }
        if (x < 2) {
            return x;
        }
        long t = (long) x;
        long left = 0;
        long right = x / 2 + 1;
        while (left < right) {
            long mid = (long) (left + (right - left) / 2);
            long sqr = mid * mid;
            if (sqr == t) {
                return (int) mid;
            }
            if (sqr < t) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return (int) left - 1;
    }
    
    // divide
    public int mySqrtII(int x) {
        if (x < 0) {
            throw new IllegalArgumentException();
        }
        if (x < 2) {
            return x;
        }
        int left = 1;
        int right = x;
        while (left < right) {
            int mid = left + (right - left) / 2;
            int p = x / mid;
            if (p == mid) {
                return mid;
            }
            if (p > mid) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left - 1;
    }
    
    // newton
    public int mySqrtIII(int x) {
        long r = (long) x;
        while (r * r > x) {
            r = (r + x / r) / 2;
        }
        return (int) r;
    }
}
