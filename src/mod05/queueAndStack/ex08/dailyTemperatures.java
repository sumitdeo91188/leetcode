package mod05.queueAndStack.ex08;

import java.util.Deque;
import java.util.Stack;

public class dailyTemperatures {
    public static void main(String[] args) {
        dailyTemperatures(new int[] {73,74,75,71,69,72,76,73});
    }

    public static int[] dailyTemperatures(int[] temperatures) {
        int days = temperatures.length;
        Stack<Integer> stack = new Stack<>();
        int[] answer = new int[days];

        for (int day = 0; day < days; day++) {
            int currentTemp = temperatures[day];

            while (!stack.isEmpty() && temperatures[stack.peek()] < currentTemp) {
                int prevDay = stack.pop();
                answer[prevDay] = day - prevDay;
            }
            stack.push(day);
        }

        return answer;
    }
}
