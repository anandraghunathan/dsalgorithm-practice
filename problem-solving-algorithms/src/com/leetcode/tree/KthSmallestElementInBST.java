package com.leetcode.tree;

import java.util.Stack;

public class KthSmallestElementInBST {

    int count = 0;
    int number = 0;

    // Iterative approach using inorder traversal

    // Time: O(n)
    // Space: O(n)
    public int kthSmallestI(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack();
        TreeNode node = root;
        int number = 0;
        int count = 0;
        while(!stack.isEmpty() || node != null) {
            while(node != null) {
                stack.push(node);
                node = node.left;
            }
            count++;

            node = stack.pop();
            if(count == k)
                number = node.val;

            node = node.right;
        }
        return number;
    }

    // Time: O(n)
    // Space: O(n)
    public int kthSmallestR(TreeNode root, int k) {
        kthSmallestHelper(root, k);
        return number;
    }

    public void kthSmallestHelper(TreeNode root, int k) {
        if(root.left != null) {
            kthSmallestHelper(root.left, k);
        }

        count++;

        if(count == k) {
            number = root.val;
            return;
        }

        if(root.right != null) {
            kthSmallestHelper(root.right, k);
        }
    }
}
