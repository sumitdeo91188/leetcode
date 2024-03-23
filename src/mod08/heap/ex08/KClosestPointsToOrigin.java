package mod08.heap.ex08;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KClosestPointsToOrigin {

    public static void main(String[] args) {
        kClosest(new int[][]{{0, 1}, {1, 0}}, 2);
    }
    public static int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> heap = new PriorityQueue<>(Comparator.comparingDouble(i -> Math.sqrt((Math.pow(i[0], 2) + Math.pow(i[1], 2)))));

        for (int[] point : points) {
            heap.offer(point);
        }

        int size = Math.min(k, heap.size());
        int[][] result = new int[size][2];

        for (int i = 0; i < size; i++) {
            result[i] = heap.poll();
        }

        return result;
    }
}
