package mod02.linkedlist.ex01;

public class designLinkedList {
    public static void main(String[] args) {
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.addAtHead(2);
        linkedList.addAtTail(3);
        linkedList.addAtIndex(0, 1);    // linked list becomes 1->2->3
        System.out.println(linkedList.get(1));              // return 2
        linkedList.deleteAtIndex(1);    // now the linked list is 1->3
        System.out.println(linkedList.get(1));              // return 3
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
    private static class MyLinkedList {
        int size;
        ListNode head;

        public MyLinkedList() {
            this.size = 0;
        }

        public int get(int index) {
            if (index < 0 || index >= size) {
                return -1;
            }

            ListNode curr = head;
            for (int i = 0; i < index + 1; i++) {
                curr = curr.next;
            }
            return curr.val;
        }

        public void addAtHead(int val) {
            addAtIndex(0, val);
        }

        public void addAtTail(int val) {
            addAtIndex(size, val);
        }

        public void addAtIndex(int index, int val) {
            if (index < 0 || index > size) {
                return;
            }

            ListNode pre = head;
            for (int i = 0; i < index; i++) {
                pre = pre.next;
            }

            ListNode toAdd = new ListNode(val);
            toAdd.next = pre.next;
            pre.next = toAdd;
            size++;
        }

        public void deleteAtIndex(int index) {
            if (index < 0 || index >= size) {
                return;
            }

            ListNode pre = head;
            for (int i = 0; i < index; i++) {
                pre = pre.next;
            }

            pre.next = pre.next.next;
            size--;
        }
    }

}
