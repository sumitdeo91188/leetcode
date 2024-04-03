package mod10.binarySearchTree.ex02;
import java.util.Stack;

public class InorderSuccessorInBST {

    private TreeNode inorderSuccessorNode;
    private TreeNode previous;

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

    /*Note: This does a full traversal of the tree, however (O(N) best case)
    whereas if you use BST properties to locate node it is O(logn) best case*/
    public TreeNode inorderSuccessorBinaryTree(TreeNode root, TreeNode p) {
        Stack<TreeNode> stack = new Stack<>();

        boolean found = false;
        TreeNode currNode = root;
        while (currNode != null || ! stack.isEmpty()) {
            while (currNode != null) {
                stack.push(currNode);
                currNode = currNode.left;
            }

            currNode = stack.pop();

            if (found) {
                return currNode;
            }

            if (currNode.val == p.val) {
                found = true;
            }
            currNode = currNode.right;
        }

        return null;
    }

    private void inorderSuccessorBinaryTreeRec(TreeNode node, TreeNode p) {

        if (node == null) {
            return;
        }

        // Recurse on the left side
        this.inorderSuccessorBinaryTreeRec(node.left, p);

        // Check if previous is the inorder predecessor of node
        if (this.previous == p && this.inorderSuccessorNode == null) {
            this.inorderSuccessorNode = node;
            return;
        }

        // Keeping previous up-to-date for further recursions
        this.previous = node;

        // Recurse on the right side
        this.inorderSuccessorBinaryTreeRec(node.right, p);
    }
    
    public TreeNode inorderSuccessorBST(TreeNode root, TreeNode p) {
        // Case 1: We simply need to find the leftmost node in the subtree rooted at p.right.

        if (p.right != null) {
            TreeNode leftMostNode = p.right;

            while (leftMostNode.left != null) {
                leftMostNode = leftMostNode.left;
            }
            return leftMostNode;
        } else {
            // Case 2: We need to perform the standard in order to traversal and keep track of the previous node.
            return inorderSuccessorBinaryTree(root, p);
        }
    }

    public TreeNode inorderSuccessorBST2(TreeNode root, TreeNode p) {
        TreeNode successor = null;

        while (root != null) {
            if (p.val >= root.val) {
                root = root.right;
            } else {
                successor = root;
                root = root.left;
            }
        }

        return successor;
    }
}
