package mod03.arraysAndString.ex10;

public class reverseString {
    public static void main(String[] args) {
        char[] strs = new char[] {'h', 'e', 'l', 'l', 'o'};
        reverseString(strs);
        for (char ch : strs) {
            System.out.println(ch);
        }
    }

    public static void reverseString(char[] strs) {
        int i = 0;
        int j = strs.length - 1;

        while (i < j) {
            char temp = strs[i];
            strs[i] = strs[j];
            strs[j] = temp;
            i++;
            j--;
        }
    }
}
