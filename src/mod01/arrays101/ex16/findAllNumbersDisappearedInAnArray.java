package mod01.arrays101.ex16;

import java.util.ArrayList;
import java.util.List;

public class findAllNumbersDisappearedInAnArray {
    public static void main(String[] args) {
        int[] nums1 = new int[]{4, 3, 2, 7, 8, 2, 3, 1};
        int[] nums2 = new int[]{1, 1};

        List<Integer> result = findDisappearedNumbers(nums1);
        for (int i : result) {
            System.out.print(i + "\t");
        }
        System.out.println();

        result = findDisappearedNumbers(nums2);

        for (int i : result) {
            System.out.print(i + "\t");
        }
        System.out.println();
    }

    public static List<Integer> findDisappearedNumbers(int[] nums) {
        /*HashSet<Integer> uniqueNums = new HashSet<>();
        for (int num : nums) {
            uniqueNums.add(num);
        }

        List<Integer> disappearedNumbers = new ArrayList<>();
        for (int i = 1; i <= nums.length; i++) {
            if (! uniqueNums.contains(i)) {
                disappearedNumbers.add(i);
            }
        }

        return disappearedNumbers;*/

        for (int i = 0; i < nums.length; i++) {
            if (nums[Math.abs(nums[i]) - 1] > 0) {
                nums[Math.abs(nums[i]) - 1] = -1 * nums[Math.abs(nums[i]) - 1];
            }
        }

        List<Integer> disappearedNumbers = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                disappearedNumbers.add(i + 1);
            }
        }

        return disappearedNumbers;
    }
}
