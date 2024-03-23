package mod08.heap.ex05;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TheKWeakestRowsInAMatrix {
    public int[] kWeakestRows(int[][] mat, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < mat.length; i++) {
            int count = 0;
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 1)
                    count++;
                else
                    break;
            }
            map.put(i, count);
        }

        // Create a priority queue
        PriorityQueue<Map.Entry<Integer, Integer>> priorityQueue = new PriorityQueue<>((entry1, entry2) -> {
            // Compare the values of the entries
            int valueComparison = entry1.getValue().compareTo(entry2.getValue());
            if (valueComparison != 0) {
                return valueComparison;
            }

            // If the values are equal, compare the keys of the entries
            return entry1.getKey().compareTo(entry2.getKey());
        });

        // Add the entries from the map to the priority queue
        priorityQueue.addAll(map.entrySet());

        int[] result = new int[k];

        for (int i = 0; i < k; i++) {
            result[i] = priorityQueue.poll().getKey();
        }

        return result;
    }
}
