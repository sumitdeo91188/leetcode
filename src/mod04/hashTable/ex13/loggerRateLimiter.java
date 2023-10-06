package mod04.hashTable.ex13;

import java.util.HashMap;

public class loggerRateLimiter {
    public static void main(String[] args) {
        Logger logger = new Logger();
        System.out.println(logger.shouldPrintMessage(1, "foo"));
        System.out.println(logger.shouldPrintMessage(2, "bar"));
        System.out.println(logger.shouldPrintMessage(3, "foo"));
        System.out.println(logger.shouldPrintMessage(8, "bar"));
        System.out.println(logger.shouldPrintMessage(10, "foo"));
        System.out.println(logger.shouldPrintMessage(11, "foo"));
    }

    static class Logger {
        HashMap<String, Integer> map;
        public Logger() {
            map = new HashMap<>();
        }

        public boolean shouldPrintMessage(int timestamp, String message) {
            if (map.containsKey(message)) {
                int gap = timestamp - map.get(message);
                if (gap < 10) {
                    return false;
                } else {
                    map.put(message, timestamp);
                    return true;
                }
            } else {
                map.put(message, timestamp);
                return true;
            }
        }
    }
}
