package mod01.arrays101.ex14;

public class heightChecker {
    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 1, 4, 2, 1, 3};
        int[] nums2 = new int[]{5, 1, 2, 3, 4};
        int[] nums3 = new int[]{1, 2, 3, 4, 5};
        int[] nums4 = new int[]{2, 1, 2, 1, 1, 2, 2, 1};

        System.out.println(heightChecker(nums1));
        System.out.println(heightChecker(nums2));
        System.out.println(heightChecker(nums3));
        System.out.println(heightChecker(nums4));
    }

    public static int heightChecker(int[] heights) {
        int[] buckets = new int[101];

        for (int height : heights) {
            buckets[height]++;
        }

        int count = 0;
        int index = 0;

        for (int i = 1; i < buckets.length; i++) {
            while (buckets[i] > 0) {
                if (i != heights[index++]) {
                    count++;
                }
                buckets[i]--;
            }
        }
        return count;
    }
}
