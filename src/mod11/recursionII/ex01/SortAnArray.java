package mod11.recursionII.ex01;

import java.util.Arrays;

public class SortAnArray {
    public static void main(String[] args) {
        sortArray(new int[]{5,1,1,2,0,0});
    }
    public static int[] sortArray(int[] nums) {
        if (nums.length <= 1) {
            return nums;
        }

        int pivot = nums.length / 2;
        int[] leftNums = sortArray(Arrays.copyOfRange(nums, 0, pivot));
        int[] rightNums = sortArray(Arrays.copyOfRange(nums, pivot, nums.length));

        return merge(leftNums, rightNums);
    }

    private static int[] merge(int[] leftNums, int[] rightNums) {
        int[] mergedNums = new int[leftNums.length + rightNums.length];

        int leftIndex = 0;
        int rightIndex = 0;
        int mergeIndex = 0;

        while (leftIndex < leftNums.length && rightIndex < rightNums.length) {
            if (leftNums[leftIndex] <= rightNums[rightIndex]) {
                mergedNums[mergeIndex++] = leftNums[leftIndex++];
            } else {
                mergedNums[mergeIndex++] = rightNums[rightIndex++];
            }
        }

        while (leftIndex < leftNums.length) {
            mergedNums[mergeIndex++] = leftNums[leftIndex++];
        }

        while (rightIndex < rightNums.length) {
            mergedNums[mergeIndex++] = rightNums[rightIndex++];
        }

        return mergedNums;
    }
}
