package mod02.linkedlist.ex15;

import java.util.HashMap;

public class copyListWithRandomPointer {
    public static void main(String[] args) {
        Node node0 = new Node(7);
        Node node1 = new Node(13);
        Node node2 = new Node(11);
        Node node3 = new Node(10);
        Node node4 = new Node(1);

        node0.next = node1;

        node1.next = node2;
        node1.random = node0;

        node2.next = node3;
        node2.random = node4;

        node3.next = node4;
        node3.random = node2;

        node4.random = node0;

        Node node = new Solution().copyRandomList(node0);
        System.out.println(node);
    }

    private static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    private static class Solution {
        HashMap<Node, Node> nodeMap = new HashMap<>();
        public Node copyRandomList(Node head) {
            if (head == null) {
                return null;
            }

            Node originalNode = head;
            Node copiedNode = new Node(head.val);
            Node copiedHead = copiedNode;
            nodeMap.put(originalNode, copiedNode);

            while (originalNode != null) {
                copiedNode.next = cloneNode(originalNode.next);
                copiedNode.random = cloneNode(originalNode.random);
                originalNode = originalNode.next;
                copiedNode = copiedNode.next;
            }

            return copiedHead;
        }

        private Node cloneNode(Node node) {
            if (node != null) {
                if (!nodeMap.containsKey(node)) {
                    nodeMap.put(node, new Node(node.val));
                }
                return nodeMap.get(node);
            }
            return null;
        }
    }
}
