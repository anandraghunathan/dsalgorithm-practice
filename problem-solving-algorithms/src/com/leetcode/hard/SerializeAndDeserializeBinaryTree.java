package com.leetcode.hard;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SerializeAndDeserializeBinaryTree {

    private static final String delimiter = ",";
    private static final String nullNode = "X";

    /**
     * Serializing -
     *          Print the tree in pre-order traversal and use "X" to denote null node and deimiter node with ",".
     *          We can use a StringBuilder for building the string on the fly.
     *
     * De-serializing -
     *          We use a Queue to store the pre-order traversal and since we have "X" as null node, we know exactly
     *          how to where to end building sub-tress.
     *
     */
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        buildString(root, sb);
        return sb.toString();
    }

    private void buildString(TreeNode root, StringBuilder sb) {
        if(root == null)
            sb.append(nullNode).append(delimiter);
        else  {
            // Append the current val with the delimiter
            sb.append(root.val).append(delimiter);

            // Pre-order traversal, call left and right recursively
            buildString(root.left, sb);
            buildString(root.right, sb);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> queue = new LinkedList();
        queue.addAll(Arrays.asList(data.split(delimiter)));
        return buildTree(queue);
    }

    private TreeNode buildTree(Queue<String> queue) {
        // Poll the first element in the queue, subsequently the next and so on..
        String val = queue.poll();

        // The end condition for building the tree, if the val equals "X", we return null node for the current recursion
        if(val.equals(nullNode))
            return null;

        // Form the tree using pre-order traversal
        TreeNode root = new TreeNode(Integer.valueOf(val));
        root.left = buildTree(queue);
        root.right = buildTree(queue);
        return root;
    }

    public static void main(String[] args) {
        SerializeAndDeserializeBinaryTree sd = new SerializeAndDeserializeBinaryTree();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        // Method call
        sd.deserialize(sd.serialize(root));

        System.out.print("[");

        System.out.print(root != null ? root.val + ", " : null + " , ");

        System.out.print(root.left != null ? root.left.val + ", " : null + ", ");

        System.out.print(root.right != null ? root.right.val + ", " : null + ", ");

        System.out.print(root.left.left != null ? root.left.left.val + ", "  : null + ", ");

        System.out.print(root.left.right != null ? root.left.right.val + ", "  : null + ", ");

        System.out.print(root.right.left != null ? root.right.left.val + ", "  : null + ", ");

        System.out.print(root.right.right != null ? root.right.right.val : null);

        System.out.println("]");
    }
}
