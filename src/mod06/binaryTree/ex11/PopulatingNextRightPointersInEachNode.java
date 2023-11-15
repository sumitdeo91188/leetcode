package mod06.binaryTree.ex11;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointersInEachNode {
    public Node connect(Node root) {
        if (root != null) {
            Queue<Node> queue = new LinkedList<>();
            queue.offer(root);

            while (! queue.isEmpty()) {
                int levelSize = queue.size();
                for (int i = 0; i < levelSize; i++) {
                    Node node = queue.poll();

                    if (i < levelSize - 1) node.next = queue.peek();
                    if (node.left != null) queue.offer(node.left);
                    if (node.right != null) queue.offer(node.right);
                }
            }
        }
        return root;
    }


    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
}
