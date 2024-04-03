package mod10.binarySearchTree.ex10;

public class ConvertSortedArrayToBinarySearchTree {
    public static void main(String[] args) {
        sortedArrayToBST(new int[]{-10, -3, 0, 5, 9});
    }
    public static class TreeNode {
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

    public static TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

    private static TreeNode helper(int[] nums, int left, int right) {
        if (left > right)
            return null;

        if (left == right)
            return new TreeNode(nums[left]);

        int pivot = (left + right) / 2;
        TreeNode node = new TreeNode(nums[pivot]);
        node.left = helper(nums, left, pivot - 1);
        node.right = helper(nums, pivot + 1, right);

        return node;
    }
}

