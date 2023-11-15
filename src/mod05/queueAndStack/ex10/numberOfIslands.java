package mod05.queueAndStack.ex10;

import java.util.Stack;

public class numberOfIslands {

    char[][] grid;
    int rows, columns;

    public int numIslands(char[][] grid) {
        int numOfIslands = 0;
        this.grid = grid;
        rows = grid.length;
        columns = grid[0].length;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < columns; col++) {
                if (grid[row][col] == '1') {
                    numOfIslands++;
                    dfs(row, col);
                }
            }
        }
        return numOfIslands;
    }

    private void dfs(int row, int col) {
        if (row >= rows || row < 0 || col >= columns || col < 0 || grid[row][col] == '0')
            return;
        grid[row][col] = '0';
        dfs(row - 1, col);
        dfs(row + 1, col);
        dfs(row, col - 1);
        dfs(row, col + 1);
    }
}
