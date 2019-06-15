package com.leetcode.tree;

import java.util.Stack;

// In-order traversal
// https://leetcode.com/problems/minimum-distance-between-bst-nodes/
public class MinimumDistanceBetweenBSTNodes {
    static Integer minDistance = Integer.MAX_VALUE;
    static TreeNode prev = null;

    public static int minDiffInBSTIterative(TreeNode root) {
        Stack<TreeNode> stack = new Stack();
        TreeNode node = root;
        TreeNode prev = null;
        Integer minDistance = Integer.MAX_VALUE;

        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            if (prev != null)
                minDistance = Math.min(minDistance, (node.val - prev.val));
            prev = node;
            node = node.right;
        }
        return minDistance;
    }

    public static int minDiffInBSTRecursive(TreeNode root) {
        if(root != null) {
            if(root.left != null) {
                minDiffInBSTRecursive(root.left);
            }

            if(prev != null) {
                minDistance = Math.min((root.val - prev.val), minDistance);
            }
            prev = root;

            if(root.right != null) {
                minDiffInBSTRecursive(root.right);
            }
        }
        return minDistance;
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(4);
        t1.left = new TreeNode(2);
        t1.right = new TreeNode(6);
        t1.left.left = new TreeNode(1);
        t1.left.right = new TreeNode(3);

        //System.out.println(minDiffInBSTIterative(t1));
        System.out.println(minDiffInBSTRecursive(t1));
    }
}
