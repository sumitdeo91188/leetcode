package mod01.arrays101.ex03;

public class squaresOfSortedArray {
    public static void main(String[] args) {
        int[] nums = new int[]{-4,-1,0,3,10};
        int[] result = sortedSquares(nums);
        for (int num : result) {
            System.out.print(num + "\t");
        }
    }

    public static int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int left = 0;
        int right = n - 1;

        for (int i = n - 1; i >= 0; i--) {
            int square;
            if (Math.abs(nums[left]) > Math.abs(nums[right])) {
                square = (int) Math.pow(nums[left++], 2);
            } else {
                square = (int) Math.pow(nums[right--], 2);
            }
            result[i] = square;
        }

        return result;
    }
}
