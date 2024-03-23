package mod08.heap.ex09;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MinimumCostToConnectSticks {
    public int connectSticks(int[] sticks) {
        int cost = 0;

        if (sticks.length >= 1) {
            PriorityQueue<Integer> heap = new PriorityQueue<>();

            for (int stick  :sticks){
                heap.offer(stick);
            }

            while (heap.size() >= 2) {
                int firstStick = heap.poll();
                int secondStick = heap.poll();

                cost += firstStick + secondStick;

                if (heap.isEmpty())
                    break;
                else {
                    heap.offer(firstStick + secondStick);
                }
            }
        }

        return cost;
    }
}
