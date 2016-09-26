package walmart;
import java.util.*;
//    http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=201884&highlight=walmart

//    2016(7-9月) 码农类 硕士 全职@Walmart lab - 内推 - 技术电面 |Passfresh grad应届毕业生
//    题目是给你n 个骰子（6面的那种）， 问你输出所有可能的掷完骰子的数字组合 (dfs). 还问了为啥想来walmart lab 之类的问题。

public class DiceCombination {
    
    public static List<List<Integer>> diceComb(int n) {
        List<List<Integer>> result = new ArrayList<>();
        if (n == 0) {
            return result;
        }
        int[][] dices = new int[n][6];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 6; j++) {
                dices[i][j] = j + 1;
            }
        }
        List<Integer> item = new ArrayList<>();
        dfs(result, item, dices, 0, 0);
        
        return result;
    }
    
    public static void dfs(List<List<Integer>> result, List<Integer> item, int[][] dices, int x, int y) {
        if (x == dices.length) {
            result.add(new ArrayList<>(item));
            return;
        }
        for (int i = y; i < 6; i++) {
            item.add(dices[x][i]);
            dfs(result, item, dices, x + 1, i);
            item.remove(item.size() - 1);
        }
    }
    
    public static void main(String[] args) {
        
        System.out.println(diceComb(1));
        System.out.println(diceComb(2));
        System.out.println(diceComb(3));
        
    }

}
