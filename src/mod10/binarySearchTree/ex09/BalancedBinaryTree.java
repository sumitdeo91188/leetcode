package mod10.binarySearchTree.ex09;

import java.util.TreeSet;

public class BalancedBinaryTree {
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

    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;

        int leftHeight = _height(root.left);
        int rightHeight = _height(root.right);

        return Math.abs(leftHeight - rightHeight) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    private int _height(TreeNode root) {
        if (root == null)
            return -1;

        return 1 + Math.max(_height(root.left), _height(root.right));
    }
}
