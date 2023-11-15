package mod05.queueAndStack.ex12;

public class targetSum {
    int[] nums;
    int target;

    public int findTargetSumWays(int[] nums, int target) {
        this.nums = nums;
        this.target = target;
        return dfs(0, 0);
    }

    private int dfs(int index, int sum) {
        if (index == nums.length) {
            if (sum == target) {
                return 1;
            } else {
                return 0;
            }
        }

        int addSum = dfs(index + 1, sum + nums[index]);
        int subSum = dfs(index + 1, sum - nums[index]);

        return addSum + subSum;
    }
}
