package com.leetcode.tree;

public class ValidateBinarySearchTree {
    /**
     * Recursive approach - O(n) time and space
     */
    public static boolean isValidBST(TreeNode root) {
        return isHelper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public static boolean isHelper(TreeNode node, long lo, long hi) {
        if(node == null)
            return true;

        if(node.val <= lo || hi <= node.val)
            return false;

        return isHelper(node.left, lo, node.val) &&
                isHelper(node.right, node.val, hi);
    }

    public static void main(String[] args) {
        //isValidBST()
    }

    //TODO Iterative and In-order traversal approaches
}
