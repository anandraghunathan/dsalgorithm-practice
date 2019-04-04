package com.leetcode.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInOrderTraversalIterative {
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack();
        TreeNode curr = root;

        while(curr != null || !stack.isEmpty()) {
            while(curr != null) {
                stack.push(curr);
                curr = curr.left;
            }

            curr = stack.pop();
            res.add(curr.val);
            curr = curr.right;
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(4);
        treeNode.left.left = new TreeNode(5);
        treeNode.right = new TreeNode(2);
        treeNode.right.left = new TreeNode(3);
        List<Integer> res = inorderTraversal(treeNode);
        System.out.print("In Order Traversal Iterative Approach : ");
        for(Integer val: res) {
            System.out.print(val +" ");
        }
    }
}
