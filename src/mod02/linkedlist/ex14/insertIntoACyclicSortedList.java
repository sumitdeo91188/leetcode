package mod02.linkedlist.ex14;

public class insertIntoACyclicSortedList {
    public static void main(String[] args) {
        Node node0 = new Node(3);
        Node node1 = new Node(3);
        Node node2 = new Node(3);

        node0.next = node1;
        node1.next = node2;
        node2.next = node0;

        Node node = insert(node0, 0);

        while (node != null) {
            System.out.println(node);
            node = node.next;
        }
    }

    private static class Node {
        public int val;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _next) {
            val = _val;
            next = _next;
        }
    }

    static Node insert(Node head, int insertVal) {
        if (head == null) {
            head = new Node(insertVal);
            head.next = head;
            return head;
        }

        Node prev = head;
        Node next = head.next;
        boolean shouldInsert = false;

        do {
            if (prev.val <= insertVal && next.val >= insertVal) {
                shouldInsert = true;
            }

            if (prev.val > next.val) {
                if (prev.val <= insertVal || next.val >= insertVal) {
                    shouldInsert = true;
                }
            }

            if (shouldInsert) {
                Node node = new Node(insertVal);
                node.next = next;
                prev.next = node;
                return head;
            }

            prev = prev.next;
            next = next.next;
        } while (prev != head);

        if (prev.val == next.val) {
            Node node = new Node(insertVal);
            node.next = next;
            prev.next = node;
        }

        return head;
    }
}
