package facebook.medium;

// https://leetcode.com/problems/word-search/

// 79

public class WordSearch {

    // dfs at each position
    public boolean exist(char[][] board, String word) {
        if (word == null || word.isEmpty() || board == null || board.length == 0 || board[0].length == 0) {
            return false;
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, word, 0, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }
    public boolean dfs(char[][] board, String word, int index, int i, int j) {
        if (index == word.length()) {
            return true;
        }
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
            return false;
        }
        if (board[i][j] == '#' || board[i][j] != word.charAt(index)) {
            return false;
        }
        char temp = board[i][j];
        board[i][j] = '#';
        if (dfs(board, word, index + 1, i - 1, j)) {
            return true;
        }
        if (dfs(board, word, index + 1, i + 1, j)) {
            return true;
        }
        if (dfs(board, word, index + 1, i, j - 1)) {
            return true;
        }
        if (dfs(board, word, index + 1, i, j + 1)) {
            return true;
        }
        board[i][j] = temp;
        return false;
    }
}
