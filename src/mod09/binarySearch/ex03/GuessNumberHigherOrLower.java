package mod09.binarySearch.ex03;

public class GuessNumberHigherOrLower {
    public int guessNumber(int n) {
        int left = 1;
        int right = n;

        while (left <= right) {
            int pivot = left + (right - left) / 2;
            int guess = guess(pivot);

            if (guess == -1) {
                right = pivot - 1;
            } else if (guess == 1) {
                left = pivot + 1;
            } else {
                return pivot;
            }
        }

        return right;
    }

    private int guess(int pivot) {
        return 0;
    }
}
