package mod01.arrays101.ex12;

public class moveZeros {
    public static void main(String[] args) {
        int[] nums1 = new int[]{0,1,0,3,12};
        int[] nums2 = new int[]{0};

        moveZeroes(nums1);
        for (int num : nums1) {
            System.out.print(num + "\t");
        }
        System.out.println();

        moveZeroes(nums2);
        for (int num : nums2) {
            System.out.print(num + "\t");
        }
        System.out.println();
    }

    public static void moveZeroes(int[] arr) {
        /*if (arr != null && arr.length > 1) {
            int numOfZeros = 0;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == 0) {
                    numOfZeros++;
                } else {
                    arr[i - numOfZeros] = arr[i];
                }
            }

            for (int i = arr.length - numOfZeros; i < arr.length; i++) {
                arr[i] = 0;
            }
        }*/

        if (arr != null && arr.length > 1) {
            int nonZeroIndex = 0;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] != 0) {
                    arr[nonZeroIndex++] = arr[i];
                }
            }

            for (int i = nonZeroIndex; i < arr.length; i++) {
                arr[i] = 0;
            }
        }
    }
}
