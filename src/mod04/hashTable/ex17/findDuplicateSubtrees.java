package mod04.hashTable.ex17;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class findDuplicateSubtrees {
    public static void main(String[] args) {
    }

    List<TreeNode> res = new ArrayList<>();
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        traverse(root, new HashMap<>());
        return res;
    }

    private String traverse(TreeNode node, HashMap<String,Integer> cnt) {
        if (node == null) {
            return "";
        }

        String rep = "(" + traverse(node.left, cnt) + ")" + node.val + "(" + traverse(node.right, cnt) + ")";
        cnt.put(rep, cnt.getOrDefault(rep, 0) + 1);
        if (cnt.get(rep) == 2) {
            res.add(node);
        }

        return rep;
    }

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
}
