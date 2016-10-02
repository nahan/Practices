package godaddy;

import java.util.*;

public class BuildSubsequences {
    
    static String[] buildSubsequences(String s) {
        Set<String> set = new HashSet<>();
        if (s == null || s.isEmpty()) {
            return new String[0];
        }
        StringBuilder builder = new StringBuilder();
        dfs(set, builder, s, 0);
        String[] result = new String[set.size()];
        result = set.toArray(result);
        Arrays.sort(result);
        return result;
    }
    
    static void dfs(Set<String> set, StringBuilder builder, String s, int index) {
        if (builder.length() != 0) {
            set.add(builder.toString());
        }
        if (index == s.length()) {
            return;
        }
        for (int i = index; i < s.length(); i++) {
            builder.append(s.charAt(i));
            dfs(set, builder, s, i + 1);
            builder.deleteCharAt(builder.length() - 1);
        }
    }

}
