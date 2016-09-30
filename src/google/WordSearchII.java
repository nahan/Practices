package google;

import java.util.ArrayList;
import java.util.List;

public class WordSearchII {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();
        if (board == null || board.length == 0 || board[0].length == 0 || words == null || words.length == 0) {
            return result;
        }
        Trie root = buildTrie(words);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, i, j, root, result);
            }
        }
        return result;
    }
    private void dfs(char[][] board, int i, int j, Trie node, List<String> result) {
        char c = board[i][j];
        if (c == '#' || node.children[c - 'a'] == null) {
            return;
        }
        node = node.children[c - 'a'];
        if (node.word != null) {
            result.add(node.word);
            node.word = null;
        }
        board[i][j] = '#';
        if (i > 0) {
            dfs(board, i - 1, j, node, result);
        }
        if (i < board.length - 1) {
            dfs(board, i + 1, j, node, result);
        }
        if (j > 0) {
            dfs(board, i, j - 1, node, result);
        }
        if (j < board[0].length - 1) {
            dfs(board, i, j + 1, node, result);
        }
        board[i][j] = c;
    }
    private Trie buildTrie(String[] words) {
        Trie root = new Trie();
        for (String word: words) {
            Trie node = root;
            for (char c: word.toCharArray()) {
                if (node.children[c - 'a'] == null) {
                    node.children[c - 'a'] = new Trie();
                }
                node = node.children[c - 'a'];
            }
            node.word = word;
        }
        return root;
    }
}

class Trie {
    String word;
    Trie[] children = new Trie[26];
}
