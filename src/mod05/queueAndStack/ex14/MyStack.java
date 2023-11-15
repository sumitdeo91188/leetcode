package mod05.queueAndStack.ex14;

import java.util.LinkedList;
import java.util.Queue;

public class MyStack {
    Queue<Integer> queue;
    Integer top;
    public MyStack() {
        queue = new LinkedList<>();
        top = null;
    }

    public void push(int x) {
        top = x;
        queue.offer(x);
    }

    public int pop() {
        int numOfElements = queue.size();
        while (numOfElements > 2) {
            queue.offer(queue.poll());
            numOfElements--;
        }
        top = queue.peek();
        queue.offer(queue.poll());
        return queue.poll();
    }

    public int top() {
        return top;
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}
