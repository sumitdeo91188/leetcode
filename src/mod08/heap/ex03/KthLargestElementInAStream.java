package mod08.heap.ex03;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Queue;

public class KthLargestElementInAStream {
    private static int k;
    private PriorityQueue<Integer> heap;

    public KthLargestElementInAStream(int k, int[] nums) {
        this.k = k;
        heap = new PriorityQueue<>();

        for (int num: nums) {
            heap.offer(num);
        }

        while (heap.size() > k) {
            heap.poll();
        }
    }

    public int add(int val) {
        heap.offer(val);
        if (heap.size() > k) {
            heap.poll();
        }

        return heap.peek();
    }
}
