package mod05.queueAndStack.ex16;

import java.util.LinkedList;
import java.util.Queue;

public class Matrix01 {

    public static void main(String[] args) {
        int[][] newMat = updateMatrix(new int[][]{{0,0,0}, {0,1,0}, {1,1,1}});
    }
    static int[][] DIRECTIONS = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static int[][] updateMatrix(int[][] mat) {
        Queue<int[]> queue = new LinkedList<>();
        int m = mat.length;
        int n = mat[0].length;

        int MAX_VALUE = m * n;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] != 0) {
                    mat[i][j] = MAX_VALUE;
                } else {
                    queue.offer(new int[]{i, j});
                }
            }
        }

        while (! queue.isEmpty()) {
            int[] currentNode = queue.poll();
            for (int[] direction : DIRECTIONS) {
                int r = currentNode[0] + direction[0];
                int c = currentNode[1] + direction[1];

                if (r >= 0 && r < m && c >= 0 && c < n && mat[r][c] > mat[currentNode[0]][currentNode[1]] + 1) {
                    mat[r][c] = mat[currentNode[0]][currentNode[1]] + 1;
                    queue.offer(new int[]{r, c});
                }
            }
        }

        return mat;
    }
}
