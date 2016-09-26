package godaddy;

import java.util.*;

public class StringSubSet {
    
    public String[] subset(String s) {
        List<String> list = new ArrayList<>();
        StringBuilder builder = new StringBuilder();
        boolean[] visited = new boolean[s.length()];
        char[] array = s.toCharArray();
        Arrays.sort(array);
        dfs(list, builder, array, visited);
        String[] result = new String[list.size()];
        result = list.toArray(result);
        Arrays.sort(result);
        return result;
    }
    
    private void dfs(List<String> list, StringBuilder builder, char[] array, boolean[] visited) {
        if (builder.length() != 0) {
            list.add(builder.toString());
        }
        for (int i = 0; i < array.length; i++) {
            if (visited[i]) {
                continue;
            }
            if (i > 0 && array[i - 1] == array[i] && !visited[i - 1]) {
                continue;
            }
            visited[i] = true;
            builder.append(array[i]);
            dfs(list, builder, array, visited);
            builder.deleteCharAt(builder.length() - 1);
            visited[i] = false;
        }
    }
    
    public static void main(String[] args) {
        StringSubSet solution = new StringSubSet();
        System.out.println(Arrays.toString(solution.subset("abc")));
        System.out.println(Arrays.toString(solution.subset("bab")));
        System.out.println(Arrays.toString(solution.subset("babcd")));
        System.out.println(Arrays.toString(solution.subset("aabbcc")));
    }

}
