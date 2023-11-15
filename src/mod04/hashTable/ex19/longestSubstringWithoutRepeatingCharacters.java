package mod04.hashTable.ex19;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class longestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("bbbbb"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));
        System.out.println(lengthOfLongestSubstring("dvdf"));
        System.out.println(lengthOfLongestSubstring("abba"));
        System.out.println(lengthOfLongestSubstring(" "));
    }

    public static int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int start = 0;
        int len = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (map.containsKey(ch)) {
                if (map.get(ch) >= start) {
                    start = map.get(ch) + 1;
                }
            }
            map.put(ch, i);
            len = Math.max(len, i - start + 1);
        }

        return len;
    }
}
