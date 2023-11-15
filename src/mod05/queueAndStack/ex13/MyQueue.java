package mod05.queueAndStack.ex13;

import java.util.Stack;

public class MyQueue {
    Stack<Integer> stack1;
    Stack<Integer> stack2;
    public MyQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void push(int x) {
        stack1.push(x);
    }

    public int pop() {
        if (stack2.empty()) {
            copyStack(stack1, stack2);
        }

        return stack2.pop();
    }

    public int peek() {
        if (stack2.empty()) {
            copyStack(stack1, stack2);
        }

        return stack2.peek();
    }

    public boolean empty() {
        return stack1.empty() && stack2.empty();
    }

    private void copyStack(Stack<Integer> stackFrom, Stack<Integer> stackTo) {
        while (! stackFrom.isEmpty()) {
            stackTo.push(stackFrom.pop());
        }
    }
}
