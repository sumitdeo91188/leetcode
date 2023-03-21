package mod02.linkedlist.ex05;

public class removeNthNodeFromEndOfList {
    public static void main(String[] args) {
        ListNode node0 = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);

        node0.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        ListNode node = removeNthFromEnd(node0, 5);

        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }

    private static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode sentinel = new ListNode(-1);
        sentinel.next = head;

        ListNode ptr1 = sentinel;
        ListNode ptr2 = sentinel;

        for (int i = 0; i < n; i++) {
            ptr1 = ptr1.next;
        }

        while (ptr1.next != null) {
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }

        ptr2.next = ptr2.next.next;
        return sentinel.next;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
