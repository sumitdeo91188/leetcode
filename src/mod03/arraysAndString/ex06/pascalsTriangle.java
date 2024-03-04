package mod03.arraysAndString.ex06;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class pascalsTriangle {
    public static void main(String[] args) {
        strStr("mississippi", "issip");
    }

    public static int strStr(String haystack, String needle) {
        if (haystack.length() < needle.length())
            return -1;

        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            int startIndex = i;
            for (int j = 0; j <= needle.length(); j++) {
                if (j == needle.length()) {
                    return startIndex;
                }
                if (haystack.charAt(i) == needle.charAt(j)) {
                    i++;
                } else {
                    i--;
                    break;
                }
            }
            i++;
        }

        return -1;
    }
}
