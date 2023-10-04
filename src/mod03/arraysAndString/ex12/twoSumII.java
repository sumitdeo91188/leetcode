package mod03.arraysAndString.ex12;

import java.util.Arrays;

public class twoSumII {
    public static void main(String[] args) {
        int[] nums = new int[] {6,2,6,5,1,2};
        System.out.println(arrayPairSum(nums));
    }
    public static int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;

        for (int i = 0; i < nums.length - 1; i = i+ 2) {
            sum += nums[i];
        }

        return sum;
    }
}
