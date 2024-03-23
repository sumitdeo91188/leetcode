package mod08.heap.ex11;

import java.util.Comparator;
import java.util.PriorityQueue;

public class FindMedianFromDataStream {
    class MedianFinder {
        PriorityQueue<Integer> lowerStream;
        PriorityQueue<Integer> higherStream;

        public MedianFinder() {
            lowerStream = new PriorityQueue<>(Comparator.reverseOrder());
            higherStream = new PriorityQueue<>();
        }

        public void addNum(int num) {
            // add a new num to lower stream
            lowerStream.offer(num);

            // check if higher stream has all the nums greater than or equal to lower stream
            if (!lowerStream.isEmpty() && !higherStream.isEmpty() && lowerStream.peek() > higherStream.peek()) {
                higherStream.offer(lowerStream.poll());
            }

            // check if balancing needed
            if (lowerStream.size() - higherStream.size() >= 2) {
                higherStream.offer(lowerStream.poll());
            }

            if (higherStream.size() - lowerStream.size() >= 2) {
                lowerStream.offer(higherStream.poll());
            }
        }

        public double findMedian() {
            if (lowerStream.size() > higherStream.size()) {
                return lowerStream.peek();
            } else if (higherStream.size() > lowerStream.size()) {
                return higherStream.peek();
            } else {
                return (lowerStream.peek() + higherStream.peek()) / 2.0;
            }
        }
    }
}
