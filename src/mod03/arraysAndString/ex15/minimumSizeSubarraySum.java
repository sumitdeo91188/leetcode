package mod03.arraysAndString.ex15;

public class minimumSizeSubarraySum {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 1, 2, 4, 1, 3};
        System.out.println(minSubArrayLen(7, nums));
    }

    public static int minSubArrayLen(int target, int[] nums) {
        int sum = 0;
        int answer = Integer.MAX_VALUE;
        int left = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            while (sum >= target) {
                answer = Math.min(answer, i + 1 - left);
                sum -= nums[left++];
            }
        }

        return answer == Integer.MAX_VALUE ? 0 : answer;
    }
}
