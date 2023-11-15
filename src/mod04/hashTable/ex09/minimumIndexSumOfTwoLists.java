package mod04.hashTable.ex09;

import java.util.*;

public class minimumIndexSumOfTwoLists {

    public static void main(String[] args) {
        findRestaurant(new String[]{"Shogun","Tapioca Express","Burger King","KFC"},
                new String[]{"Piatti","The Grill at Torrey Pines","Hungry Hunter Steakhouse","Shogun"});
    }

    public static String[] findRestaurant(String[] list1, String[] list2) {
        HashMap<String, Integer> map1 = new HashMap<>();

        for (int i = 0; i < list1.length; i++) {
            map1.put(list1[i], i);
        }

        int lowestSum = Integer.MAX_VALUE;
        List<String> resultList = new ArrayList<>();
        for (int i = 0; i < list2.length; i++) {
            if (map1.containsKey(list2[i])) {
                int sum = i + map1.get(list2[i]);
                if (sum < lowestSum) {
                    resultList = new ArrayList<>();
                    resultList.add(list2[i]);
                    lowestSum = sum;
                } else if (sum == lowestSum) {
                    resultList.add(list2[i]);
                }
            }
        }

        String[] result = new String[resultList.size()];
        for (int i = 0; i < resultList.size(); i++) {
            result[i] = resultList.get(i);
        }
        return result;
    }
}
