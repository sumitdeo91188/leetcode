package mod04.hashTable.ex09;

import java.util.*;

public class firstUniqueCharacterInAString {
    public static void main(String[] args) {
        System.out.println(firstUniqChar("leetcode"));
        System.out.println(firstUniqChar("loveleetcode"));
    }

    public static int firstUniqChar(String s) {
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            Character ch = s.charAt(i);
            if(map.containsKey(ch)) {
                map.put(ch, -1);
            } else {
                map.put(ch, i);
            }
        }

        int minIndex = s.length();
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() != -1 && entry.getValue() < minIndex) {
                minIndex = entry.getValue();
            }
        }

        return minIndex == s.length() ? -1 : minIndex;
    }
}
