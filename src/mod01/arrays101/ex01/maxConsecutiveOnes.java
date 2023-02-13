package mod01.arrays101.ex01;

public class maxConsecutiveOnes {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 0, 0, 1, 1, 1};
        System.out.println(findMaxConsecutiveOnes(nums));

        nums = new int[]{1,0,1,1,0,1};
        System.out.println(findMaxConsecutiveOnes(nums));
    }

    public static int findMaxConsecutiveOnes(int[] nums) {
        int maxConsecutiveOnes = 0;
        int runningCount = 0;

        for (int num : nums) {
            if (num == 1) {
                runningCount++;
            } else {
                runningCount = 0;
            }
            maxConsecutiveOnes = Math.max(maxConsecutiveOnes, runningCount);
        }
        return maxConsecutiveOnes;
    }
}
