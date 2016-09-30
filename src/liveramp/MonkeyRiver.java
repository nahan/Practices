package liveramp;

public class MonkeyRiver {
    
    public static int jumpRiver(int[] A, int D) {
        if (A == null || A.length == 0) {
            return -1;
        }
        if (D > A.length) {
            return 0;
        }
        int[] arrivingTime = new int[A.length];
        for (int i = 0; i < D; i++) {
            arrivingTime[i] = A[i];
        }
        for (int i = D; i < A.length; i++) {
            if (A[i] == -1) {
                arrivingTime[i] = -1;
            } else {
                int min = Integer.MAX_VALUE;
                for (int j = 1; j <= D; j++) {
                    if (arrivingTime[i - j] == -1) {
                        continue;
                    }
                    min = Math.min(min, arrivingTime[i - j]);
                }
                if (min == Integer.MAX_VALUE) {
                    arrivingTime[i] = -1;
                } else {
                    arrivingTime[i] = Math.max(min, A[i]);
                }
            }
        }
        int result = A.length - 1;
        for (int i = 1; i <= D; i++) {
            if (arrivingTime[A.length - i] == -1) {
                continue;
            }
            result = Math.min(result, arrivingTime[A.length - i]);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] A = {1, -1, 0, 2, 3, 5};
        int D = 3;
        System.out.println(jumpRiver(A, D));
        
        int[] B = {3, 4, 5, 0, 1, 2};
        System.out.println(jumpRiver(B, D));
    }

}
