package com.leetcode.tree;

public class LowestCommonAncestorBinaryTree {
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null)
            return null;

        if(root == p || root == q) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if(left == null)
            return right;
        else if(right == null)
            return left;
        else
            return root;
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        t1.left = new TreeNode(3);
        t1.right = new TreeNode(2);
        t1.left.right = new TreeNode(4);
        t1.left.left = new TreeNode(5);

        // first input node
        TreeNode p = new TreeNode(4);

        // second input node
        TreeNode q = new TreeNode(5);


        System.out.println(lowestCommonAncestor(t1, p, q));
    }
}
