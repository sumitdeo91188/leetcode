package mod04.hashTable.ex08;

public class isomorphicStrings {
    public static void main(String[] args) {
        System.out.println(isIsomorphic("egg", "add"));
        System.out.println(isIsomorphic("foo", "bar"));
    }

    public static boolean isIsomorphic(String s, String t) {
        int[] mapRight = new int[256];
        int[] mapLeft = new int[256];

        for (int i = 0; i < 256; i++) {
            mapRight[i] = -1;
            mapLeft[i] = -1;
        }

        for (int i = 0; i < s.length(); i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);

            if (mapRight[sChar] == -1 && mapLeft[tChar] == -1) {
                mapRight[sChar] = tChar;
                mapLeft[tChar] = sChar;
            } else if (! (mapRight[sChar] == tChar && mapLeft[tChar] == sChar)) {
                return false;
            }
        }

        return true;
    }
}
