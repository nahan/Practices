package facebook.point;

// https://leetcode.com/problems/sudoku-solver/
// 37

/**
 * Created by Han on 11/2/16.
 */
public class SudokuSolver {

    public void solveSudoku(char[][] board) {
        boolean[][] position = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.') {
                    position[i][j] = true;
                }
            }
        }
        solver(board, position, 0, 0);
    }
    private boolean solver(char[][] board, boolean[][] position, int i, int j) {
        if (j == board[0].length) {
            j = 0;
            if (++i == board.length) {
                return true;
            }
        }
        if (!position[i][j]) {
            return solver(board, position, i, j + 1);
        }
        for (char c = '1'; c <= '9'; c++) {
            if (available(board, i, j, c)) {
                position[i][j] = false;
                board[i][j] = c;
                if (solver(board, position, i, j + 1)) {
                    return true;
                }
                board[i][j] = '.';
                position[i][j] = true;
            }
        }
        return false;
    }
    private boolean available(char[][] board, int i, int j, char c) {
        for (int m = 0; m < board.length; m++) {
            if (board[m][j] == c) {
                return false;
            }
        }
        for (int n = 0; n < board[0].length; n++) {
            if (board[i][n] == c) {
                return false;
            }
        }
        for (int m = (i / 3) * 3; m < (i / 3) * 3 + 3; m++) {
            for (int n = (j / 3) * 3; n < (j / 3) * 3 + 3; n++) {
                if (m != i && n != j && board[m][n] == c) {
                    return false;
                }
            }
        }
        return true;
    }

}
