package com.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {
    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> vals = new ArrayList();
        binaryTreePaths(root, "", vals);
        return vals;
    }

    public static void binaryTreePaths(TreeNode root, String path, List<String> vals) {
        if(root.left == null && root.right == null) {
            vals.add(path + root.val);
        }

        if(root.left != null)
            binaryTreePaths(root.left, path + root.val + "->", vals);

        if(root.right != null)
            binaryTreePaths(root.right, path + root.val + "->", vals);
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        treeNode.left.right = new TreeNode(5);
        System.out.println(binaryTreePaths(treeNode));

//        System.out.print(treeNode != null ? treeNode.val + ", " : null + " , ");
//
//        System.out.print(treeNode.left != null ? treeNode.left.val + ", " : null + ", ");
//
//        System.out.print(treeNode.right != null ? treeNode.right.val + ", " : null + ", ");
//
//        System.out.print(treeNode.left.right != null ? treeNode.left.right.val + ", " : null + ", ");
    }
}
