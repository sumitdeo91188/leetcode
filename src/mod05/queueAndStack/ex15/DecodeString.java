package mod05.queueAndStack.ex15;

import java.util.*;

public class DecodeString {
    public static void main(String[] args) {
        System.out.println(decodeString("100[abc]"));
    }
    public static String decodeString(String s) {
        Stack<Integer> countStack = new Stack<>();
        Stack<StringBuilder> sbStack = new Stack<>();
        StringBuilder currentSb = new StringBuilder();
        int k = 0;

        for (Character ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                k = k * 10 + ch - '0';
            } else if (Character.isAlphabetic(ch)) {
                currentSb.append(ch);
            } else if (ch == '[') {
                countStack.push(k);
                sbStack.push(currentSb);
                currentSb = new StringBuilder();
                k = 0;
            } else {
                StringBuilder decodedSb = sbStack.pop();
                int count = countStack.pop();

                while (count > 0) {
                    decodedSb.append(currentSb);
                    count--;
                }
                currentSb = decodedSb;
            }
        }

        return currentSb.toString();
    }
}
