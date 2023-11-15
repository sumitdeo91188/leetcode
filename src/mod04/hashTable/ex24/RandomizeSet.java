package mod04.hashTable.ex24;

import java.util.*;

class RandomizedSet {

    HashMap<Integer, Integer> map;
    List<Integer> list;
    Random random;
    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
        random = new Random();
    }

    public boolean insert(int val) {
        if (! map.containsKey(val)) {
            map.put(val, list.size());
            list.add(list.size(), val);
            return true;
        }
        return false;
    }

    public boolean remove(int val) {
        if (map.containsKey(val)) {
            int lastEle = list.get(list.size() - 1);
            int index = map.get(val);
            map.put(lastEle, index);
            list.set(index, lastEle);
            map.remove(val);
            list.remove(list.size() - 1);
            return true;
        } return false;
    }

    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */