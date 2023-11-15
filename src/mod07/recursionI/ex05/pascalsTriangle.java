package mod07.recursionI.ex05;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class pascalsTriangle {
    HashMap<Position, Integer> hashMap = new HashMap<>();
    public static final class Position {
        private final int row;
        private final int col;

        public Position(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }

            Position position = (Position) o;

            if (row != position.row) {
                return false;
            }
            return col == position.col;
        }

        @Override
        public int hashCode() {
            int result = row;
            result = 31 * result + col;
            return result;
        }
    }

    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<>(rowIndex + 1);
        for (int i = 0; i <= rowIndex; i++) {
            result.add(getPascalVal(rowIndex, i));
        }
        return result;
    }

    private int getPascalVal(int i, int j) {
        Position key = new Position(i, j);
        if (i == 0 || j == 0 || i == j) {
            hashMap.put(key, 1);
            return 1;
        } else {
            if (hashMap.containsKey(key)) {
                return hashMap.get(key);
            } else {
                int val = getPascalVal(i - 1, j - 1) + getPascalVal(i - 1, j);
                hashMap.put(key, val);
                return val;
            }
        }
    }
}
