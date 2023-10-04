package mod03.arraysAndString.ex14;

public class maxConsecutiveOnes {
    public static void main(String[] args) {
        int[] nums = new int[] {1,1,0,1,0,1};
        System.out.println(findMaxConsecutiveOnes(nums));
    }
    public static int findMaxConsecutiveOnes(int[] nums) {
        int maxSum = 0;
        int runningCount = 0;

        for (int num : nums) {
            if (num == 0) {
                maxSum = Math.max(maxSum, runningCount);
                runningCount = 0;
            } else {
                runningCount++;
            }
        }

        return Math.max(maxSum, runningCount);
    }
}
