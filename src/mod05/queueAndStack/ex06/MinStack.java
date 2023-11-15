package mod05.queueAndStack.ex06;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MinStack {
    List<Integer> integers;
    List<Integer> minValues;

    public MinStack() {
        integers = new ArrayList<>();
        minValues = new ArrayList<>();
    }


    public void pop() {
        if (isEmpty()) {
            throw new RuntimeException("Empty stack.");
        }

        int ele = integers.get(integers.size() - 1);
        integers.remove(integers.size() - 1);

        if (ele == minValues.get(minValues.size() - 1)) {
            minValues.remove(minValues.size() - 1);
        }
    }

    public int getMin() {
        return minValues.get(minValues.size() - 1);
    }

    public int top() {
        if (isEmpty()) {
            throw new RuntimeException("Empty stack.");
        }
        return integers.get(integers.size() - 1);
    }


    public int size() {
        return integers.size();
    }


    public boolean isEmpty() {
        return integers.isEmpty();
    }


    public void push(int elem) {
        integers.add(elem);
        if (minValues.isEmpty() || minValues.get(minValues.size() - 1) >= elem) {
            minValues.add(elem);
        }
    }
}
