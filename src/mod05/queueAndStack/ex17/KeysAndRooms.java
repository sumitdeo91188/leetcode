package mod05.queueAndStack.ex17;

import java.util.*;

public class KeysAndRooms {
    public static void main(String[] args) {

    }
    public static boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Set<Integer> visitedRooms = new HashSet<>();
        Queue<Integer> keys = new LinkedList<>();
        keys.add(0);

        while (! keys.isEmpty()) {
            int key = keys.poll();
            if (! visitedRooms.contains(key)) {
                visitedRooms.add(key);
            }

            for (int nextKey : rooms.get(key)) {
                if (! visitedRooms.contains(nextKey)) {
                    keys.offer(nextKey);
                }
            }
        }

        return visitedRooms.size() == rooms.size();
    }
}
