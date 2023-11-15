package mod04.hashTable.ex18;

import java.util.HashSet;

public class jewelsAndStones {
    public static void main(String[] args) {
    }

    public int numJewelsInStones(String jewels, String stones) {
        HashSet<Character> jewelSet = new HashSet<>();
        for (Character ch : jewels.toCharArray()) {
            jewelSet.add(ch);
        }

        int count = 0;
        for (Character ch : stones.toCharArray()) {
            if (jewelSet.contains(ch)) {
                count++;
            }
        }

        return count;
    }
}
