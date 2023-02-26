package mod01.arrays101.ex11;

public class replaceElementsWithGreatestElementOnRightSide {
    public static void main(String[] args) {
        int[] nums1 = new int[]{17,18,5,4,6,1};
        int[] nums2 = new int[]{400};

        nums1 = replaceElements(nums1);
        for (int num : nums1) {
            System.out.print(num + "\t");
        }
        System.out.println();

        nums2 = replaceElements(nums2);
        for (int num : nums2) {
            System.out.print(num + "\t");
        }
        System.out.println();
    }

    public static int[] replaceElements(int[] arr) {
        if (arr == null || arr.length == 0) {
            return arr;
        } else if (arr.length == 1) {
            arr[0] = -1;
            return arr;
        } else if (arr.length == 2) {
            arr[0] = arr[1];
            arr[1] = -1;
            return arr;
        } else {
            int greatestElem = arr[arr.length - 1];
            arr[arr.length - 1] = -1;

            for (int i = arr.length - 2; i >= 0; i--) {
                int temp = arr[i];
                arr[i] = greatestElem;
                greatestElem = Math.max(greatestElem, temp);
            }
            return arr;
        }
    }
}
