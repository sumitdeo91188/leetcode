package mod08.heap.ex10;

import java.util.PriorityQueue;

public class FurthestBuildingYouCanReach {
    public static void main(String[] args) {
        furthestBuilding(new int[]{1, 4, 8, 8}, 3, 1);
    }
    public static int furthestBuilding(int[] heights, int bricks, int ladders) {
        int dist = 0;
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        int bricksUsed = 0;

        for (int i = 1; i < heights.length; i++) {
            int jump = heights[i] - heights[i - 1];
            if (jump > 0) {
                heap.offer(jump);

                while (heap.size() > ladders) {
                    bricksUsed += heap.poll();
                }

                if (bricksUsed <= bricks) {
                    dist = i;
                } else {
                    return i - 1;
                }
            } else {
                dist++;
            }
        }

        return dist;
    }
}
