package godaddy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class StringSubSet {
    
    public String[] subset(String s) {
        Set<String> set = new HashSet<>();
        StringBuilder builder = new StringBuilder();
        boolean[] visited = new boolean[s.length()];
        dfs(set, builder, s, visited, 0);
        String[] result = new String[set.size()];
        result = set.toArray(result);
        Arrays.sort(result);
        return result;
    }
    
    private void dfs(Set<String> set, StringBuilder builder, String s, boolean[] visited, int index) {
        if (builder.length() != 0 && !set.contains(builder)) {
            set.add(builder.toString());
        }
        for (int i = 0; i < s.length(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                builder.append(s.charAt(i));
                dfs(set, builder, s, visited, i);
                visited[i] = false;
                builder.deleteCharAt(builder.length() - 1);
            }
        }
    }
    
    public static void main(String[] args) {
        StringSubSet solution = new StringSubSet();
        System.out.println(Arrays.toString(solution.subset("bab")));
        System.out.println(Arrays.toString(solution.subset("babcd")));
    }

}
