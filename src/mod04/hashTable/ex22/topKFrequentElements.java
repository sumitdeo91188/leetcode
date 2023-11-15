package mod04.hashTable.ex22;

import java.util.*;

class topKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        // O(1) time
        if (k == nums.length) {
            return nums;
        }

        // 1. build hash map : character and how often it appears
        // O(N) time
        Map<Integer, Integer> count = new HashMap();
        for (int n: nums) {
            count.put(n, count.getOrDefault(n, 0) + 1);
        }

        // init heap 'the less frequent element first'
        Queue<Integer> heap = new PriorityQueue<>(
                Comparator.comparingInt(count::get));

        // 2. keep k top frequent elements in the heap
        // O(N log k) < O(N log N) time
        for (int n: count.keySet()) {
            heap.add(n);
            if (heap.size() > k) heap.poll();
        }

        // 3. build an output array
        // O(k log k) time
        int[] top = new int[k];
        for(int i = k - 1; i >= 0; --i) {
            top[i] = heap.poll();
        }
        return top;
    }

    /*private HashMap<Integer, Integer> sortHashMap(HashMap<Integer, Integer> map) {
        List<Integer> mapKeys = new ArrayList<>(map.keySet());
        List<Integer> mapValues = new ArrayList<>(map.values());

        mapValues.sort(Collections.reverseOrder());

        HashMap<Integer, Integer> sortedMap = new LinkedHashMap<>();

        for (int val : mapValues) {
            Iterator<Integer> keyIt = mapKeys.iterator();

            while (keyIt.hasNext()) {
                int key = keyIt.next();
                int comp1 = map.get(key);

                if (comp1 == val) {
                    keyIt.remove();
                    sortedMap.put(key, val);
                    break;
                }
            }
        }

        return sortedMap;
    }*/
}
