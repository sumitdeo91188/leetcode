package mod03.arraysAndString.ex02;

public class largestNumberAtLeastTwiceOfOthers {
    public static void main(String[] args) {
        int[] nums = new int[]{3, 6, 1, 0};
        System.out.println(dominantIndex(nums));

        nums = new int[]{1, 2, 3, 4};
        System.out.println(dominantIndex(nums));
    }

    public static int dominantIndex(int[] nums) {
        int maxNum = Integer.MIN_VALUE;
        int maxNumIndex = -1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > maxNum) {
                maxNum = nums[i];
                maxNumIndex = i;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (maxNumIndex == i) continue;
            if (maxNum < 2 * nums[i]) return -1;
        }

        return maxNumIndex;
    }
}
