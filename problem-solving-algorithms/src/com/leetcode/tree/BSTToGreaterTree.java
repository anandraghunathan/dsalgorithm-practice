package com.leetcode.tree;

import java.util.Stack;

public class BSTToGreaterTree {
    int sum = 0;
    public TreeNode convertBSTR(TreeNode root) {
        if(root != null) {
            convertBSTR(root.right);
            sum = sum + root.val;
            root.val = sum;
            convertBSTR(root.left);
        }
        return root;
    }

    public TreeNode convertBSTI(TreeNode root) {
        int sum = 0;
        Stack<TreeNode> stack = new Stack();
        TreeNode node = root;

        while(!stack.isEmpty() || node != null) {
            while(node != null) {
                stack.push(node);
                node = node.right;
            }

            node = stack.pop();
            sum = sum + node.val;
            node.val = sum;
            node = node.left;
        }
        return root;
    }

    public static void main(String[] args) {
        //Todo
    }
}
