package mod09.binarySearch.ex02;

public class Sqrt {

    /*public int mySqrt(int x) {
        if (x < 2) return x;

        long num;
        int pivot, left = 2, right = x / 2;

        while (left <= right) {
            pivot = left + (right - left) / 2;
            num = (long)pivot * pivot;
            if (num > x) right = pivot - 1;
            else if (num < x) left = pivot + 1;
            else return pivot;
        }
        return right;
    }*/

    public int mySqrt(int x) {
        if (x < 2) return x;

        long num;
        int pivot, left = 2, right = x / 2 + 1;
        /*
        * Easy one. First we need to search for minimal k satisfying condition k^2 > x, then k - 1 is the answer to the question.
        * We can easily come up with the solution.
        * */
        while (left < right) {
            pivot = left + (right - left) / 2;
            num = (long)pivot * pivot;
            if (num > x) right = pivot;
            else left = pivot + 1;
        }

        return left - 1;
    }
}
