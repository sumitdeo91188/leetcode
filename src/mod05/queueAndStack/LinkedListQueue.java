package mod05.queueAndStack;

import java.util.LinkedList;

public class LinkedListQueue {
    LinkedList<Integer> integers;

    public LinkedListQueue() {
        integers = new LinkedList<>();
    }

    
    public Integer poll() {
        if (isEmpty()) {
            throw new RuntimeException("Empty queue.");
        }
        return integers.removeFirst();
    }

    
    public Integer peek() {
        if (isEmpty()) {
            throw new RuntimeException("Empty queue.");
        }
        return integers.peekFirst();
    }

    
    public int size() {
        return integers.size();
    }

    
    public boolean isEmpty() {
        return integers.isEmpty();
    }

    
    public void offer(Integer elem) {
        integers.addLast(elem);
    }
}
