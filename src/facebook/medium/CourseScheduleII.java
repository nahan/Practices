package facebook.medium;

// https://leetcode.com/problems/course-schedule/

// 207

// https://leetcode.com/problems/course-schedule-ii/

// 210

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Han on 10/14/16.
 */
public class CourseScheduleII {

    // 207
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

    // 207
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
}
