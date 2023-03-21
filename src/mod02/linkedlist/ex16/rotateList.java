package mod02.linkedlist.ex16;

public class rotateList {
    public static void main(String[] args) {
        ListNode node0 = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);

        node0.next = node1;
        node1.next = node2;

        Solution solution = new Solution();
        ListNode node = solution.rotateRight(node0, 5);

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

    private static class Solution {
        public ListNode rotateRight(ListNode headNode, int k) {
            if (headNode != null) {
                ListNode node = headNode;
                int size = 1;

                while (node.next != null) {
                    node = node.next;
                    size++;
                }

                if (k%size == 0) {return headNode;}

                node.next = headNode;
                ListNode newHeadNode = headNode;
                ListNode newTailNode = node;
                for (int i = 0; i < size - k%size; i++) {
                    newHeadNode = newHeadNode.next;
                    newTailNode = newTailNode.next;
                }
                newTailNode.next = null;
                return newHeadNode;
            }

            return null;
        }
    }
}
