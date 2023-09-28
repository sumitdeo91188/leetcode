package mod03.arraysAndString.ex06;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class pascalsTriangle {
    public static void main(String[] args) {
        generate(5);
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            if (i == 0) {
                result.add(List.of(1));
            } else if (i == 1) {
                result.add(List.of(1, 1));
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(1);

                for (int j = 0; j < i - 1; j++) {
                    list.add(result.get(i - 1).get(j) + result.get(i - 1).get(j + 1));
                }

                list.add(1);
                result.add(list);
            }
        }

        return result;
    }
}
