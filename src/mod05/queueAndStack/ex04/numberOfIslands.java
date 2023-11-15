package mod05.queueAndStack.ex04;

import java.util.LinkedList;
import java.util.Queue;

public class numberOfIslands {
    int[][] DIRECTIONS = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    int numRows;
    int numCols;
    public int numIslands(char[][] grid) {
        numRows = grid.length;
        numCols = grid[0].length;
        int numOfIsland = 0;
        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                if (grid[row][col] == '1') {
                    numOfIsland++;
                    grid[row][col] = '0';
                    Queue<Integer> neighbours = new LinkedList<>();
                    neighbours.add(row * numCols + col); // converting to 1D
                    while (!neighbours.isEmpty()) {
                        int neighbour = neighbours.poll();
                        // reconverting to 2D
                        int neighbourRow = neighbour / numCols;
                        int neighbourCol = neighbour % numCols;
                        for (int[] direction : DIRECTIONS) {
                            int nextNeighbourRow = neighbourRow + direction[0];
                            int nextNeighbourCol = neighbourCol + direction[1];
                            if (nextNeighbourRow < 0 || nextNeighbourRow >= numRows || nextNeighbourCol < 0 || nextNeighbourCol >= numCols || grid[nextNeighbourRow][nextNeighbourCol] == '0') {
                                continue;
                            }
                            grid[nextNeighbourRow][nextNeighbourCol] = '0';
                            neighbours.add(nextNeighbourRow * numCols + nextNeighbourCol);
                        }
                    }
                }
            }
        }
        return numOfIsland;
    }
}
