package mod04.hashTable.ex04;

import java.util.HashMap;
import java.util.Map;

public class singleNumber {
    public static void main(String[] args) {
        System.out.println(singleNumber(new int[]{4,1,2,1,2}));
    }

    public static int singleNumber(int[] nums) {
        /*HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return 0;*/

        int a = 0;
        for (int num : nums) {
            a ^= num;
        }
        return a;
    }
}
