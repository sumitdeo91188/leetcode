package mod06.binaryTree.ex03;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class binaryTreePostorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> nodes = new LinkedList<>();

        if (root != null) {
            Stack<TreeNode> stack = new Stack<>();
            stack.add(root);

            while (! stack.isEmpty()) {
                TreeNode node = stack.pop();
                nodes.addFirst(node.val);
                if (node.left != null)
                    stack.add(node.left);
                if (node.right != null)
                    stack.add(node.right);
            }
        }
        return nodes;
    }

    List<Integer> nodes = new ArrayList<>();
    public List<Integer> postorderTraversalRecursive(TreeNode root) {
        dfs(root);
        return nodes;
    }

    private void dfs(TreeNode root) {
        if (root != null) {
            dfs(root.left);
            dfs(root.right);
            nodes.add(root.val);
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
