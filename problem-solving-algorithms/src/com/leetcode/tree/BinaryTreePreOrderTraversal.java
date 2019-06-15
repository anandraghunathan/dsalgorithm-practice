package com.leetcode.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class BinaryTreePreOrderTraversal {
    /**
     *
     * Time and space o(h) - h is the height of the tree
     */
    public static List<Integer> preorderTraversalIterative(TreeNode root) {
        if(root == null)
            return Collections.emptyList();
        List<Integer> vals = new ArrayList();
        Stack<TreeNode> stack = new Stack();
        stack.push(root);

        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            vals.add(node.val);

            if(node.right != null) {
                stack.push(node.right);
            }

            if(node.left != null) {
                stack.push(node.left);
            }
        }
        return vals;
    }

    public static List<Integer> preorderTraversalRecursive(TreeNode root) {
        List<Integer> vals = new ArrayList();
        preOrderHelper(root, vals);
        return vals;
    }

    static void preOrderHelper(TreeNode node, List<Integer> vals) {
        if(node != null) {
            vals.add(node.val);

            if(node.left != null) {
                preOrderHelper(node.left, vals);
            }

            if (node.left != null) {
                preOrderHelper(node.right, vals);
            }
        }
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(6);
        treeNode.left = new TreeNode(5);
        treeNode.left.left = new TreeNode(4);
        treeNode.right = new TreeNode(7);
        treeNode.right.left = new TreeNode(15);
        treeNode.right.right = new TreeNode(20);
        System.out.println(preorderTraversalIterative(treeNode));
        System.out.println(preorderTraversalRecursive(treeNode));
    }
}
