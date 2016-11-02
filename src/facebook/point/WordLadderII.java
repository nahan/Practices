package facebook.point;

//	https://leetcode.com/problems/word-ladder/

//	https://leetcode.com/problems/word-ladder-ii/

import java.util.*;

/**
 * Created by Han on 11/2/16.
 */
public class WordLadderII {

    // 1.
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {

        wordList.add(endWord);

        Map<String, Integer> weights = new HashMap<>();
        weights.put(beginWord, 1);

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);

        while (!queue.isEmpty() && !queue.peek().equals(endWord)) {
            String cur = queue.poll();
            int weight = weights.get(cur);

            char[] array = cur.toCharArray();
            for (int i = 0; i < array.length; i++) {
                char temp = array[i];
                for (char c = 'a'; c <= 'z'; c++) {
                    array[i] = c;
                    String word = new String(array);
                    if (wordList.contains(word) && !weights.containsKey(word)) {
                        queue.offer(word);
                        weights.put(word, weight + 1);
                    }
                }
                array[i] = temp;
            }
        }

        return weights.getOrDefault(endWord, 0);
    }

    // 2.
    public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {

        List<List<String>> result = new ArrayList<>();

        wordList.add(endWord);

        Map<String, Integer> weights = new HashMap<>();
        weights.put(beginWord, 1);

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);

        Map<String, List<String>> neighbors = new HashMap<>();

        while (!queue.isEmpty()) {

            String cur = queue.poll();
            int weight = weights.get(cur);

            List<String> neighbor = new ArrayList<>();

            char[] array = cur.toCharArray();
            for (int i = 0; i < array.length; i++) {
                char temp = array[i];
                for (char c = 'a'; c <= 'z'; c++) {
                    array[i] = c;
                    String word = new String(array);
                    if (wordList.contains(word) && !weights.containsKey(word)) {
                        weights.put(word, weight + 1);
                        queue.offer(word);
                    }

                    if (!word.equals(cur) && wordList.contains(word)) {
                        neighbor.add(word);
                    }
                }
                array[i] = temp;
            }

            neighbors.put(cur, neighbor);
        }

        List<String> item = new ArrayList<>();
        dfs(result, item, weights, neighbors, beginWord, endWord);

        return result;
    }

    private void dfs(List<List<String>> result, List<String> item,
                     Map<String, Integer> weights, Map<String, List<String>> neighbors,
                     String cur, String end) {

        item.add(cur);

        if (cur.equals(end)) {
            result.add(new ArrayList<>(item));
        } else {
            for (String word : neighbors.get(cur)) {
                if (weights.get(cur) + 1 == weights.get(word)) {
                    dfs(result, item, weights, neighbors, word, end);
                }
            }
        }

        item.remove(item.size() - 1);
    }
}
