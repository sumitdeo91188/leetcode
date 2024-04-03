package mod10.binarySearchTree.ex03;

import java.util.ArrayList;
import java.util.Stack;

public class BSTIterator {
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

    /*ArrayList<Integer> nodes;
    int index;

    public BSTIterator(TreeNode root) {
        nodes = new ArrayList<>();
        index = -1;
        this._inorder(root);
    }

    private void _inorder(TreeNode root) {
        if (root == null)
            return;

        _inorder(root.left);
        nodes.add(root.val);
        _inorder(root.right);
    }

    public int next() {
        return nodes.get(++index);
    }

    public boolean hasNext() {
        return index + 1 < nodes.size();
    }*/


    Stack<TreeNode> stack;
    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        _leftmostInorder(root);
    }

    private void _leftmostInorder(TreeNode root) {

        // For a given node, add all the elements in the leftmost branch of the tree
        // under it to the stack.
        while (root != null) {
            this.stack.push(root);
            root = root.left;
        }
    }

    public int next() {
        TreeNode node = stack.pop();

        if (node.right != null) {
            _leftmostInorder(node.right);
        }

        return node.val;
    }

    public boolean hasNext() {
        return ! stack.isEmpty();
    }
}
