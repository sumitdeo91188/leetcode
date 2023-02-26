package sorting;

public class insertionSort {
    public static void main(String[] args) {
        int[] num = new int[] {5,2,3,1,9,6,8,4,7};
        sort(num);

        for (int i : num) {
            System.out.print(i + "\t");
        }

        System.out.println();
    }

    private static void sort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int currentIndex = i;
            while (currentIndex > 0 && nums[currentIndex] < nums[currentIndex - 1]) {
                int temp = nums[currentIndex];
                nums[currentIndex] = nums[currentIndex - 1];
                nums[currentIndex - 1] = temp;
                currentIndex--;
            }
        }
    }
}
