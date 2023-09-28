package mod01.arrays101.ex14;

public class maxConsecutiveOnesII {
    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 0, 1, 1, 0};
        int[] nums2 = new int[]{1, 0, 1, 1, 0, 1, 1};
        int[] nums3 = new int[]{1, 1, 0, 1};

        System.out.println(findMaxConsecutiveOnes(nums1));
        System.out.println(findMaxConsecutiveOnes(nums2));
        System.out.println(findMaxConsecutiveOnes(nums3));
    }

    public static int findMaxConsecutiveOnes(int[] nums) {
        // brute force
        /*int maxConsOnes = 0;

        for (int leftIndex = 0; leftIndex < nums.length; leftIndex++) {
            int runningCount = 0;
            for (int rightIndex = leftIndex; rightIndex < nums.length; rightIndex++) {
                // count how many 0's
                if (nums[rightIndex] == 0) {
                    runningCount += 1;
                }
                // # update answer if it's valid
                if (runningCount <= 1) {
                    maxConsOnes = Math.max(maxConsOnes, rightIndex - leftIndex + 1);
                }
            }
        }

        return maxConsOnes;*/

        /*int leftIndex = 0;
        int rightIndex = 0;
        int maxConsOnes = 0;
        int numZeros = 0;
        while (rightIndex < nums.length) {
            if (nums[rightIndex] == 0) {
                numZeros++;
            }

            while (numZeros == 2) {
                if (nums[leftIndex++] == 0)
                    numZeros--;
            }
            maxConsOnes = Math.max(maxConsOnes, rightIndex - leftIndex + 1);
            rightIndex++;
        }

        return maxConsOnes;*/

        //infinite stream
        int left = 0;
        int right = 0;

        int zeroIndex = -1;
        int longestSeq = 0;
        while (right < nums.length) {
            if (nums[right] == 0) {
                left = zeroIndex + 1;
                zeroIndex = right;
            }

            longestSeq = Math.max(longestSeq, right - left + 1);
            right++;
        }

        return longestSeq;
    }
}
