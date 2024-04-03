package mod09.binarySearch.ex06;

public class FindPeakElement {
    /*public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            // is left neighbour greater?
            if (mid > 0 && nums[mid] < nums[mid - 1]) {
                right = mid - 1;
            }
            // is right neighbour greater?
            else if (mid < nums.length - 1 && nums[mid] < nums[mid + 1]) {
                left = mid + 1;
            }
            else {
                return mid;
            }
        }
        return -1;
    }*/

    public int findPeakElement(int[] nums) {
        if (nums.length == 1) {
            return 0;
        } else if (nums.length == 2) {
            return nums[0] > nums[1] ? 0 : 1;
        }

        int left = 0;
        int right = nums.length - 1;

        while (left + 1 < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid - 1] > nums[mid]) {
                right = mid;
            } else if (nums[mid + 1] > nums[mid]) {
                left = mid;
            } else {
                return mid;
            }
        }

        return left;
    }
}
