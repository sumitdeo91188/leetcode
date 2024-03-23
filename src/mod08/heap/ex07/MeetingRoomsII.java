package mod08.heap.ex07;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MeetingRoomsII {

    public int minMeetingRooms(int[][] intervals) {
        int rooms = 0;
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(i -> i[1]));

        Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));

        for (int[] interval : intervals) {
            if (minHeap.isEmpty() || minHeap.peek()[1] > interval[0]) {
                rooms++;
            } else {
                minHeap.poll();
            }
            minHeap.offer(interval);
        }

        return rooms;
    }
}
