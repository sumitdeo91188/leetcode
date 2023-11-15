package mod04.hashTable.ex15;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class groupShiftedStrings {
    public static void main(String[] args) {
        groupStrings(new String[]{"abc","bcd","acef","xyz","az","ba","a","z"});
    }

    public static List<List<String>> groupStrings(String[] strs) {
        HashMap<String, List<String>> groups = new HashMap<>();
        for (String str : strs) {
            StringBuilder sb = new StringBuilder();
            if (str.length() > 1) {
                char[] chars = str.toCharArray();
                for (int i = 1; i < chars.length; i++) {
                    sb.append('#');
                    sb.append((chars[i] - chars[i-1] - 'a') % 26);
                }
            } else {
                sb.append('#');
            }

            if (! groups.containsKey(sb.toString())) {
                groups.put(sb.toString(), new ArrayList<>());
            }
            groups.get(sb.toString()).add(str);
        }

        return new ArrayList<>(groups.values());
    }
}
