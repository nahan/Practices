package facebook.point;

// https://leetcode.com/problems/reconstruct-itinerary/
// 332

import java.util.*;

/**
 * Created by Han on 11/2/16.
 */
public class ReconstructItinerary {

    // 1. leetcode
    public List<String> findItinerary(String[][] tickets) {

        List<String> result = new ArrayList<>();
        Map<String, PriorityQueue<String>> map = new HashMap<>();

        for (String[] ticket : tickets) {
            map.putIfAbsent(ticket[0], new PriorityQueue<>());
            map.get(ticket[0]).offer(ticket[1]);
        }

        dfs(result, map, "JFK");
        Collections.reverse(result);
        return result;
    }

    private void dfs(List<String> result,
                     Map<String, PriorityQueue<String>> map, String cur) {

        PriorityQueue<String> pq = map.get(cur);
        while (pq != null && !pq.isEmpty()) {
            dfs(result, map, pq.poll());
        }

        result.add(cur);
    }

    // 2. unknown first depart => it must be an acyclic graph
    public List<String> constructItinerary(String[][] tickets) {

        List<String> result = new ArrayList<>();

        Map<String, PriorityQueue<String>> map = new HashMap<>();
        for (String[] ticket : tickets) {
            map.putIfAbsent(ticket[0], new PriorityQueue<>());
            map.get(ticket[0]).offer(ticket[1]);
        }

        Set<String> visited = new HashSet<>();
        for (String[] ticket : tickets) {
            dfs(result, map, visited, ticket[0]);
        }

        Collections.reverse(result);
        return result;

    }

    private void dfs(List<String> result,
                     Map<String, PriorityQueue<String>> map, Set<String> visited,
                     String cur) {

        if (visited.contains(cur)) {
            return;
        }

        visited.add(cur);
        PriorityQueue<String> pq = map.get(cur);

        while (pq != null && !pq.isEmpty()) {
            dfs(result, map, visited, pq.poll());
        }

        result.add(cur);
    }

    public static void main(String[] args) {

        ReconstructItinerary solution = new ReconstructItinerary();

        String[][] t1 = { { "MUC", "LHR" }, { "JFK", "MUC" }, { "SFO", "SJC" },
                { "LHR", "SFO" } };
        String[][] t2 = { { "JFK", "SFO" }, { "JFK", "ATL" }, { "SFO", "ATL" },
                { "ATL", "JFK" }, { "ATL", "SFO" } };
        String[][] t3 = { { "LA", "SEATTLE" }, { "SEATTLE", "SAN FRAN" },
                { "SAN FRAN", "PITTS" } };

        System.out.println(solution.findItinerary(t1));
        System.out.println(solution.findItinerary(t2));
        System.out.println(solution.findItinerary(t3));

        System.out.println(solution.constructItinerary(t1));
        System.out.println(solution.constructItinerary(t3));

    }
}
