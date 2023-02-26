package sorting;

public class selectionSort {
    public static void main(String[] args) {
        int[] num = new int[] {5,2,3,1,9,6,8,4,7};
        sort(num);

        for (int i : num) {
            System.out.print(i + "\t");
        }

        System.out.println();
    }

    private static void sort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int minIndex = i;
            for (int j = minIndex + 1; j < nums.length; j++) {
                if (nums[j] < nums[minIndex]) {
                    minIndex = j;
                }
            }

            int temp = nums[minIndex];
            nums[minIndex] = nums[i];
            nums[i] = temp;
        }
    }
}
