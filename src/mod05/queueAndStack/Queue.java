package mod05.queueAndStack;

import java.util.ArrayList;
import java.util.List;

public class Queue {
    int startIndex;
    List<Integer> integers;

    public Queue() {
        integers = new ArrayList<>();
        startIndex = 0;
    }

    
    public Integer poll() {
        if (isEmpty()) {
            throw new RuntimeException("Empty queue.");
        }
        return integers.get(startIndex++);
    }

    
    public Integer peek() {
        if (isEmpty()) {
            throw new RuntimeException("Empty queue.");
        }
        return integers.get(startIndex);
    }

    
    public int size() {
        return integers.size() - startIndex;
    }

    
    public boolean isEmpty() {
        return startIndex == integers.size();
    }

    
    public void offer(Integer elem) {
        integers.add(elem);
    }
}
