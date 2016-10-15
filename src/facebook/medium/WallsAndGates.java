package facebook.medium;

// https://leetcode.com/problems/walls-and-gates/

// 286

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Han on 10/14/16.
 */
public class WallsAndGates {

    // 1. a brute-force solution
    // do a BFS on each gate
    public void wallsAndGates(int[][] rooms) {
        if (rooms == null || rooms.length == 0 || rooms[0].length == 0) {
            return;
        }
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                if (rooms[i][j] == 0) {
                    bfs(rooms, i, j);
                }
            }
        }
    }
    private void bfs(int[][] rooms, int m, int n) {
        boolean[][] visited = new boolean[rooms.length][rooms[0].length];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(m * rooms[0].length + n);
        visited[m][n] = true;
        while (!queue.isEmpty()) {
            int k = queue.poll();
            int i = k / rooms[0].length;
            int j = k % rooms[0].length;
            int distance = rooms[i][j];
            if (i - 1 >= 0 && rooms[i - 1][j] > 0 && !visited[i - 1][j]) {
                rooms[i - 1][j] = Math.min(rooms[i - 1][j], distance + 1);
                queue.offer((i - 1) * rooms[0].length + j);
                visited[i - 1][j] = true;
            }
            if (i + 1 < rooms.length && rooms[i + 1][j] > 0 && !visited[i + 1][j]) {
                rooms[i + 1][j] = Math.min(rooms[i + 1][j], distance + 1);
                queue.offer((i + 1) * rooms[0].length + j);
                visited[i + 1][j] = true;
            }
            if (j - 1 >= 0 && rooms[i][j - 1] > 0 && !visited[i][j - 1]) {
                rooms[i][j - 1] = Math.min(rooms[i][j - 1], distance + 1);
                queue.offer(i * rooms[0].length + j - 1);
                visited[i][j - 1] = true;
            }
            if (j + 1 < rooms[0].length && rooms[i][j + 1] > 0 && !visited[i][j + 1]) {
                rooms[i][j + 1] = Math.min(rooms[i][j + 1], distance + 1);
                queue.offer(i * rooms[0].length + j + 1);
                visited[i][j + 1] = true;
            }
        }
    }

    // 2. add all gates into the queue,
    // then do a BFS
    public void wallsAndGatesII(int[][] rooms) {
        if (rooms == null || rooms.length == 0 || rooms[0].length == 0) {
            return;
        }
        Queue<Integer> queue = new LinkedList<>();
        boolean[][] visited = new boolean[rooms.length][rooms[0].length];
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                if (rooms[i][j] == 0) {
                    queue.offer(i * rooms[0].length + j);
                    visited[i][j] = true;
                }
            }
        }
        while (!queue.isEmpty()) {
            int k = queue.poll();
            int i = k / rooms[0].length;
            int j = k % rooms[0].length;
            int distance = rooms[i][j];
            if (i - 1 >= 0 && rooms[i - 1][j] > 0 && !visited[i - 1][j]) {
                rooms[i - 1][j] = Math.min(rooms[i - 1][j], distance + 1);
                queue.offer((i - 1) * rooms[0].length + j);
                visited[i - 1][j] = true;
            }
            if (i + 1 < rooms.length && rooms[i + 1][j] > 0 && !visited[i + 1][j]) {
                rooms[i + 1][j] = Math.min(rooms[i + 1][j], distance + 1);
                queue.offer((i + 1) * rooms[0].length + j);
                visited[i + 1][j] = true;
            }
            if (j - 1 >= 0 && rooms[i][j - 1] > 0 && !visited[i][j - 1]) {
                rooms[i][j - 1] = Math.min(rooms[i][j - 1], distance + 1);
                queue.offer(i * rooms[0].length + j - 1);
                visited[i][j - 1] = true;
            }
            if (j + 1 < rooms[0].length && rooms[i][j + 1] > 0 && !visited[i][j + 1]) {
                rooms[i][j + 1] = Math.min(rooms[i][j + 1], distance + 1);
                queue.offer(i * rooms[0].length + j + 1);
                visited[i][j + 1] = true;
            }
        }
    }

    public static void main(String[] args) {
        int[][] test = {{2147483647,-1,0,2147483647},{2147483647,2147483647,2147483647,-1},{2147483647,-1,2147483647,-1},{0,-1,2147483647,2147483647}};
        for (int[] t: test) {
            System.out.println(Arrays.toString(t));
        }
        System.out.println("================================================");
        WallsAndGates solution = new WallsAndGates();
        solution.wallsAndGatesII(test);
        for (int[] t: test) {
            System.out.println(Arrays.toString(t));
        }
    }
}
