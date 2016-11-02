package facebook.point;

// https://leetcode.com/problems/generate-parentheses/
// 22

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Han on 11/2/16.
 */
public class GenerateParentheses {

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<String>();
        directedGenerateBalancedParenthsises(n, n, "", result);
        return result;
    }

    private void directedGenerateBalancedParenthsises(int leftParensNeeded, int rightParensNeeded, String validPrefix, List<String> result) {
        if (leftParensNeeded == 0 && rightParensNeeded == 0) {
            result.add(validPrefix);
            return;
        }
        if (leftParensNeeded > 0) {
            directedGenerateBalancedParenthsises(leftParensNeeded - 1, rightParensNeeded, validPrefix + "(", result);
        }
        if (leftParensNeeded < rightParensNeeded) {
            directedGenerateBalancedParenthsises(leftParensNeeded, rightParensNeeded - 1, validPrefix + ")", result);
        }
    }
    public static void main(String[] args) {
        GenerateParentheses solution = new GenerateParentheses();
        System.out.println(solution.generateParenthesis(4));

    }
}
