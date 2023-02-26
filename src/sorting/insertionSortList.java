package sorting;

import java.util.List;

public class insertionSortList {
    public static void main(String[] args) {
        // head = [-1,5,3,4,0]
        ListNode inputNodesHead = new ListNode(-1, new ListNode(5, new ListNode(3, new ListNode(4, new ListNode(0)))));
        ListNode sortedNodesHead = insertionSortList(inputNodesHead);
        ListNode node = sortedNodesHead;
        while (node.next != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    private static ListNode insertionSortList(ListNode head) {
        ListNode dummyHead = new ListNode();
        ListNode runningNode = head;
        while (runningNode != null) {
            ListNode prevNode = dummyHead;
            while (prevNode.next != null && prevNode.next.val <= runningNode.val) {
                prevNode = prevNode.next;
            }

            ListNode nextNode = runningNode.next;
            runningNode.next = prevNode.next;
            prevNode.next = runningNode;

            runningNode = nextNode;
        }
        return dummyHead.next;
    }
}
