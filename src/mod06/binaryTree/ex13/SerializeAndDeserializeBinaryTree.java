package mod06.binaryTree.ex13;

import java.util.*;

public class SerializeAndDeserializeBinaryTree {
    public static void main(String[] args) {
        TreeNode rootNode =
                new TreeNode(
                        5,
                        new TreeNode(4, new TreeNode(6), new TreeNode(7, new TreeNode(8), null)),
                        new TreeNode(2, new TreeNode(1, null, new TreeNode(3)), new TreeNode(0)));
        System.out.println(serialize(rootNode));
    }

    // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        if (root != null) {
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);

            while (! queue.isEmpty()) {
                int levelSize = queue.size();

                for (int i = 0; i < levelSize; i++) {
                    TreeNode node = queue.poll();

                    if (node == null) {
                        sb.append("NULL,");
                    } else {
                        sb.append(node.val);
                        sb.append(",");
                        queue.offer(node.left);
                        queue.offer(node.right);
                    }
                }
            }
            sb.deleteCharAt(sb.length() - 1);
        }

        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        TreeNode rootNode = null;
        if (! data.isEmpty()) {
            int index = 0;
            String[] nodes = data.split(",");
            rootNode = new TreeNode(Integer.parseInt(nodes[index++]));
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(rootNode);

            while (! queue.isEmpty()) {
                TreeNode node = queue.poll();
                if (! nodes[index].equals("NULL")) {
                    node.left = new TreeNode(Integer.parseInt(nodes[index]));
                    queue.offer(node.left);
                }
                index++;

                if (! nodes[index].equals("NULL")) {
                    node.right = new TreeNode(Integer.parseInt(nodes[index]));
                    queue.offer(node.right);
                }
                index++;
            }
        }
        return rootNode;
    }
    static class TreeNode {
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
