package mod02.linkedlist.ex07;

public class removeLinkedListElements {
    public static void main(String[] args) {
        ListNode node0 = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(6);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);

        node0.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;

        ListNode node = removeElements(node0, 6);

        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }

    private static ListNode removeElements(ListNode head, int val) {
        ListNode sentinel = new ListNode(-1, head);
        if (head != null) {
            ListNode currentNode = head;
            ListNode prevNode = sentinel;
            while (currentNode != null) {
                if (currentNode.val == val) {
                    prevNode.next = prevNode.next.next;
                } else {
                    prevNode = prevNode.next;
                }
                currentNode = currentNode.next;
            }
        }
        return sentinel.next;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
