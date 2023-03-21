package mod02.linkedlist.ex13;

public class flattenAMultilevelDoublyLinkedList {
    public static void main(String[] args) {}

    private static class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;

        @Override
        public String toString() {
            return "Node{" +
                    "val=" + val +
                    '}';
        }
    }

    static Node flatten(Node head) {
        /*1---2---3---4---5---6--NULL
                  |
                  7---8---9---10--NULL
                      |
                      11--12--NULL*/

        /*
            curr = 3
            next = 4




        */
        Node curr = head;
        while (curr != null) {
            if (curr.child != null) {
                Node next = curr.next;
                Node child = flatten(curr.child);
                curr.next = child;
                child.prev = curr;
                while (child.next != null) {
                    child = child.next;
                }
                curr.child = null;
                child.next = next;
                next.prev = child;
            }
            curr = curr.next;
        }
        return head;
    }
}
