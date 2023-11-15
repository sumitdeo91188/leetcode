package mod06.binaryTree.ex10;

import java.util.HashMap;

public class ConstructBinaryTreeFromInorderAndPreorderTraversal {
    int postOrderIndex;
    int[] postOrder;
    int[] inOrder;
    HashMap<Integer, Integer> indexMap = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.postOrder = postorder;
        this.inOrder = inorder;
        postOrderIndex = postOrder.length - 1;
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

        int rootNodeVal = postOrder[postOrderIndex];
        TreeNode rootNode = new TreeNode(rootNodeVal);
        int index = indexMap.get(rootNodeVal);
        postOrderIndex--;
        rootNode.right = helper(index + 1, inOrderRightIndex);
        rootNode.left = helper(inOrderLeftIndex, index - 1);
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
