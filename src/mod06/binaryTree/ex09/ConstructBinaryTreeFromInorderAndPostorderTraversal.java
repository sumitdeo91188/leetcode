package mod06.binaryTree.ex09;

import java.util.HashMap;

public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
    int preOrderIndex;
    int[] preOrder;
    int[] inOrder;
    HashMap<Integer, Integer> indexMap = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preOrder = preorder;
        this.inOrder = inorder;
        preOrderIndex = 0;
        int index = 0;
        for (int i : inorder) {
            indexMap.put(i, index++);
        }
        return helper(0, inorder.length - 1);
    }

    private TreeNode helper(int inOrderLeftIndex, int inOrderRightIndex) {
        if (inOrderLeftIndex > inOrderRightIndex) {
            return null;
        }

        int rootNodeVal = preOrder[preOrderIndex];
        TreeNode rootNode = new TreeNode(rootNodeVal);
        int index = indexMap.get(rootNodeVal);
        preOrderIndex++;
        rootNode.left = helper(inOrderLeftIndex, index - 1);
        rootNode.right = helper(index + 1, inOrderRightIndex);
        return rootNode;
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
