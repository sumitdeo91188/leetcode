package mod02.linkedlist.ex04;

public class intersectionOfTwoLinkedLists {
    public static void main(String[] args) {
        ListNode nodeA0 = new ListNode(4);
        ListNode nodeA1 = new ListNode(1);
        ListNode nodeA2 = new ListNode(8);
        ListNode nodeA3 = new ListNode(4);
        ListNode nodeA4 = new ListNode(5);

        nodeA0.next = nodeA1;
        nodeA1.next = nodeA2;
        nodeA2.next = nodeA3;
        nodeA3.next = nodeA4;

        ListNode nodeB0 = new ListNode(5);
        ListNode nodeB1 = new ListNode(6);
        ListNode nodeB2 = new ListNode(1);

        nodeB0.next = nodeB1;
        nodeB1.next = nodeB2;
        nodeB2.next = nodeA2;

        ListNode node = getIntersectionNode(nodeA0, nodeB0);

        System.out.println(node.val);
    }

    private static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode ptr1 = headA;
        ListNode ptr2 = headB;

        while (ptr1 != ptr2) {
            ptr1 = ptr1 == null ? headB : ptr1.next;
            ptr2 = ptr2 == null ? headA : ptr2.next;
        }
        return ptr1;
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
