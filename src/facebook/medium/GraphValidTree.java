package facebook.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Han on 10/6/16.
 */

// https://leetcode.com/problems/graph-valid-tree/

// 261

public class GraphValidTree {
    public boolean validTree(int n, int[][] edges) {
        if (n < 2) {
            return true;
        }
        if (n - 1 != edges.length) {
            return false;
        }
        List<Integer>[] graph = new List[n];


        for (int[] e: edges) {
            int v1 = e[0];
            int v2 = e[1];
            if (graph[v1] == null) {
                graph[v1] = new ArrayList<>();
            }
            if (graph[v2] == null) {
                graph[v2] = new ArrayList<>();
            }
            graph[v1].add(v2);
            graph[v2].add(v1);
        }
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (graph[i] == null) {
                return false;
            }
            if (!visited[i] && !dfs(graph, visited, i, i)) {
                return false;
            }
        }
        return true;
    }
    private boolean dfs(List<Integer>[] graph, boolean[] visited, int cur, int from) {
        visited[cur] = true;

        for (int i = 0; i < graph[cur].size(); i++) {
            if (!visited[graph[cur].get(i)]) {
                if (!dfs(graph, visited, graph[cur].get(i), cur)) {
                    return false;
                }
            } else if (graph[cur].get(i) != from) {
                return false;
            }
        }

        return true;
    }
}
