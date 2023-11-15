package mod07.recursionI.ex08;

public class pow {
    public double myPow(double x, int n) {
        return myPow1(x, n);
    }

    private double myPow1(double x, long n) {
        if (n == 0) return 1;
        else if (n < 0) {
            return 1.0 / myPow1(x, -n);
        }

        if (n % 2 == 0) return myPow1(x * x, n / 2);
        else return x * myPow1(x * x, n / 2);
    }

    // Will result into stackoverflow
    /*public double myPow(double x, int n) {
        if (n == 0) return 1;
        else if (n < 0) {
            return 1/ myPow(x, n);
        } else {
            return x * myPow(x, n - 1);
        }
    }*/
}
