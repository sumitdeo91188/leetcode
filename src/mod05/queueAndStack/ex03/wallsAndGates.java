package mod05.queueAndStack.ex03;

import java.util.LinkedList;
import java.util.Queue;

public class wallsAndGates {
    int EMPTY = Integer.MAX_VALUE;
    int GATE = 0;

    int[][] DIRECTIONS = new int[][]{{1,0}, {-1,0}, {0,1}, {0,-1}};
    int rows;
    int columns;

    public void wallsAndGates(int[][] rooms) {
        if (rooms.length == 0) return;

        rows = rooms.length;
        columns = rooms[0].length;

        Queue<int[]> queue = new LinkedList<>();
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < columns; col++) {
                if (rooms[row][col] == GATE) {
                    queue.add(new int[]{row, col});
                }
            }
        }

        while (! queue.isEmpty()) {
            int[] room = queue.poll();
            int row = room[0];
            int col = room[1];

            for (int[] direction : DIRECTIONS) {
                int newRow = row + direction[0];
                int newCol = col + direction[1];

                if (newRow < 0 || newRow >= rows || newCol < 0 || newCol >= columns || rooms[newRow][newCol] != EMPTY) {
                    continue;
                }

                rooms[newRow][newCol] = rooms[row][col] + 1;
                queue.add(new int[]{newRow, newCol});
            }
        }

    }
}
