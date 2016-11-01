package facebook.hard;

// https://leetcode.com/problems/the-skyline-problem/
// 218

import java.util.*;

/**
 * Created by Han on 10/27/16.
 */
public class TheSkylineProblem {

    // a solution of using priority queue
    // pq.remove(Object o)
    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> result = new ArrayList<>();
        if (buildings == null || buildings.length == 0 || buildings[0].length != 3) {
            return result;
        }
        List<Point> points = new ArrayList<>();
        // 1. add points to a list
        // 2. merge connecting buildings if needed
        int[] pre = buildings[0];
        for (int i = 1; i < buildings.length; i++) {
            int[] cur = buildings[i];
            if (pre[1] >= cur[0] && pre[2] == cur[2]) {
                pre[1] = cur[1];
            } else {
                points.add(new Point(pre[0], pre[2], true));
                points.add(new Point(pre[1], pre[2], false));
                pre = cur;
            }
        }
        points.add(new Point(pre[0], pre[2], true));
        points.add(new Point(pre[1], pre[2], false));
        // 3. sort points list
        Collections.sort(points, (a, b) -> a.x - b.x);
        // 4. initialize a priority queue of height descending
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        // 5. go through the points list
        for (Point point: points) {
            if (point.start) {
                pq.offer(point.height);
                if (point.height == pq.peek()) {
                    int[] item = new int[]{point.x, pq.peek()};
                    if (!result.isEmpty()) {
                        int[] last = result.get(result.size() - 1);
                        // keep the bigger height
                        if (item[0] == last[0]) {
                            item[1] = Math.max(item[1], last[1]);
                            result.remove(result.size() - 1);
                        }
                    }
                    result.add(item);
                }
            } else {
                int top = pq.peek();
                pq.remove(point.height);
                if (point.height == top) {
                    int[] item = new int[]{point.x, pq.isEmpty() ? 0 : pq.peek()};
                    if (!result.isEmpty()) {
                        int[] last = result.get(result.size() - 1);
                        // keep the smaller height
                        if (item[0] == last[0]) {
                            item[1] = Math.min(item[1], last[1]);
                            result.remove(result.size() - 1);
                        }
                    }
                    result.add(item);
                }
            }
        }
        return result;
    }
}
class Point {
    int x;
    int height;
    boolean start;
    public Point(int i, int h, boolean s) {
        x = i;
        height = h;
        start = s;
    }
    public String toString() {
        return x + "->" + height + "->" + start;
    }
}