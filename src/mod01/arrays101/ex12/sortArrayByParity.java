package mod01.arrays101.ex12;

public class sortArrayByParity {
    public static void main(String[] args) {
        int[] nums1 = new int[]{3,1,2,4};
        int[] nums2 = new int[]{0};

        nums1 = sortArrayByParity(nums1);
        for (int num : nums1) {
            System.out.print(num + "\t");
        }
        System.out.println();

        nums2 = sortArrayByParity(nums2);
        for (int num : nums2) {
            System.out.print(num + "\t");
        }
        System.out.println();
    }

    public static int[] sortArrayByParity(int[] nums) {
        int leftIndex = 0;
        int rightIndex = nums.length - 1;

        while (leftIndex < rightIndex) {
            if (nums[leftIndex] % 2 > nums[rightIndex] % 2) {
                int temp = nums[rightIndex];
                nums[rightIndex] = nums[leftIndex];
                nums[leftIndex] = temp;
            }

            if (nums[leftIndex] % 2 == 0)
                leftIndex++;
            if (nums[rightIndex] % 2 == 1)
                rightIndex--;
        }

        return nums;
    }
}
