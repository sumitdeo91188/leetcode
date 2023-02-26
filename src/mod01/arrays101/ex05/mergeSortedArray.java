package mod01.arrays101.ex05;

public class mergeSortedArray {
    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2, 3, 0, 0, 0};
        int[] nums2 = new int[]{2, 5, 6};
        merge(nums1, 3, nums2, 3);
        for (int num : nums1) {
            System.out.print(num + "\t");
        }
        System.out.println();
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int mi = m - 1;
        int ni = n - 1;
        for (int i = m + n - 1; i >= 0 && mi >= 0 && ni >= 0; i--) {
            int temp;
            if (nums1[mi] > nums2[ni]) {
                temp = nums1[mi];
                mi--;
            }
            else {
                temp = nums2[ni];
                ni--;
            }
            nums1[i] = temp;
        }
        if (ni >= 0) {
            if (ni + 1 >= 0) System.arraycopy(nums2, 0, nums1, 0, ni + 1);
        }
    }
}
