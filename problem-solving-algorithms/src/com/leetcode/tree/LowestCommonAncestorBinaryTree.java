package com.leetcode.tree;

/**
 *
 *          1
 *         / \
 *        2   3
 *       / \   \
 *      4   5   6
 */
public class LowestCommonAncestorBinaryTree {
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q) {
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
        t1.left = new TreeNode(2);
        t1.right = new TreeNode(3);
        t1.left.left = new TreeNode(4);
        t1.left.right = new TreeNode(5);
        t1.right.right = new TreeNode(6);

        // first input node
        TreeNode p = t1.left.left;

        // second input node
        TreeNode q = t1.left.right;


        System.out.println(lowestCommonAncestor(t1, p, q).val);
    }
}
