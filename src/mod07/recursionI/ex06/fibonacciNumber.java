package mod07.recursionI.ex06;

import java.util.HashMap;

public class fibonacciNumber {
    HashMap<Integer, Integer> map = new HashMap<>();

    public int fib(int n) {
        if (n < 2) return n;
        else {
            if (! map.containsKey(n)) map.put(n, fib(n - 1) + fib(n - 2));
            return map.get(n);
        }
    }

    /*public int fib(int n) {
        if (n == 1) {
            return 1;
        }
        int first = 1;
        int second = 2;
        for (int i = 3; i <= n; i++) {
            int third = first + second;
            first = second;
            second = third;
        }
        return second;
    }*/
}
