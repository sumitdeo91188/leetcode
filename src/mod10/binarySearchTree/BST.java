package mod10.binarySearchTree;


import java.util.ArrayList;

public class BST {
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

    public TreeNode insert(TreeNode root, int val) {
        if (root == null)
            return new TreeNode(val);

        if (val < root.val) {
            root.left = insert(root.left, val);
        } else if (val > root.val) {
            root.right = insert(root.right, val);
        }

        return root;
    }

    public TreeNode search(TreeNode root, int val) {
        if (root == null)
            return null;

        if (val < root.val) {
            return search(root.left, val);
        } else if (val > root.val) {
            return search(root.right, val);
        } else {
            return root;
        }
    }

    public TreeNode delete(TreeNode root, int val) {
        if (root == null) {
            return null;
        }

        if (val < root.val) {
            root.left = delete(root.left, val);
        } else if (val > root.val) {
            root.right = delete(root.right, val);
        } else {
            //case 1: both nodes are null
            if (root.left == null && root.right == null) {
                return null;
            }

            //case 2: one child
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            //case 3: two children
            TreeNode successor = successor(root);
            root.val = successor.val;
            root.right = delete(root.right, successor.val);
        }

        return root;
    }

    public TreeNode successor(TreeNode root) {
        root = root.right;
        while (root.left != null) root = root.left;
        return root;
    }

    /*
    One step left and then always right
    */
    public TreeNode predecessor(TreeNode root) {
        root = root.left;
        while (root.right != null) root = root.right;
        return root;
    }

    public void printInRange(TreeNode root, int x, int y) {
        if (root == null)
            return;

        if (root.val >= x && root.val <= y) {
            printInRange(root.left, x, y);
            System.out.println(root.val);
            printInRange(root.right, x, y);
        } else if (root.val >= y) {
            printInRange(root.left, x, y);
        } else {
            printInRange(root.right, x, y);
        }
    }

    public void printRoot2Path(TreeNode root, ArrayList<Integer> list) {
        if (root == null)
            return;

        list.add(root.val);

        if (root.left == null && root.right == null) {
            printPath(list);
        } else {
            printRoot2Path(root.left, list);
            printRoot2Path(root.right, list);
        }

        list.remove(list.size() - 1);
    }

    private void printPath(ArrayList<Integer> list) {
        for (Integer integer : list) {
            System.out.println(integer);
        }
    }
}
