package mod06.binaryTree.ex07;

import java.util.Stack;

public class PathSum {
    /*public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        if (root.left == null && root.right == null) return root.val - targetSum == 0;
        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }*/


    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root != null) {
            Stack<TreeNode> stack = new Stack<>();
            Stack<Integer> sumStack = new Stack<>();
            stack.add(root);
            sumStack.add(targetSum - root.val);
            int currentSum;

            while (! stack.isEmpty()) {
                TreeNode node = stack.pop();
                currentSum = sumStack.pop();

                if (node.left == null && node.right == null && currentSum == 0) return true;

                if (node.right != null) {
                    stack.push(node.right);
                    sumStack.push(currentSum - node.right.val);
                }

                if (node.left != null) {
                    stack.push(node.left);
                    sumStack.push(currentSum - node.left.val);
                }
            }
        }
        return false;
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
