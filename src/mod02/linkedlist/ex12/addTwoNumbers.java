package mod02.linkedlist.ex12;

public class addTwoNumbers {
    public static void main(String[] args) {
        ListNode l11 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9)))))));
        ListNode l21 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9))));
        ListNode node = addTwoNumbers(l11, l21);

        while (node != null) {
            System.out.println(node);
            node = node.next;
        }
    }

    private static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
        ListNode(int val, ListNode next) {
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

    static ListNode addTwoNumbers(ListNode list1, ListNode list2) {
        ListNode curr1 = list1;
        ListNode curr2 = list2;
        ListNode sentinel = new ListNode(0);
        ListNode curr = sentinel;
        int carry = 0;
        while (curr1 != null || curr2 != null) {
            int val1 = 0;
            int val2 = 0;

            if (curr1 != null) {
                val1 = curr1.val;
                curr1 = curr1.next;
            }

            if (curr2 != null) {
                val2 = curr2.val;
                curr2 = curr2.next;
            }

            int val = val1 + val2 + carry;
            if (val >= 10) {
                carry = val / 10;
                val = val % 10;
            } else {
                carry = 0;
            }
            curr.next = new ListNode(val);
            curr = curr.next;
        }

        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return sentinel.next;
    }
}
