package facebook.hard;

// https://leetcode.com/problems/alien-dictionary/
// 269

import java.util.*;

/**
 * Created by Han on 10/27/16.
 */
public class AlienDictionary {

    // topological sort using BFS
    // 1. build up graph
    // 2. count in degree
    // 3. maintain a queue of store 0 in degree node
    // 4. descend its next nodes
    public String alienOrder(String[] words) {
        if (words == null || words.length == 0) {
            return "";
        }
        Map<Character, Integer> inDegree = new HashMap<>();
        Map<Character, List<Character>> graph = new HashMap<>();
        boolean[] visited = new boolean[26];
        for (String word: words) {
            for (int i = 0; i < word.length(); i++) {
                inDegree.putIfAbsent(word.charAt(i), 0);
                graph.putIfAbsent(word.charAt(i), new ArrayList<>());
            }
        }
        String cur = words[0];
        for (String next: words) {
            int length = Math.min(cur.length(), next.length());
            boolean found = false;
            for (int i = 0; i < length; i++) {
                if (cur.charAt(i) != next.charAt(i)) {
                    graph.get(cur.charAt(i)).add(next.charAt(i));
                    inDegree.put(next.charAt(i), inDegree.getOrDefault(next.charAt(i), 0) + 1);
                    found = true;
                    break;
                }
            }
            if (!found && cur.length() > next.length()) {
                return "";
            }
            cur = next;
        }
        Queue<Character> queue = new LinkedList<>();
        for (char key: inDegree.keySet()) {
            if (inDegree.get(key) == 0) {
                queue.offer(key);
                visited[key - 'a'] = true;
            }
        }
        StringBuilder builder = new StringBuilder();
        while (!queue.isEmpty()) {
            char c = queue.poll();
            for (char next: graph.get(c)) {
                if (!visited[next - 'a']) {
                    inDegree.put(next, inDegree.get(next) - 1);
                    if (inDegree.get(next) == 0) {
                        queue.offer(next);
                        visited[next - 'a'] = true;
                    }
                }
            }
            builder.append(c);
        }
        if (builder.length() != graph.size()) {
            return "";
        }
        return builder.toString();
    }
}
