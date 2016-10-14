package facebook.medium;

// https://leetcode.com/problems/sparse-matrix-multiplication/

// 311

public class SparseMatrixMultiplication {
    
    public static void main(String[] args) {
        Runnable r = () -> System.out.println("Hello World");
        r.run();
        
        Thread t = new Thread(() -> {
            System.out.println("Hello World");
            System.out.println("Hello Nancy");
        });
        t.start();
    }
    
    // 1. a TLE solution, compute on each position
    public int[][] multiply(int[][] A, int[][] B) {
        int[][] result = new int[A.length][B[0].length];
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                result[i][j] = multiply(A, B, i, j);
            }
        }
        return result;
    }
    private int multiply(int[][] A, int[][] B, int m, int n) {
        int sum = 0;
        for (int i = 0; i < A[0].length; i++) {
            sum += A[m][i] * B[i][n];
        }
        return sum;
    }
    
    // 2. do some reduction, avoid repeated computing
    public int[][] multiplyII(int[][] A, int[][] B) {
        int[][] result = new int[A.length][B[0].length];
        for (int i = 0; i < result.length; i++) {
            for (int k = 0; k < A[0].length; k++) {
                // if this position is zero then skip it
                if (A[i][k] != 0) {
                    for (int j = 0; j < result[0].length; j++) {
                        // if this position is zero then skip it
                        if (B[k][j] != 0) {
                            result[i][j] += A[i][k] * B[k][j];
                        }
                    }
                }
            }
        }
        return result;
    }
}
