package mod10.binarySearchTree.ex08;

import java.util.TreeSet;

public class ContainsDuplicateIII {
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

    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        TreeSet<Integer> set = new TreeSet<>();

        for (int i = 0; i < nums.length; i++) {
            Integer ceiling = set.ceiling(nums[i]);
            if (ceiling != null && ceiling <= nums[i] + valueDiff)
                return true;
            Integer floor = set.floor(nums[i]);
            if (floor != null && nums[i] <=  floor + valueDiff)
                return true;

            set.add(nums[i]);

            if (set.size() > indexDiff) {
                set.remove(nums[i - indexDiff]);
            }
        }

        return false;
    }
}
