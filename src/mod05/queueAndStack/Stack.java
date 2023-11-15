package mod05.queueAndStack;

import java.util.ArrayList;
import java.util.List;

public class Stack {
    List<Integer> integers;

    public Stack() {
        integers = new ArrayList<>();
    }

    
    public Integer pop() {
        if (isEmpty()) {
            throw new RuntimeException("Empty stack.");
        }

        int ele = integers.get(integers.size() - 1);
        integers.remove(integers.size() - 1);
        return ele;
    }

    
    public Integer peek() {
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

    
    public void push(Integer elem) {
        integers.add(elem);
    }
}
