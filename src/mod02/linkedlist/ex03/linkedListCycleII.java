package mod02.linkedlist.ex03;

public class linkedListCycleII {
    public static void main(String[] args) {
        ListNode node0 = new ListNode(3);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(0);
        ListNode node3 = new ListNode(-4);

        node0.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node1;

        System.out.println(detectCycle(node0).val);
    }

    private static ListNode detectCycle(ListNode head) {
        ListNode intersect = getIntersect(head);
        if (intersect != null) {
            ListNode ptr1 = head;
            ListNode ptr2 = intersect;

            while (ptr1 != ptr2) {
                ptr1 = ptr1.next;
                ptr2 = ptr2.next;
            }
            return ptr1;
        }
        return null;
    }

    public static ListNode getIntersect(ListNode head) {
        if (head != null) {
            ListNode slow = head;
            ListNode fast = head;

            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;

                if (slow == fast) {
                    return slow;
                }
            }
        }

        return null;
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
