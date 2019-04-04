package com.leetcode.tree;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInOrderTraversalRecursion {
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> vals = new ArrayList<>();
        inOrderHelper(root, vals);
        return vals;
    }

    public static void inOrderHelper(TreeNode root, List<Integer> vals) {
        if(root != null) {
            if(root.left != null)
                inOrderHelper(root.left, vals);

            vals.add(root.val);


            if(root.right != null)
                inOrderHelper(root.right, vals);
        }
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(4);
        treeNode.left.left = new TreeNode(5);
        treeNode.right = new TreeNode(2);
        treeNode.right.left = new TreeNode(3);
        List<Integer> res = inorderTraversal(treeNode);
        System.out.print("In Order Traversal Recursive Approach : ");
        for(Integer val: res) {
            System.out.print(val + " ");
        }
    }
}
