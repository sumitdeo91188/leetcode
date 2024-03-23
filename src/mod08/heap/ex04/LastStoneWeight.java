package mod08.heap.ex04;

import java.util.Collections;
import java.util.PriorityQueue;

public class LastStoneWeight {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (int stone : stones) {
            maxHeap.offer(stone);
        }

        while (maxHeap.size() > 1) {
            int max = maxHeap.poll();
            int secondMax = maxHeap.poll();

            if (max != secondMax)
                maxHeap.offer(max - secondMax);
        }

        return maxHeap.size() == 1 ? maxHeap.poll() : 0;
    }
}
