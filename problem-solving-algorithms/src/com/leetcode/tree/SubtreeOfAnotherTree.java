package com.leetcode.tree;

public class SubtreeOfAnotherTree {
    public static boolean isSubtree(TreeNode s, TreeNode t) {
        if(s == null || t == null)
            return false;

        if(isSubtreeSame(s, t)) return true;

        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    public static boolean isSubtreeSame(TreeNode s, TreeNode t) {

        if(s == null && t == null) return true;

        if(s == null || t == null) return false;

        if (s.val != t.val) return false;

        return isSubtreeSame(s.left, t.left) && isSubtreeSame(s.right, t.right);

    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(3);
        t1.left = new TreeNode(4);
        t1.right = new TreeNode(5);
        t1.left.left = new TreeNode(1);
        t1.left.right = new TreeNode(2);
        //t1.left.right.right = new TreeNode(0);

        TreeNode t2 = new TreeNode(4);
        t2.left = new TreeNode(1);
        t2.right = new TreeNode(2);

        System.out.println(isSubtree(t1, t2));
    }
}
