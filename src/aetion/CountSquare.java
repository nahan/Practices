package aetion;

public class CountSquare {
    
    public int solution(int A, int B) {
        if (B < 0) {
            return 0;
        }
        if (A < 0) {
            return solution(0, B);
        }
        int count = 0;
        int i = 0;
        while (i <= B) {
            if (i * i > B) {
                break;
            }
            if (i * i >= A) {
                System.out.println(i * i);
                count++;
            }
            i++;
            
        }
        return count;
    }
    
    public static void main(String[] args) {
        CountSquare solution = new CountSquare();
        
        System.out.println("result: " + solution.solution(4, 17));
        
        System.out.println("result: " + solution.solution(0, 17));
        System.out.println("result: " + solution.solution(0, 4));
        System.out.println("result: " + solution.solution(-4, 0));
        System.out.println("result: " + solution.solution(-17, 0));
        System.out.println("result: " + solution.solution(-17, 17));
        System.out.println("result: " + solution.solution(-17, -4));
        System.out.println("result: " + solution.solution(-10000, 10000));
    }

}
