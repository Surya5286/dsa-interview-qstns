package coding_problems.trees;

import java.util.*;

class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;
    TreeNode(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

public class ZigZagLevelOrderTraversal {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        List<List<Integer>> result = printZigZagLevelOrderTraversalOrder(root);
        System.out.println("ZigZag Level Order Traversal :- " + result);
    }

    private static List<List<Integer>> printZigZagLevelOrderTraversalOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();

        if (root == null)
            return result;

        // In Java, ArrayDeque is generally faster for queues, hence we are not opting for LinkedList
        // Queue<TreeNode> queue = new LinkedList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        boolean isLeftToRight = true;

        while (!queue.isEmpty()) {
            int size = queue.size();
            int[] level = new int[size];

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                if (node.left != null)
                    queue.add(node.left);

                if (node.right != null)
                    queue.add(node.right);

                int index = isLeftToRight ? i : size-i-1;
                level[index] = node.data;
            }

            isLeftToRight = !isLeftToRight;
            result.add(Arrays.stream(level).boxed().toList());
        }

        return result;
    }
}