package com.leetcode.tree;

public class LowestCommonAncestorBinarySearchTree {

    /**
     *
     *          1
     *         / \
     *        2   3
     *       / \   \
     *      4   5   6
     */
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null)
            return null;

        int parentValue = root.val;

        int pValue = p.val;

        int qValue = q.val;

        if(pValue > parentValue && qValue > parentValue) {
            return lowestCommonAncestor(root.right, p, q);
        } else if(pValue < parentValue && qValue < parentValue) {
            return lowestCommonAncestor(root.left, p, q);
        } else {
            return root;
        }
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        t1.left = new TreeNode(2);
        t1.right = new TreeNode(3);
        t1.left.left = new TreeNode(4);
        t1.left.right = new TreeNode(5);
        t1.right.right = new TreeNode(6);

        // first input node
        TreeNode p = t1.left;

        // second input node
        TreeNode q = t1.right.right;

        System.out.println(lowestCommonAncestor(t1, p, q).val);
    }
}
