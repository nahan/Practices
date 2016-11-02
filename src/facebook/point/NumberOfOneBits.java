package facebook.point;

/**
 * Created by Han on 11/2/16.
 */
public class NumberOfOneBits {

    public int hammingWeight(int n) {
        int result = 0;
        while (n != 0) {
            if ((n & 1) == 1) {
                result++;
            }
            n >>>= 1;
        }
        return result;
    }

    public int hammingWeightII(int n) {

        int m1 = 0x55555555;
        int m2 = 0x33333333;
        int m4 = 0x0f0f0f0f;
        int m8 = 0x00ff00ff;
        int m16 = 0x0000ffff;

        n = (n & m1) + ((n >> 1) & m1);
        n = (n & m2) + ((n >> 2) & m2);
        n = (n & m4) + ((n >> 4) & m4);
        n = (n & m8) + ((n >> 8) & m8);
        n = (n & m16) + ((n >> 16) & m16);

        return n;
    }
    public static void main(String[] args) {
        NumberOfOneBits solution = new NumberOfOneBits();
        for (int i = 0; i < 101; i++) {
            System.out.println(solution.hammingWeight(i));
        }
    }
}
