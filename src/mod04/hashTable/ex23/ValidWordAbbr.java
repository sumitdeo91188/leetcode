package mod04.hashTable.ex23;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

class ValidWordAbbr {

    HashMap<String, Set<String>> map;
    public ValidWordAbbr(String[] dictionary) {
        map = new HashMap<>();

        for (String str : dictionary) {
            String key = getAbbreviation(str);
            if (! map.containsKey(key)) {
                map.put(key, new HashSet<>());
            }
            map.get(key).add(str);
        }
    }

    private String getAbbreviation(String str) {
        String key = str;
        if (str.length() > 2) {
            key = String.valueOf(str.charAt(0));
            key += str.length() - 2;
            key += String.valueOf(str.charAt(str.length() - 1));
        }
        return key;
    }

    public boolean isUnique(String word) {
        String key = getAbbreviation(word);
        if (map.containsKey(key)) {
            if (map.get(key).contains(word)) {
                return map.get(key).size() == 1;
            }
            return false;
        }
        return true;
    }
}

/**
 * Your ValidWordAbbr object will be instantiated and called as such:
 * ValidWordAbbr obj = new ValidWordAbbr(dictionary);
 * boolean param_1 = obj.isUnique(word);
 */