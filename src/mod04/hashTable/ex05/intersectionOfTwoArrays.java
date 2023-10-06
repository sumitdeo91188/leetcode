package mod04.hashTable.ex05;

import java.util.HashSet;

public class intersectionOfTwoArrays {
    public static void main(String[] args) {
        int[] nums = intersection(new int[]{1,2,2,1}, new int[]{2,2});
        for (int num : nums) {
            System.out.println(num);
        }
    }

    public static int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums1) {
            set.add(num);
        }

        HashSet<Integer> resultSet = new HashSet<>();
        for (int num : nums2) {
            if (set.contains(num)) {
                resultSet.add(num);
            }
        }

        int[] result = new int[resultSet.size()];
        int index = 0;
        for (int num : resultSet) {
            result[index++] = num;
        }
        return result;
    }
}
