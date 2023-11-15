package mod05.queueAndStack.ex01;

public class CircularQueue {

    int[] queue;
    int headIndex;
    int count;
    int capacity;

    public CircularQueue(int k) {
        capacity = k;
        count = 0;
        headIndex = 0;
        queue = new int[capacity];
    }

    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }

        queue[(headIndex + count) % capacity] = value;
        count++;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }

        headIndex = (headIndex + 1) % capacity;
        count--;
        return true;
    }

    public int Front() {
        if (isEmpty()) {
            return -1;
        }
        return queue[headIndex];
    }

    public int Rear() {
        if (isEmpty()) {
            return -1;
        }
        return queue[(headIndex + count - 1) % capacity];
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public boolean isFull() {
        return count == capacity;
    }
}
