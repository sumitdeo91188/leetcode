package mod05.queueAndStack.ex02;

import java.util.ArrayDeque;
import java.util.Queue;

public class MovingAverage {

    Queue<Integer> queue;
    int windowSum;
    int count;
    int capacity;

    public MovingAverage(int size) {
        capacity = size;
        windowSum = 0;
        count = 0;
        queue = new ArrayDeque<>();
    }

    public double next(int val) {
        queue.add(val);
        count++;
        if (queue.size() > capacity) {
            windowSum = windowSum - queue.poll() + val;
        } else {
            windowSum += val;
        }

        return windowSum / (1.0 * Math.min(count, capacity));
    }
}
