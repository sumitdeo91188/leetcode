package mod06.binaryTree.ex02;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class binaryTreeInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> nodes = new ArrayList<>();

        if (root != null) {
            Stack<TreeNode> stack = new Stack<>();
            TreeNode currentNode = root;

            while (currentNode!= null || ! stack.isEmpty()) {
                while (currentNode != null) {
                    stack.push(currentNode);
                    currentNode = currentNode.left;
                }

                currentNode = stack.pop();
                nodes.add(currentNode.val);
                currentNode = currentNode.right;
            }
        }
        return nodes;
    }

    List<Integer> nodes = new ArrayList<>();
    public List<Integer> inorderTraversalRecursive(TreeNode root) {
        dfs(root);
        return nodes;
    }

    private void dfs(TreeNode root) {
        if (root != null) {
            dfs(root.left);
            nodes.add(root.val);
            dfs(root.right);
        }
    }

    class TreeNode {
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
}
