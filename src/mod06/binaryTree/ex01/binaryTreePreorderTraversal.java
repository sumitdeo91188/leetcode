package mod06.binaryTree.ex01;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class binaryTreePreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> nodes = new ArrayList<>();

        if (root != null) {
            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);

            while (!stack.isEmpty()) {
                TreeNode node = stack.pop();
                if (node.right != null)
                    stack.push(node.right);
                if (node.left != null)
                    stack.push(node.left);
                nodes.add(node.val);
            }
        }
        return nodes;
    }

    List<Integer> nodes = new ArrayList<>();
    public List<Integer> preorderTraversalRecursive(TreeNode root) {
        dfs(root);
        return nodes;
    }

    private void dfs(TreeNode root) {
        if (root != null) {
            nodes.add(root.val);
            dfs(root.left);
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
