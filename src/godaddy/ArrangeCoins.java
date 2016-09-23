package godaddy;

public class ArrangeCoins {
    
    public int arrange(int n) {
        double x = (Math.sqrt(8 * n + 1) - 1) / 2;
        return (int) x;
    }
    
    public static void main(String[] args) {
        ArrangeCoins solution = new ArrangeCoins();
        System.out.println(solution.arrange(1));
        System.out.println(solution.arrange(3));
        System.out.println(solution.arrange(6));
        System.out.println(solution.arrange(10));
        System.out.println(solution.arrange(15));
        System.out.println(solution.arrange(21));
        System.out.println(solution.arrange(28));
        System.out.println(solution.arrange(36));
        
        System.out.println(solution.arrange(35));
        System.out.println(solution.arrange(0));
        
        
        
        System.out.println(solution.arrange(2));
        System.out.println(solution.arrange(5));
        System.out.println(solution.arrange(8));
        System.out.println(solution.arrange(3));
    }

}
