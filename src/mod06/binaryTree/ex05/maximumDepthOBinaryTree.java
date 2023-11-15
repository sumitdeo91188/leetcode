package mod06.binaryTree.ex05;

public class maximumDepthOBinaryTree {

    //top-bottom approach
    /*private int answer = 0;
    public int maxDepth(TreeNode root) {
        if (root != null) {
            helper(root, 1);
        }
        return answer;
    }

    private void helper(TreeNode node, int depth) {
        if (node.left == null && node.right == null) {
            answer = Math.max(answer, depth);
            return;
        }
        if (node.left != null)
            helper(node.left, depth + 1);
        if (node.right != null)
            helper(node.right, depth + 1);
    }*/


    //bottom-up approach
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int left_depth = maxDepth(root.left);
        int right_depth = maxDepth(root.right);
        return Math.max(left_depth, right_depth) + 1;
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
