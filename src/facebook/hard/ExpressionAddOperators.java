package facebook.hard;

// https://leetcode.com/problems/expression-add-operators/
// 282

//        "123", 6 -> ["1+2+3", "1*2*3"]
//        "232", 8 -> ["2*3+2", "2+3*2"]
//        "105", 5 -> ["1*0+5","10-5"]
//        "00", 0 -> ["0+0", "0-0", "0*0"]
//        "3456237490", 9191 -> []

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Han on 10/26/16.
 */
public class ExpressionAddOperators {


    // a dfs solution
    public List<String> addOperators(String num, int target) {
        List<String> result = new ArrayList<>();
        if (num == null || num.isEmpty()) {
            return result;
        }
        dfs(result, num, "", 0, 0, 0, target);
        return result;
    }
    private void dfs(List<String> result, String num, String curEx, int index, long preEle, long sum, int target) {
        if (sum == target && index == num.length()) {
            result.add(curEx);
            return;
        }
        for (int i = index; i < num.length(); i++) {
            if (i != index && num.charAt(index) == '0') {
                break;
            }
            long n = Long.parseLong(num.substring(index, i + 1));
            if (index == 0) {
                dfs(result, num, curEx + n, i + 1, n, sum + n, target);
            } else {
                dfs(result, num, curEx + "+" + n, i + 1, n, sum + n, target);
                dfs(result, num, curEx + "-" + n, i + 1, -n, sum - n, target);
                dfs(result, num, curEx + "*" + n, i + 1, preEle * n, sum - preEle + preEle * n, target);
            }
        }
    }
}
