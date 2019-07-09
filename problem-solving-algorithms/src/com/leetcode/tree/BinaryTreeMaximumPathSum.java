package com.leetcode.tree;

import java.util.List;

public class BinaryTreeMaximumPathSum {
    static int maxValue;

    public static int maxPathSum(TreeNode root) {
        // To handle negative input node with only one node like [-3], in this case we should -3 as max path sum and not 0.
        maxValue = Integer.MIN_VALUE;
        maxPathDown(root);
        return maxValue;
    }

    private static int maxPathDown(TreeNode node) {
        if (node == null) return 0;

        // Calculate left and right recursively. When there is a negative, it wont be considered cause max will then be 0
        int left = Math.max(0, maxPathDown(node.left));
        int right = Math.max(0, maxPathDown(node.right));

        // Negative numbers won't be considered as it reduces the maxValue
        maxValue = Math.max(maxValue, left + right + node.val);
        return Math.max(left, right) + node.val;
    }

    /**
     *
     *    -10
     *    / \
     *   9  20
     *     /  \
     *    15   7
     *
     */
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(-10);
        treeNode.left = new TreeNode(9);
        treeNode.right = new TreeNode(20);
        treeNode.right.left = new TreeNode(15);
        treeNode.right.right = new TreeNode(7);
        System.out.print("Max: " + maxPathSum(treeNode));
    }
}
