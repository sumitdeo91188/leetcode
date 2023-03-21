package mod02.linkedlist.ex09;

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
        if (head != null) {
            int size = 0;
            ListNode current = head;
            while (current != null) {
                size++;
                current = current.next;
            }

            if (size == 1) {
                return true;
            }

            ListNode secondHalf;
            current = head;
            for (int i = 0; i < size / 2; i++) {
                current = current.next;
            }
            if (size % 2 == 0) {
                secondHalf = current;
            } else {
                secondHalf = current.next;
            }

            secondHalf = reverse(secondHalf);
            current = head;
            while (secondHalf != null) {
                if (current.val != secondHalf.val) {
                    return false;
                }
                secondHalf = secondHalf.next;
                current = current.next;
            }
            return true;
        }
        return false;
    }

    private static ListNode reverse(ListNode head) {
        ListNode first = head;
        while (first.next != null) {
            ListNode temp = first.next;
            first.next = first.next.next;
            temp.next = head;
            head = temp;
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
