package mod05.queueAndStack.ex07;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class validParentheses {
    public boolean isValid(String s) {
        if (s.length() < 2) {
            return false;
        }

        Stack<Character> stack = new Stack<>();

        for (Character ch : s.toCharArray()) {
            if (ch == ')') {
                if (!stack.empty() && stack.peek() == '(') {
                    stack.pop();
                } else {
                    return false;
                }
            } else if (ch == ']') {
                if (!stack.empty() && stack.peek() == '[') {
                    stack.pop();
                } else {
                    return false;
                }
            } else if (ch == '}') {
                if (!stack.empty() && stack.peek() == '{') {
                    stack.pop();
                } else {
                    return false;
                }
            } else {
                stack.push(ch);
            }

        }
        return stack.isEmpty();
    }
}
