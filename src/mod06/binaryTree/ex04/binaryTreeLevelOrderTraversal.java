package mod06.binaryTree.ex04;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class binaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> nodesList = new ArrayList<>();

        if (root != null) {
            Queue<TreeNode> queue = new ArrayDeque<>();
            int level = 0;
            queue.offer(root);

            while (!queue.isEmpty()) {
                nodesList.add(new ArrayList<>());
                int levelSize = queue.size();

                for (int i = 0; i < levelSize; i++) {
                    TreeNode node = queue.poll();
                    nodesList.get(level).add(node.val);
                    if (node.left != null)
                        queue.offer(node.left);
                    if (node.right != null)
                        queue.offer(node.right);
                }
                level++;
            }
        }
        return nodesList;
    }

    List<List<Integer>> levels = new ArrayList<>();
    public List<List<Integer>> levelOrderRecursion(TreeNode root) {
        if (root != null)
            helper(root, 0);
        return levels;
    }

    private void helper(TreeNode root, int level) {
        if (level == levels.size())
            levels.add(new ArrayList<>());

        levels.get(level).add(root.val);
        if (root.left != null)
            helper(root.left, level + 1);
        if (root.right != null)
            helper(root.right, level + 1);
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
