package mod04.hashTable.ex06;

import java.util.HashSet;

public class happyNumber {
    public static void main(String[] args) {
        System.out.println(isHappy(2));
    }

    static HashSet<Integer> set = new HashSet<>();
    public static boolean isHappy(int n) {
        int sum = 0;
        while (n != 0) {
            sum += Math.pow(n % 10, 2);
            n = n / 10;
        }

        if (set.contains(sum)) {
            return false;
        } else if (sum == 1) {
            set = new HashSet<>();
            return true;
        }
        set.add(sum);
        return isHappy(sum);
    }
}
