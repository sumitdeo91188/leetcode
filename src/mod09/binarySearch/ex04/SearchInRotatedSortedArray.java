package mod09.binarySearch.ex04;

public class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        int firstNumIndex;

        // O(n) - can be done in a better way
        /*for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                firstNumIndex = i;
                break;
            }
        }*/

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[nums.length - 1]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        firstNumIndex = left;

        if (firstNumIndex == 0) {
            right = nums.length - 1;
        } else if (target >= nums[0] && target <= nums[firstNumIndex - 1]) {
            left = 0;
            right = firstNumIndex - 1;
        } else if (target >= nums[firstNumIndex] && target <= nums[nums.length - 1]){
            right = nums.length - 1;
        } else {
            return -1;
        }

        while (left <= right) {
            int pivot = left + (right - left) / 2;

            if (target > nums[pivot]) {
                left = pivot + 1;
            } else if (target < nums[pivot]) {
                right = pivot - 1;
            } else {
                return pivot;
            }
        }

        return -1;
    }
}
