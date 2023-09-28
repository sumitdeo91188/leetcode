package mod02.linkedlist.ex09;

import java.util.List;

public class palindromeLinkedList {
    public static void main(String[] args) {
        ListNode node0 = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);

        node0.next = node1;
        node1.next = node2;
        node2.next = node3;

        System.out.println(isPalindrome(node0));
    }

    private static boolean isPalindrome(ListNode head) {
        if (head != null && head.next != null) {
            ListNode endOfFirstHalf = getEndOfFirstHalf(head);
            ListNode startOfSecondHalf = endOfFirstHalf.next;
            endOfFirstHalf.next = null;
            ListNode reverseHead = reverse(startOfSecondHalf);
            return isIdentical(head, reverseHead);
        }
        return false;
    }

    private static boolean isIdentical(ListNode list1, ListNode list2) {
        while (list1 != null && list2 != null) {
            if (list1.val != list2.val) {
                return false;
            }
            list1 = list1.next;
            list2 = list2.next;
        }
        return true;
    }

    private static ListNode getEndOfFirstHalf(ListNode head) {
        ListNode fastNode = head;
        ListNode slowNode = head;

        while (fastNode != null && fastNode.next != null) {
            fastNode = fastNode.next.next;
            slowNode = slowNode.next;
        }
        return slowNode;
    }

    private static ListNode reverse(ListNode head) {
        if (head != null && head.next != null) {
            ListNode prev = head;
            ListNode curr = head.next;
            while (curr != null) {
                ListNode next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }
        }
        return head;
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
