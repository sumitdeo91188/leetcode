package mod01.arrays101.ex08;

import java.util.HashSet;

public class checkIfNAndItsDoubleExist {
    public static void main(String[] args) {
        int[] nums1 = new int[]{10, 2, 5, 3};
        int[] nums2 = new int[]{3, 1, 7, 11};
        System.out.println(checkIfExist(nums1));
        System.out.println(checkIfExist(nums2));
    }

    public static boolean checkIfExist(int[] arr) {
        //O(N2)
        /*for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] * 2 == arr[j] || arr[j] * 2 == arr[i]) {
                    return true;
                }
            }
        }
        return false;*/


        //O(N)
        HashSet<Integer> set = new HashSet<>();
        for (int num : arr) {
            if ((num % 2 == 0 && set.contains(num / 2)) || set.contains(num * 2)) {
                return true;
            }
            set.add(num);
        }
        return false;
    }
}
