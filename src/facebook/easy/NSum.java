package facebook.easy;

import java.util.*;

public class NSum {
    
    public static List<List<String>> nSum(String s, int target) {
        List<List<String>> result = new ArrayList<>();
        
        if (s == null || s.isEmpty() || target < 0) {
            return result;
        }
        
        if (Integer.parseInt(s) == target) {
            result.add(Arrays.asList(s));
            return result;
        }
        
        List<String> item = new ArrayList<>();
        dfs(result, item, s, target, 0);
        
        return result;
    }
    
    public static void dfs(List<List<String>> result, List<String> item, String s, int target, int curSum) {
        if (curSum == target) {
            result.add(new ArrayList<>(item));
            return;
        }
        for (int i = 1; i <= s.length(); i++) {
            String sub = s.substring(0, i);
            int cur = Integer.parseInt(sub);
            if (curSum + cur <= target) {
                item.add(sub);
                dfs(result, item, s.substring(i), target, curSum + cur);
                item.remove(item.size() - 1);
            }
        }
    }
    
    public static void main(String[] args) {
        System.out.println(nSum("1234", 46));
        System.out.println(nSum("111", 12));
        System.out.println(nSum("111", 0));
        System.out.println(nSum("0", 0));
    }

}
