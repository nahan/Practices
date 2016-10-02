package aetion;

public class ArithmeticPairs {
    public int solution(int[] A) {
        if (A == null || A.length < 3) {
            return 0;
        }
        long[] list = new long[A.length];
        for (int i = 1; i < A.length; i++) {
            list[i] = A[i] - A[i - 1];
        }
        return 0;
    }
}
