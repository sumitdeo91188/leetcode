package mod07.recursionI.ex03;

import java.util.List;

public class reverseLinkedList {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode reverseHeadNode = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return reverseHeadNode;
    }

    private static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "val=" + val +
                    '}';
        }
    }
}
