package mod08.heap.ex06;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthSmallestElementInASortedMatrix {
    public class Node {
        int i;
        int j;
        int val;

        public Node(int i, int j, int val) {
            this.i = i;
            this.j = j;
            this.val = val;
        }

        public int getI() {
            return i;
        }

        public void setI(int i) {
            this.i = i;
        }

        public int getJ() {
            return j;
        }

        public void setJ(int j) {
            this.j = j;
        }

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }
    }

    public class NodeComparator implements Comparator<Node> {
        @Override
        public int compare(Node o1, Node o2) {
            return o1.getVal() - o2.getVal();
        }
    }
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Node> heap = new PriorityQueue<>(new NodeComparator());
        int n = matrix.length;

        for (int i = 0; i < Math.min(n, k); i++) {
            heap.offer(new Node(i, 0, matrix[i][0]));
        }

        Node node = heap.peek();

        while (k > 0) {
            node = heap.poll();
            int i = node.getI();
            int j = node.getJ();

            if (j < n - 1) {
                heap.offer(new Node(i, j + 1, matrix[i][j + 1]));
            }
            k--;
        }

        return node.getVal();
    }
}
