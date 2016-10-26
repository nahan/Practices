package facebook.medium;

// https://leetcode.com/problems/course-schedule/

// 207

// https://leetcode.com/problems/course-schedule-ii/

// 210

import java.util.*;

/**
 * Created by Han on 10/14/16.
 */
public class CourseScheduleII {

    // 207. CourseSchedule I
    // 1. DFS solution - O(V + E)
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            List<Integer> list = new ArrayList<>();
            graph.add(list);
        }
        for (int i = 0; i < prerequisites.length; i++) {
            int course = prerequisites[i][0];
            int pre = prerequisites[i][1];
            graph.get(course).add(pre);
        }
        boolean[] visited = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(graph, visited, i)) {
                return false;
            }
        }
        return true;
    }
    private boolean dfs(List<List<Integer>> graph, boolean[] visited, int course) {
        if (visited[course]) {
            return false;
        }
        visited[course] = true;
        List<Integer> pres = graph.get(course);
        for (int i = 0; i < pres.size(); i++) {
            int pre = pres.get(i);
            if (!dfs(graph, visited, pre)) {
                return false;
            }
        }
        visited[course] = false;
        return true;
    }

    // 207. CourseSchedule I
    // 2. DFS solution, use HashSet to reduce unnecessary computing
    public boolean canFinishII(int numCourses, int[][] prerequisites) {
        List<Set<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new HashSet<>());
        }
        for (int i = 0; i < prerequisites.length; i++) {
            int course = prerequisites[i][0];
            int pre = prerequisites[i][1];
            graph.get(course).add(pre);
        }
        boolean[] visited = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (!dfsII(graph, visited, i)) {
                return false;
            }
        }
        return true;
    }
    private boolean dfsII(List<Set<Integer>> graph, boolean[] visited, int course) {
        if (graph.get(course).isEmpty()) {
            return true;
        }
        if (visited[course]) {
            return false;
        }
        visited[course] = true;
        Set<Integer> pres = graph.get(course);
        while (!pres.isEmpty()) {
            int pre = pres.iterator().next();
            if (!dfsII(graph, visited, pre)) {
                return false;
            }
            // each time if a course can finish, remove it from the set
            pres.remove(pre);
        }
        visited[course] = false;
        return true;
    }

    // 210. Course Schedule II
    // topological sort using BFS
    // 1. build up the graph
    // 2. maintain a map of in degree of each node
    // 3. keep track of visited node
    // 4. maintain a queue storing node where node's in degree is 0
    // 5. poll out each node in the queue, add it to the result, go through its next node
    // 6. decrement next's in degree by 1
    // 7. add the next to the queue if its in degree is 0
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> graph = new ArrayList<>();
        int[] inDegree = new int[numCourses];
        boolean[] visited = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < prerequisites.length; i++) {
            int course = prerequisites[i][0];
            int pre = prerequisites[i][1];
            graph.get(pre).add(course);
            inDegree[course]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
                visited[i] = true;
            }
        }
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int next: graph.get(cur)) {
                if (!visited[next]) {
                    inDegree[next]--;
                    if (inDegree[next] == 0) {
                        queue.offer(next);
                        visited[next] = true;
                    }
                }
            }
            list.add(cur);
        }
        if (list.size() != numCourses) {
            return new int[0];
        }
        int[] result = new int[numCourses];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}
