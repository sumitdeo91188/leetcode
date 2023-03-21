package mod02.linkedlist.ex11;

public class mergeTwoSortedLists {
    public static void main(String[] args) {
        ListNode nodea0 = new ListNode(1);
        ListNode nodea1 = new ListNode(2);
        ListNode nodea2 = new ListNode(3);

        nodea0.next = nodea1;
        nodea1.next = nodea2;

        ListNode nodeb0 = new ListNode(1);
        ListNode nodeb1 = new ListNode(2);
        ListNode nodeb2 = new ListNode(3);
        ListNode nodeb3 = new ListNode(4);


        nodeb0.next = nodeb1;
        nodeb1.next = nodeb2;
        nodeb2.next = nodeb3;

        ListNode node = mergeTwoLists(nodea0, nodeb0);

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

        @Override
        public String toString() {
            return "Node{" +
                    "val=" + val +
                    '}';
        }
    }

    static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode curr1 = list1;
        ListNode curr2 = list2;
        ListNode sentinel = new ListNode(0);
        ListNode curr = sentinel;
        while (curr1 != null || curr2 != null) {
            if (curr1 == null) {
                curr.next = curr2;
                break;
            } else if (curr2 == null) {
                curr.next = curr1;
                break;
            } else if (curr1.val <= curr2.val) {
                curr.next = new ListNode(curr1.val);
                curr1 = curr1.next;
            } else {
                curr.next = new ListNode(curr2.val);
                curr2 = curr2.next;
            }
            curr = curr.next;
        }
        return sentinel.next;
    }
}
