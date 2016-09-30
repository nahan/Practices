package google;

public class WordSearch {
    public boolean exist(char[][] board, String word) {
        boolean[] visited = new boolean[board.length * board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (backtracking(board, word, visited, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }
    private boolean backtracking(char[][] board, String word, boolean[] visited, int m, int n, int index) {
        if (index == word.length()) {
            return true;
        }
        if (m < 0 || m >= board.length) {
            return false;
        }
        if (n < 0 || n >= board[0].length) {
            return false;
        }
        if (visited[m * board[0].length + n]) {
            return false;
        }
        if (board[m][n] != word.charAt(index)) {
            return false;
        }
        visited[m * board[0].length + n] = true;
        if (backtracking(board, word, visited, m + 1, n, index + 1)) {
            return true;
        }
        if (backtracking(board, word, visited, m - 1, n, index + 1)) {
            return true;
        }
        if (backtracking(board, word, visited, m, n + 1, index + 1)) {
            return true;
        }
        if (backtracking(board, word, visited, m, n - 1, index + 1)) {
            return true;
        }
        visited[m * board[0].length + n] = false;
        return false;
    }
}
