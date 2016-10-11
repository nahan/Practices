package facebook.medium;

// https://leetcode.com/problems/powx-n/

// 50

public class Pow {
    
    // recursive binary search
    // O(lgN)
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            // if n is minimum integer
            // then convert it to positive value can occur overflow
            // for example:
            // 3 ^ (-4) = 1 / (3 ^ 4)
            // = 1 / ((3 ^ 2) ^ (4 / 2))
            if (n == Integer.MIN_VALUE) {
                return 1 / myPow(x * x, -(n / 2));
            } else {
                return 1 / myPow(x, -n);
            }
        }
        return (n % 2 == 0) ? myPow(x * x, n / 2) : x * myPow(x * x, n / 2);
    }

}
