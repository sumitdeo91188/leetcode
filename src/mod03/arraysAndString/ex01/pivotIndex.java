package mod03.arraysAndString.ex01;

public class pivotIndex {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 7, 3, 6, 5, 6};
        System.out.println(findPivotIndex(nums));

        nums = new int[]{1, 0, 1, 1, 0, 1};
        System.out.println(findPivotIndex(nums));
    }

    public static int findPivotIndex(int[] nums) {
        int sum = 0;
        int leftSum = 0;

        for (int num : nums) {
            sum += num;
        }

        for (int i = 0; i < nums.length; i++) {
            if (leftSum == sum - leftSum - nums[i]) return i;
            leftSum += nums[i];
        }

        return -1;
    }
}
