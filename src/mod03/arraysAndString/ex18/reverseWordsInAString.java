package mod03.arraysAndString.ex18;

import java.util.ArrayList;
import java.util.List;

public class reverseWordsInAString {
    public static void main(String[] args) {
        System.out.println(reverseWords("the sky is blue"));
    }

    public static String reverseWords(String s) {
        s = s.trim();
        StringBuilder sb = new StringBuilder();
        String[] strs = s.split(" +");
        for (int i = strs.length - 1; i >= 0; i--) {
            sb.append(strs[i]).append(" ");
        }

        return sb.toString().trim();
    }
}
