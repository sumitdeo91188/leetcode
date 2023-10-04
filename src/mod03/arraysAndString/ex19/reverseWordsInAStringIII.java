package mod03.arraysAndString.ex19;

public class reverseWordsInAStringIII {
    public static void main(String[] args) {
        System.out.println(reverseWords("Let's take LeetCode contest"));
    }

    public static String reverseWords(String s) {
        s = s.trim();
        StringBuilder sb = new StringBuilder();
        String[] strs = s.split(" +");
        for (String str : strs) {
            sb.append(reverseStr(str)).append(" ");
        }

        return sb.toString().trim();
    }

    private static String reverseStr(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            sb.append(str.charAt(i));
        }

        return sb.toString();
    }
}
