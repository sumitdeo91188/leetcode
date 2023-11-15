package mod06.binaryTree.ex12;

import mod06.binaryTree.ex10.ConstructBinaryTreeFromInorderAndPreorderTraversal;

import java.util.*;

public class LowestCommonAncestorOfABinaryTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p == root || q == root) {
            return root;
        }

        HashMap<TreeNode, TreeNode> parentMap = new HashMap<>();
        Stack<TreeNode> stack = new Stack<>();
        parentMap.put(root, null);
        stack.push(root);

        while (! stack.isEmpty()) {
            TreeNode node = stack.pop();

            if (node.left != null) {
                parentMap.put(node.left, node);
                stack.push(node.left);
            }

            if (node.right != null) {
                parentMap.put(node.right, node);
                stack.push(node.right);
            }
        }

        HashSet<TreeNode> set = new HashSet<>();
        while (p != null) {
            set.add(p);
            p = parentMap.get(p);
        }

        while (! set.contains(q)) {
            q = parentMap.get(q);
        }

        return q;
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
