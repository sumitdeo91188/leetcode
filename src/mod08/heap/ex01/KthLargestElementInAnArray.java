package mod08.heap.ex01;

import java.util.Collections;
import java.util.PriorityQueue;

public class KthLargestElementInAnArray {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

        for (int num : nums) {
            queue.offer(num);
        }

        int largestNum = 0;
        for (int i = 0; i < k; i++) {
            largestNum = queue.poll();
        }

        return largestNum;

        //better solution
        /*PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int num: nums) {
            heap.add(num);
            if (heap.size() > k) {
                heap.remove();
            }
        }

        return heap.peek();*/
    }
}
