package mod11.recursionII.ex07;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class GenerateParentheses {
    List<String> validParentheses; // List to store valid parenthesis combinations
    int maxNumberOfPairs; // Maximum number of parentheses pairs
    Stack<Character> stack; // Stack to track current parenthesis sequence

    public List<String> generateParenthesis(int n) {
        this.maxNumberOfPairs = n;
        validParentheses = new ArrayList<>();
        stack = new Stack<>();
        backtrack(0, 0); // Start backtracking from no parentheses
        return validParentheses;
    }

    // Backtracking method to generate valid parenthesis combinations
    private void backtrack(int openCount, int closeCount) {
        // If the current combination reaches the maximum number of parentheses pairs, add it to the list
        if (openCount == maxNumberOfPairs && closeCount == maxNumberOfPairs) {
            StringBuilder sb = new StringBuilder();
            for (Character ch : stack) {
                sb.append(ch);
            }
            validParentheses.add(sb.toString());
            return;
        }

        // If there are more closing parentheses than opening ones, the combination is invalid
        if (openCount < closeCount) {
            return;
        }

        // Add '(' if there are fewer than the maximum number of opening parentheses
        if (openCount < maxNumberOfPairs) {
            stack.push('(');
            backtrack(openCount + 1, closeCount);
            stack.pop(); // Backtrack by removing the last added '('
        }

        // Add ')' if there are fewer than the maximum number of closing parentheses
        if (closeCount < maxNumberOfPairs) {
            stack.push(')');
            backtrack(openCount, closeCount + 1);
            stack.pop(); // Backtrack by removing the last added ')'
        }
    }
}

