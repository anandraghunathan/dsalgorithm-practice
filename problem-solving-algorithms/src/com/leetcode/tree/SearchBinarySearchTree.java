package com.leetcode.tree;

import java.sql.SQLOutput;
import java.util.List;

public class SearchBinarySearchTree {
    public static TreeNode searchBST(TreeNode root, int val) {
        while(root != null) {
            if(root.val == val) {
                return root;
            } else if(val < root.val) {
                return searchBST(root.left, val);
            } else if(val > root.val){
                return searchBST(root.right, val);
            }
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(4);
        treeNode.left = new TreeNode(2);
        treeNode.left.left = new TreeNode(1);
        treeNode.left.right = new TreeNode(3);
        treeNode.right = new TreeNode(7);

        TreeNode res = searchBST(treeNode, 2);

        System.out.print(res.val +" ");
        System.out.print(res.left.val +" ");
        System.out.print(res.right.val +" ");
        System.out.print(res.left.left.val +" ");
        System.out.print(res.left.right.val +" ");

    }
}
