package mod07.recursionI.ex11;

import java.util.ArrayList;
import java.util.List;

public class uniqueBinarySearchTreesII {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<TreeNode> generateTrees(int n) {
        return allPossibleBST(1, n);
    }

    private List<TreeNode> allPossibleBST(int start, int end) {
        List<TreeNode> list = new ArrayList<>();
        if (start > end) {
            list.add(null);
            return list;
        }

        for (int i = start; i <= end; i++) {
            List<TreeNode> leftSubTree = allPossibleBST(start, i -1);
            List<TreeNode> rightSubTree = allPossibleBST(i + 1, end);

            for (TreeNode leftNode : leftSubTree) {
                for (TreeNode rightNode : rightSubTree) {
                    TreeNode root = new TreeNode(i, leftNode, rightNode);
                    list.add(root);
                }
            }
        }

        return list;
    }
}
