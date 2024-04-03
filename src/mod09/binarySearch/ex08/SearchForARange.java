package mod09.binarySearch.ex08;

public class SearchForARange {
    int[] nums;
    int target;

    public int[] searchRange(int[] nums, int target) {
        this.nums = nums;
        this.target = target;

        int firstIndex = getTargetIndex(true);
        if (firstIndex == -1) {
            return new int[]{-1, -1};
        }
        int lastIndex = getTargetIndex(false);
        return new int[]{firstIndex, lastIndex};
    }

    private int getTargetIndex(boolean searchFirstIndex) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                if (searchFirstIndex) {
                    if (mid == left || nums[mid - 1] != target) {
                        return mid;
                    } else {
                        right = mid - 1;
                    }
                } else {
                    if (mid == nums.length - 1 || nums[mid + 1] != target) {
                        return mid;
                    } else {
                        left = mid + 1;
                    }
                }
            } else if (nums[mid] > target){
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
