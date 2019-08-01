package com.leetcode.tree;

/**
 * https://leetcode.com/problems/diameter-of-binary-tree/
 *
 * Time  : O(n)
 * Space : O(n)
 */
public class DiameterOfBinaryTree {
    static int max = 0;
    public static int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return max;
    }

    /**
     *            1
     *          /   \
     *         2     3
     *        / \     \
     *       4   5     8
     */
    public static int maxDepth(TreeNode root) {
        if(root == null)
            return 0;

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        max = Math.max(max, left + right);

        return Math.max(left, right) + 1;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        //treeNode.right.left = new TreeNode(7);
        treeNode.right.right = new TreeNode(8);
        treeNode.left.left = new TreeNode(4);
        treeNode.left.right = new TreeNode(5);
        System.out.println(diameterOfBinaryTree(treeNode));
    }
}
