package mod07.recursionI.ex07;

import java.util.HashMap;

public class climbingStairs {

    // DP
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    // Memoization
    /*HashMap<Integer, Integer> map = new HashMap<>();
    public int climbStairs(int n) {
        return climbStairs(0, n);
    }

    private int climbStairs(int i, int n) {
        if (i > n) return 0;
        else if (i == n) return 1;
        else {
            if (! map.containsKey(i)) {
                map.put(i, climbStairs(i + 1, n) + climbStairs(i + 2, n));
            }
            return map.get(i);
        }
    }*/

    // Fibonacci number
    /*public int climbStairs(int n) {
        if (n == 1) return 1;

        int first = 1;
        int second = 2;

        for (int i = 3; i <= n; i++) {
            int temp = second;
            second = first + second;
            first = temp;
        }
        return second;
    }*/
}
