package mod04.hashTable.ex07;

import java.util.HashMap;

public class twoSum {
    public static void main(String[] args) {
        int[] nums = twoSum(new int[]{3,2,4}, 6);
        for (int num : nums) {
            System.out.println(num);
        }
    }
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[] {i, map.get(complement)};
            }
        }

        return null;
    }
}
