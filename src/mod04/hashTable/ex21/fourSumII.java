package mod04.hashTable.ex21;

import java.util.HashMap;
import java.util.Map;

class fourSumII {
    private int[][] lists;
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        /*int result = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int n1 : nums1) {
            for (int n2 : nums2) {
                map.put((n1 + n2), map.getOrDefault((n1 + n2), 0) + 1);
            }
        }

        for (int n3 : nums3) {
            for (int n4 : nums4) {
                result += map.getOrDefault(-(n3 + n4), 0);
            }
        }

        return result;*/

        int result = 0;
        lists = new int[][]{nums1, nums2, nums3, nums4};
        int k = lists.length;
        Map<Integer, Integer> leftMap = sumCount(0, k/2);
        Map<Integer, Integer> rightMap = sumCount(k/2, k);

        for (Map.Entry<Integer, Integer> entryL : leftMap.entrySet()) {
            result += entryL.getValue() * rightMap.getOrDefault(-entryL.getKey(), 0);
        }

        return result;
    }

    private Map<Integer, Integer> sumCount(int start, int end) {
        Map<Integer, Integer> cnt = new HashMap<>();
        cnt.put(0, 1);
        for (int i = start; i < end; i++) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int a : lists[i]) {
                for (int total : cnt.keySet()) {
                    map.put(total + a, map.getOrDefault(total + a, 0) + cnt.get(total));
                }
            }
            cnt = map;
        }

        return null;
    }
}
