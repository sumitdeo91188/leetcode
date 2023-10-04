package mod03.arraysAndString.ex16;

public class rotateArray {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5,6,7};
        rotate(nums, 8);

        for (int num : nums) {
            System.out.println(num);
        }
    }

    public static void rotate(int[] nums, int k) {
        int len = nums.length;
        k = k % len;

        int count = 0;
        int start = 0;

        while (count < len) {
            int current = start;
            int prev = nums[start];
            do {
                int nextIndex = (current + k) % len;
                int temp = nums[nextIndex];
                nums[nextIndex] = prev;
                prev = temp;
                current = nextIndex;
                count++;

            } while (current != start);
            start++;
        }

    }
}
