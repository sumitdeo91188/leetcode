package mod03.arraysAndString.ex09;

public class longestCommonPrefix {
    public static void main(String[] args) {
        String[] strs = new String[] {"flower","flow","flight"};
        System.out.println(longestCommonPrefix(strs));
    }

    public static String longestCommonPrefix(String[] strs) {
        StringBuilder sb = new StringBuilder();
        int index = 0;
        boolean flag = true;
        while (true) {
            char currentChar = strs[0].charAt(index);
            for (int i = 1; i < strs.length; i++) {
                if (strs[i].charAt(index) != currentChar) {
                    flag = false;
                    break;
                }
            }
            if (! flag) break;
            sb.append(currentChar);
            index++;
        }

        return sb.toString();
    }
}
