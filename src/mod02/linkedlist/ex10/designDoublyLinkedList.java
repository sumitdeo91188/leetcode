package mod02.linkedlist.ex10;

public class designDoublyLinkedList {
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
        ListNode prev;

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
        ListNode head, tail;

        public MyLinkedList() {
            this.size = 0;
            head = new ListNode(0);
            tail = new ListNode(0);
            head.next = tail;
            tail.prev = head;
        }

        public int get(int index) {
            if (index < 0 || index >= size) {
                return -1;
            }

            ListNode curr;
            if (index + 1 < size - index) {
                curr = head;
                for (int i = 0; i < index + 1; i++) {
                    curr = curr.next;
                }
            } else {
                curr = tail;
                for (int i = 0; i < size - index; i++) {
                    curr = curr.prev;
                }
            }

            return curr.val;
        }

        public void addAtHead(int val) {
            ListNode pre = head;
            ListNode suc = head.next;

            ListNode toAdd = new ListNode(val);
            pre.next = toAdd;
            suc.prev = toAdd;
            toAdd.next = suc;
            toAdd.prev = pre;
            size++;
        }

        public void addAtTail(int val) {
            ListNode suc = tail;
            ListNode pre = tail.prev;

            ListNode toAdd = new ListNode(val);
            pre.next = toAdd;
            suc.prev = toAdd;
            toAdd.next = suc;
            toAdd.prev = pre;
            size++;
        }

        public void addAtIndex(int index, int val) {
            if (index < 0 || index > size) {
                return;
            }

            ListNode pre;
            ListNode suc;
            if (index  < size - index) {
                pre = head;
                for (int i = 0; i < index; i++) {
                    pre = pre.next;
                }
                suc = pre.next;
            } else {
                suc = tail;
                for (int i = 0; i < size - index; i++) {
                    suc = suc.prev;
                }
                pre = suc.prev;
            }

            ListNode toAdd = new ListNode(val);
            pre.next = toAdd;
            suc.prev = toAdd;
            toAdd.next = suc;
            toAdd.prev = pre;
            size++;
        }

        public void deleteAtIndex(int index) {
            if (index < 0 || index >= size) {
                return;
            }

            ListNode pre;
            ListNode suc;
            if (index  < size - index) {
                pre = head;
                for (int i = 0; i < index; i++) {
                    pre = pre.next;
                }
                suc = pre.next.next;
            } else {
                suc = tail;
                for (int i = 0; i < size - index - 1; i++) {
                    suc = suc.prev;
                }
                pre = suc.prev.prev;
            }

            pre.next = suc;
            suc.prev = pre;
            size--;
        }
    }

}
