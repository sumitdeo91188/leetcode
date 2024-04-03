package mod11.recursionII.ex05;

import java.util.HashSet;

public class SudokuSolver {
    public void solveSudoku(char[][] board) {
        // Initialize sets to keep track of numbers in rows, columns, and boxes
        HashSet<Integer>[] rows = new HashSet[9];
        HashSet<Integer>[] columns = new HashSet[9];
        HashSet<Integer>[] boxes = new HashSet[9];

        // Initialize sets for each row, column, and box
        for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet<>();
            columns[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }

        // Populate sets with existing numbers in the board
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int num = Character.getNumericValue(board[i][j]);
                    int boxIndex = i / 3 * 3 + j / 3;
                    rows[i].add(num);
                    columns[j].add(num);
                    boxes[boxIndex].add(num);
                }
            }
        }

        // Start backtracking algorithm to solve Sudoku
        boolean solved = backtrack(board, rows, columns, boxes, 0, 0);
        // Check if Sudoku is solved
        if (!solved) {
            System.out.println("No solution exists.");
        }
    }

    // Backtracking algorithm
    private boolean backtrack(char[][] board, HashSet<Integer>[] rows, HashSet<Integer>[] columns, HashSet<Integer>[] boxes, int i, int j) {
        // Base case: if we have reached the end of the board, Sudoku is solved
        if (i == 9) {
            return true;
        }

        // Calculate indices for next cell
        int new_i = i + (j + 1) / 9; // Calculate the row index of the next cell
        int new_j = (j + 1) % 9;     // Calculate the column index of the next cell

        // If current cell is not empty, move to the next cell
        if (board[i][j] != '.') {
            return backtrack(board, rows, columns, boxes, new_i, new_j);
        } else {
            // Try placing numbers 1 to 9 in the current empty cell
            for (int num = 1; num <= 9; num++) {
                int boxIndex = i / 3 * 3 + j / 3;
                // Check if the number is not present in current row, column, or box
                if (!rows[i].contains(num) && !columns[j].contains(num) && !boxes[boxIndex].contains(num)) {
                    // Add number to current row, column, and box
                    rows[i].add(num);
                    columns[j].add(num);
                    boxes[boxIndex].add(num);
                    board[i][j] = (char) (num + '0'); // Convert int to char and assign to board

                    // Recursively call backtrack for next cell
                    if (backtrack(board, rows, columns, boxes, new_i, new_j)) {
                        return true; // Found a solution
                    }

                    // If Sudoku is not solved, remove the number from current row, column, and box
                    rows[i].remove(num);
                    columns[j].remove(num);
                    boxes[boxIndex].remove(num);
                    board[i][j] = '.'; // Reset cell to empty
                }
            }
            return false; // No solution found for this cell
        }
    }
}
