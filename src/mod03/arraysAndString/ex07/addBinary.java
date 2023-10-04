package mod03.arraysAndString.ex07;

import java.math.BigInteger;

public class addBinary {
    public static void main(String[] args) {
        System.out.println(addBinary("1010", "1011"));
    }

    /*public static String addBinary(String a, String b) {
        char[] aChar = a.toCharArray();
        char[] bChar = b.toCharArray();

        int aCharLen = aChar.length;
        int bCharLen = bChar.length;

        if (aCharLen < bCharLen) addBinary(b, a);

        StringBuilder sb = new StringBuilder();
        int carry = 0;
        int j = bCharLen - 1;
        for (int i = aCharLen - 1; i > -1; i--) {
            if (aChar[i] == '1') carry++;
            if (j > -1 && bChar[j] == '1') carry++;
            j--;
            if (carry % 2 == 1) sb.append('1');
            else sb.append('0');

            carry = carry / 2;
        }
        if (carry == 1) sb.append('1');
        return sb.toString();
    }*/

    public static String addBinary(String a, String b) {
        BigInteger x = new BigInteger(a, 2);
        BigInteger y = new BigInteger(b, 2);
        BigInteger zero = new BigInteger("0", 2);
        BigInteger carry, answer;

        while (y.compareTo(zero) != 0) {
            answer = x.xor(y);
            carry = x.and(y).shiftLeft(1);
            x = answer;
            y = carry;
        }
        return x.toString(2);
    }
}
