package facebook.medium;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class WordLadder {

    // BFS solution
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        wordList.add(endWord);
        Map<String, Integer> weights = new HashMap<>();
        weights.put(beginWord, 1);
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        while (!queue.isEmpty()) {
            String cur = queue.poll();
            int weight = weights.get(cur);
            char[] list = cur.toCharArray();
            for (int i = 0; i < list.length; i++) {
                char temp = list[i];
                for (char c = 'a'; c <= 'z'; c++) {
                    list[i] = c;
                    String trans = new String(list);
                    if (trans.equals(endWord)) {
                        return weight + 1;
                    }
                    if (!weights.containsKey(trans) && wordList.contains(trans)) {
                        queue.offer(trans);
                        weights.put(trans, weight + 1);
                    }
                }
                list[i] = temp;
            }
        }
        return 0;
    }
}
