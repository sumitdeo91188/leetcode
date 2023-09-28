package mod01.arrays101.ex09;

public class validMountainArray {
    public static void main(String[] args) {
        int[] nums1 = new int[]{2, 1};
        int[] nums2 = new int[]{3, 5, 5};
        int[] nums3 = new int[]{0, 3, 2, 1};
        int[] nums4 = new int[]{3,7,20,14,15,14,10,8,2,1};
        System.out.println(validMountainArray(nums1));
        System.out.println(validMountainArray(nums2));
        System.out.println(validMountainArray(nums3));
        System.out.println(validMountainArray(nums4));
    }

    public static boolean validMountainArray(int[] arr) {
        /*if (arr == null || arr.length < 3) {
            return false;
        } else if (arr[0] >= arr[1]) {
            return false;
        } else if (arr[arr.length - 1] >= arr[arr.length - 2]) {
            return false;
        } else {
            boolean foundPeak = false;
            for (int i = 1; i < arr.length - 1; i++) {
                if (!foundPeak) {
                    if (arr[i - 1] == arr[i]) {
                        return false;
                    } else if (arr[i - 1] > arr[i]) {
                        foundPeak = true;
                        i--;
                    }
                } else {
                    if (arr[i] <= arr[i + 1]) {
                        return false;
                    }
                }
            }
        }
        return true;*/

        int len = arr.length;
        int index = 0;

        while (index < len -1 && arr[index] < arr[index + 1]) {
            index++;
        }

        if (index == 0 || index == len - 1) {
            return false;
        }

        while (index < len -1 && arr[index] > arr[index + 1]) {
            index++;
        }

        return index == len - 1;
    }
}
