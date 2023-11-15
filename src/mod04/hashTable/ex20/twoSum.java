package mod04.hashTable.ex20;

import java.util.HashMap;
import java.util.Map;

class twoSum {
    HashMap<Integer, Integer> map;
    public twoSum() {
        map = new HashMap<>();
    }

    public void add(int number) {
        map.put(number, map.getOrDefault(number, 0) + 1);
    }

    public boolean find(int value) {
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int complement = value - entry.getKey();
            if (complement != entry.getKey()) {
                if (map.containsKey(complement)) {
                    return true;
                }
            } else {
                if (map.get(complement) > 1) {
                    return true;
                }
            }
        }
        return false;
    }
}
