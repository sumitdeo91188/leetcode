package mod09.binarySearch.ex11;

public class ValidPerfectSquare {
    public boolean isPerfectSquare(int num) {
        if (num == 1)
            return true;
        else if (num == 2) {
            return false;
        }

        int left = 2;
        int right = num / 2;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            long square = (long) mid * mid;

            if (square > num) {
                right = mid - 1;
            } else if (square < num) {
                left = mid + 1;
            } else {
                return true;
            }
        }

        return false;
    }
}
