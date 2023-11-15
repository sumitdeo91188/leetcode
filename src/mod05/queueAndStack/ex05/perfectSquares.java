package mod05.queueAndStack.ex05;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class perfectSquares {
    public int numSquares(int n) {
        ArrayList<Integer> perfectSquares = new ArrayList<>();

        for (int i = 1; i * i <= n; i++) {
            perfectSquares.add(i * i);
        }

        Set<Integer> queue = new HashSet<>();
        queue.add(n);
        int level = 0;
        while (! queue.isEmpty()) {
            level++;
            Set<Integer> nextQueue = new HashSet<>();

            for (Integer remainder : queue) {
                for (Integer perfectSquare : perfectSquares) {
                    if (remainder < perfectSquare) {
                        break;
                    }
                    else if (remainder.equals(perfectSquare)){
                        return level;
                    }
                    else {
                        nextQueue.add(remainder - perfectSquare);
                    }
                }
            }
            queue = nextQueue;
        }

        return level;
    }
}
