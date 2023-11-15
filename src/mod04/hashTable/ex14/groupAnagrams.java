package mod04.hashTable.ex14;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class groupAnagrams {
    public static void main(String[] args) {
        groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"});
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) {
            return new ArrayList<>();
        }

        HashMap<String, List<String>> anagrams = new HashMap<>();
        for (String str : strs) {
            int[] count = new int[26];
            for(char ch : str.toCharArray()) {
                count[ch - 'a']++;
            }

            StringBuilder sb = new StringBuilder();
            for (int i : count) {
                sb.append("#");
                sb.append(i);
            }

            if (! anagrams.containsKey(sb.toString())) {
                anagrams.put(sb.toString(), new ArrayList<>());
            }
            anagrams.get(sb.toString()).add(str);
        }

        return new ArrayList<>(anagrams.values());
    }
}
