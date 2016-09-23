
package godaddy;

public class NextPermutationString {
    
    public String nextPermutaion(String s) {
        char[] c = s.toCharArray();
        int i = c.length - 2;
        while (i >= 0 && c[i] >= c[i + 1]) {
            i--;
        }
        if (i < 0) {
            return "no answer";
        }
        int j = c.length - 1;
        while (j >= 0 && c[j] <= c[i]) {
            j--;
        }
        swap(c, i, j);
        reverse(c, i + 1, c.length - 1);
        return new String(c);
    }
    
    private void reverse(char[] c, int i, int j) {
        while (i < j) {
            swap(c, i, j);
            i++;
            j--;
        }
    }

    private void swap(char[] c, int i, int j) {
        char temp = c[i];
        c[i] = c[j];
        c[j] = temp;
    }
    
    public static void main(String[] args) {
        NextPermutationString solution = new NextPermutationString();
        System.out.println(solution.nextPermutaion("pp"));
        System.out.println(solution.nextPermutaion("hefg"));
        System.out.println(solution.nextPermutaion("abcd"));
        System.out.println(solution.nextPermutaion("dcba"));
        System.out.println(solution.nextPermutaion("dcab"));
    }

}
