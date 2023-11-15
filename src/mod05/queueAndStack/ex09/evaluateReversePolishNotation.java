package mod05.queueAndStack.ex09;

import java.util.Stack;

public class evaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {
            try {
                int currentInt = Integer.parseInt(token);
                stack.push(currentInt);
            } catch (Exception e) {
                int result = 0;
                int secondInt = stack.pop();
                int firstInt = stack.pop();
                switch (token) {
                    case "+" -> result = firstInt + secondInt;
                    case "-" -> result = firstInt - secondInt;
                    case "*" -> result = firstInt * secondInt;
                    case "/" -> result = firstInt / secondInt;
                }
                stack.push(result);
            }
        }
        return stack.pop();
    }
}
