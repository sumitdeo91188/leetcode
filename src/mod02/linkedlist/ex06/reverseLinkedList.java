package mod02.linkedlist.ex06;

public class reverseLinkedList {
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

        ListNode node = reverseList(node0);

        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }

    private static ListNode reverseList(ListNode head) {
        if (head != null) {
            ListNode firstNode = head;
            while (firstNode.next != null) {
                ListNode temp = firstNode.next;
                firstNode.next = firstNode.next.next;
                temp.next = head;
                head = temp;

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
    }
}
