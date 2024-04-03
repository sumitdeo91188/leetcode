package mod11.recursionII.ex08;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ConvertBSTToSortedDoublyLinkedList {
    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }

    Node first; // Pointer to the first node of the resulting doubly linked list
    Node last; // Pointer to the last node of the resulting doubly linked list

    public Node treeToDoublyList(Node root) {
        if (root == null)
            return null;

        // Initialize the doubly linked list by recursively traversing the tree
        convertToDoublyList(root);

        // Connect the head and tail of the doubly linked list to form a circular list
        first.left = last;
        last.right = first;

        return first;
    }

    private void convertToDoublyList(Node node) {
        if (node == null)
            return;

        // Recursively convert the left subtree
        convertToDoublyList(node.left);

        // Process the current node
        if (last != null) {
            // Connect the previous node (last) with the current node
            last.right = node;
            node.left = last;
        } else {
            // If last is null, set the current node as the first node of the list
            first = node;
        }
        // Update last to the current node
        last = node;

        // Recursively convert the right subtree
        convertToDoublyList(node.right);
    }
}

