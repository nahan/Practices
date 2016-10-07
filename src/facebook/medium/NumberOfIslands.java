package facebook.medium;

/**
 * Created by Han on 10/6/16.
 */

// https://leetcode.com/problems/number-of-islands/

// 200

public class NumberOfIslands {

    // 1. union-find solution
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int count = 0;
        int m = grid.length;
        int n = grid[0].length;
        UF uf = new UF(m * n);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    if (i > 0 && grid[i - 1][j] == '1') {
                        uf.union((i - 1) * n + j, i * n + j);
                    }
                    if (j > 0 && grid[i][j - 1] == '1') {
                        uf.union(i * n + j - 1, i * n + j);
                    }
                }
            }
        }
        return count - uf.size();
    }

    class UF {
        int[] id;
        int size;
        public UF(int n) {
            id = new int[n];
            for (int i = 0; i < n; i++) {
                id[i] = i;
            }
            size = 0;
        }
        public int size() {
            return size;
        }
        public void union(int p, int q) {
            int i = find(p);
            int j = find(q);
            if (i == j) {
                return;
            }
            id[j] = i;
            size++;
        }
        public int find(int p) {
            while (p != id[p]) {
                p = id[p];
            }
            return p;
        }
    }

    // 2. dfs solution
    public int numIslandsII(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int count = 0;
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    count++;
                    dfs(grid, visited, i, j);
                }
            }
        }
        return count;
    }
    public void dfs(char[][] grid, boolean[][] visited, int i, int j) {
        if (i < 0 || i >= grid.length) {
            return;
        }
        if (j < 0 || j >= grid[0].length) {
            return;
        }
        if (visited[i][j]) {
            return;
        }
        if (grid[i][j] != '1') {
            return;
        }
        visited[i][j] = true;
        dfs(grid, visited, i - 1, j);
        dfs(grid, visited, i + 1, j);
        dfs(grid, visited, i, j - 1);
        dfs(grid, visited, i, j + 1);
    }
}
