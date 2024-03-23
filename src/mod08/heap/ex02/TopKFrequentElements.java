package mod08.heap.ex02;

import java.util.*;

public class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        Queue<Integer> queue = new PriorityQueue<>(Comparator.comparingInt(map::get));

        for (int num : map.keySet()) {
            queue.offer(num);
            if (queue.size() > k)
                queue.poll();
        }

        int[] result = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            result[i] = queue.poll();
        }

        return result;
    }
}
