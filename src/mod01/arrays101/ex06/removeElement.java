package mod01.arrays101.ex06;

public class removeElement {
    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 2, 2, 3, 0, 4, 2};
        int val = removeElement(nums, 2);
        for (int i = 0; i < val; i++) {
            System.out.print(nums[i] + "\t");
        }

        System.out.println();
    }

    public static int removeElement(int[] nums, int val) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                count++;
            } else {
                nums[i - count] = nums[i];
            }
        }
        return nums.length - count;
    }
}
