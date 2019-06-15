package com.leetcode.tree;

import java.util.LinkedList;
import java.util.Queue;

public class InvertBinaryTree {

    /**
     *
     * Space and time - O(n)
     *
     */
    public static TreeNode invertTreeRecursive(TreeNode root) {
        if(root == null)
            return null;

        TreeNode left = invertTreeRecursive(root.left);
        TreeNode right = invertTreeRecursive(root.right);

        root.left = right;
        root.right = left;

        return root;
    }

    /**
     *
     * Space and time - O(n)
     *
     */
    public static TreeNode invertTreeIterative(TreeNode root) {
        if (root == null) return null;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()) {
            TreeNode current = queue.poll();
            TreeNode temp = current.left;
            current.left = current.right;
            current.right = temp;

            if(current.left != null) queue.add(current.left);
            if(current.right != null) queue.add(current.right);
        }
        return root;
    }


    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(4);
        t1.left = new TreeNode(2);
        t1.right = new TreeNode(7);
        t1.left.left = new TreeNode(1);
        t1.left.right = new TreeNode(3);
        t1.right.left = new TreeNode(6);
        t1.right.right = new TreeNode(9);

        System.out.print("Before Tree Inversion - ");

        System.out.print(t1 != null ? t1.val + ", " : null + " , ");

        System.out.print(t1.left != null ? t1.left.val + ", " : null + ", ");

        System.out.print(t1.right != null ? t1.right.val + ", " : null + ", ");

        System.out.print(t1.left.left != null ? t1.left.left.val + ", "  : null + ", ");

        System.out.print(t1.left.right != null ? t1.left.right.val + ", "  : null + ", ");

        System.out.print(t1.right.left != null ? t1.right.left.val + ", "  : null + ", ");

        System.out.print(t1.right.right != null ? t1.right.right.val + ", "  : null + ", ");

        System.out.print("\n");

        invertTreeRecursive(t1);

        //invertTreeIterative(t1);

        System.out.print("After Tree Inversion - ");

        System.out.print(t1 != null ? t1.val + ", " : null + " , ");

        System.out.print(t1.left != null ? t1.left.val + ", " : null + ", ");

        System.out.print(t1.right != null ? t1.right.val + ", " : null + ", ");

        System.out.print(t1.left.left != null ? t1.left.left.val + ", "  : null + ", ");

        System.out.print(t1.left.right != null ? t1.left.right.val + ", "  : null + ", ");

        System.out.print(t1.right.left != null ? t1.right.left.val + ", "  : null + ", ");

        System.out.print(t1.right.right != null ? t1.right.right.val + ", "  : null + ", ");

        System.out.print("\n");
    }
}
