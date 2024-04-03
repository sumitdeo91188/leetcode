package mod10.binarySearchTree.ex04;

import java.util.Stack;

public class SearchInABinarySearchTree {
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

    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }

        while (root != null) {
            if (val > root.val) {
                root = root.right;
            } else if (val < root.val) {
                root = root.left;
            } else {
                return root;
            }
        }

        return null;
    }
}
