package mod03.arraysAndString.ex17;

import java.util.ArrayList;
import java.util.List;

public class pascalsTriangle {
    public static void main(String[] args) {
        getRow(5);
    }

    public static List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<>(rowIndex + 1);
        row.add(1);

        for (int i = 0; i < rowIndex; i++) {
            for (int j = i; j > 0; j--) {
                row.set(j, row.get(j) + row.get(j - 1));
            }
            row.add(1);
        }

        return row;
    }
}
