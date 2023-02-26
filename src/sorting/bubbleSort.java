package sorting;

public class bubbleSort {
    public static void main(String[] args) {
        int[] num = new int[] {5,2,3,1,9,6,8,4,7};
        sort(num);

        for (int i : num) {
            System.out.print(i + "\t");
        }

        System.out.println();
    }

    private static void sort(int[] nums) {
        for (int i = nums.length - 1; i > 0; i--) {
            for (int j = 0; j < i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j + 1];
                    nums[j + 1] = nums[j];
                    nums[j] = temp;
                }
            }
        }
    }
}
