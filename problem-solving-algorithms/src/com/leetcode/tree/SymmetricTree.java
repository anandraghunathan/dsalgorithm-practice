package com.leetcode.tree;

import java.util.Stack;

public class SymmetricTree {
    /**
     * Recursive approach
     */
    public boolean isSymmetric_recursive(TreeNode root) {
        return isMirror(root, root);
    }

    boolean isMirror(TreeNode t1, TreeNode t2) {
        if(t1 == null && t2 == null) return true;
        if(t1 == null || t2 == null) return false;

        return t1.val == t2.val && isMirror(t1.left, t2.right) && isMirror(t1.right, t2.left);
    }

    /**
     * Iterative approach
     */
    public boolean isSymmetric_iterative(TreeNode root) {
        if(root == null) return true;
        Stack<TreeNode> stack = new Stack();
        stack.push(root.left);
        stack.push(root.right);
        while(!stack.isEmpty()) {
            TreeNode right = stack.pop();
            TreeNode left = stack.pop();

            if(left == null && right == null) continue;
            if(left == null || right == null || left.val != right.val) return false;
            stack.push(left.right);
            stack.push(right.left);
            stack.push(left.left);
            stack.push(right.right);
        }
        return true;
    }
}
