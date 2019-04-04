package com.leetcode.tree;

public class LowestCommonAncestor {

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
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
        t1.left = new TreeNode(3);
        t1.right = new TreeNode(2);
        t1.left.right = new TreeNode(4);
        t1.left.left = new TreeNode(5);

        //lowestCommonAncestor(t1, 4, 5);
    }
}
