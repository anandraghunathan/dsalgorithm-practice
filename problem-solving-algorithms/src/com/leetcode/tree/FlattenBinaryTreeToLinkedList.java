package com.leetcode.tree;

/**
 * Created by Anand Raghunathan on 2019-07-22
 *
 * https://leetcode.com/problems/flatten-binary-tree-to-linked-list
 *
 */
public class FlattenBinaryTreeToLinkedList {
    /*
        Prev node that will point to flattened list from bottom to the top.
        From node 6 to 1. Like 5 -> 6, then 4 -> 5 -> 6 etc
    */
    private static TreeNode prev = null;

    /**
     *  We will traverse the tree from right first, visit each right node,
     *  then traverse the left node, visit each left node and point to the root's right
     *  node to the prev node that will have the flattened tree
     */
    public static void flatten(TreeNode root) {
        if(root == null)
            return;

        // Recursively call the root right nodes to flatten from right to left
        flatten(root.right);

        // Recursively call the root left nodes to flatten it after completing the root's right
        flatten(root.left);

        /*
            Point the root's right to the prev (formed recursively like
            6, 5 -> 6, then, 4 -> 5 -> 6 etc)
        */
        root.right = prev;

        // Make the root's left as null as the tree will be flattened to a list
        root.left = null;

        /*
            Finally, point the prev to the current root that will be flattened as
            for ex: 4 -> 5 - > 6 will become the current root that's flattened so far
        */
        prev = root;
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        t1.left = new TreeNode(2);
        t1.right = new TreeNode(5);
        t1.left.left = new TreeNode(3);
        t1.left.right = new TreeNode(4);
        t1.right.right = new TreeNode(6);

        System.out.print("Before Tree Flattening - ");

        System.out.print(t1 != null ? t1.val + ", " : null + " , ");

        System.out.print(t1.left != null ? t1.left.val + ", " : null + ", ");

        System.out.print(t1.right != null ? t1.right.val + ", " : null + ", ");

        System.out.print(t1.left.left != null ? t1.left.left.val + ", " : null + ", ");

        System.out.print(t1.left.right != null ? t1.left.right.val + ", " : null + ", ");

        System.out.print(t1.right.right != null ? t1.right.right.val + ", " : null + ", ");

        flatten(t1);

        System.out.print("After Tree Flattening - ");

        System.out.print(t1 != null ? t1.val + ", " : null + " , ");

        System.out.print(t1.right != null ? t1.right.val + ", " : null + ", ");

        System.out.print(t1.right.right != null ? t1.right.right.val + ", " : null + ", ");

        System.out.print(t1.right.right.right != null ? t1.right.right.right.val + ", " : null + ", ");

        System.out.print(t1.right.right.right.right != null ? t1.right.right.right.right.val + ", " : null + ", ");

        System.out.print(t1.right.right.right.right.right != null ? t1.right.right.right.right.right.val + ", " : null + ", ");
    }
}
