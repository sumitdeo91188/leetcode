package mod03.arraysAndString.ex08;

import java.math.BigInteger;

public class implementStrStr {
    public static void main(String[] args) {
        System.out.println(strStr("sadbutsad", "sad"));
        System.out.println(strStr("leetcode", "leeto"));
    }

    public static int strStr(String haystack, String needle) {
        int m = haystack.length();
        int n = needle.length();

        for (int windowStart = 0; windowStart < m - n; windowStart++) {
            for (int i = 0; i < n; i++) {
                if (needle.charAt(i) != haystack.charAt(windowStart + i)) {
                    break;
                }

                if (i == n - 1) {
                    return windowStart;
                }
            }
        }
        return -1;
    }
}
