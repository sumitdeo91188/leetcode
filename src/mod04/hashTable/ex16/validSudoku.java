package mod04.hashTable.ex16;

import java.util.HashSet;

public class validSudoku {
    public static void main(String[] args) {}

    public boolean isValidSudoku(char[][] board) {
        HashSet<Character>[] rows = new HashSet[9];
        HashSet<Character>[] cols = new HashSet[9];
        HashSet<Character>[] boxes = new HashSet[9];

        for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }

        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                char ch = board[row][col];

                if (ch == '.') {
                    continue;
                }

                if (rows[row].contains(ch)) {
                    return false;
                } else {
                    rows[row].add(ch);
                }

                if (cols[col].contains(ch)) {
                    return false;
                } else {
                    cols[col].add(ch);
                }

                int index = 3 * (row / 3) + (col / 3);
                if (boxes[index].contains(ch)) {
                    return false;
                } else {
                    boxes[index].add(ch);
                }
            }
        }
        return true;
    }
}
