package mod05.queueAndStack.ex01;

public class CircularQueueLinkedList {
    Node head, tail;
    int count;
    int capacity;

    public CircularQueueLinkedList(int k) {
        capacity = k;
        count = 0;
    }

    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }

        Node node = new Node(value);
        if (isEmpty()) {
            head = tail = node;
        } else {
            tail.nextNode = node;
            tail = node;
        }
        count++;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }

        head = head.nextNode;
        count--;
        return true;
    }

    public int Front() {
        if (isEmpty()) {
            return -1;
        }
        return head.val;
    }

    public int Rear() {
        if (isEmpty()) {
            return -1;
        }
        return tail.val;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public boolean isFull() {
        return count == capacity;
    }

    private class Node {
        int val;
        Node nextNode;

        public Node(int val) {
            this.val = val;
        }
    }
}
