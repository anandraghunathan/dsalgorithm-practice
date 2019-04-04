package com.leetcode.tree;

public class MergeTwoBinaryTrees {
    // T1 - [1,3,2,5]
    //  T2 - [2,1,3,null,4,null,7]
    public static TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if(t1 == null)
            return t2;

        if(t2 == null)
            return t1;

        t1.val += t2.val;
        t1.left = mergeTrees(t1.left, t2.left);
        t1.right = mergeTrees(t1.right, t2.right);
        return t1;
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        t1.left = new TreeNode(3);
        t1.right = new TreeNode(2);
        t1.left.left = new TreeNode(5);

        TreeNode t2 = new TreeNode(2);
        t2.left = new TreeNode(1);
        t2.right = new TreeNode(3);
        t2.left.right = new TreeNode(4);
        t2.right.right = new TreeNode(7);

        TreeNode result = mergeTrees(t1, t2);


        System.out.print(result != null ? result.val + ", " : null + " , ");
        System.out.print(result.left != null ? result.left.val + ", " : null + ", ");
        System.out.print(result.right != null ? result.right.val + ", " : null + ", ");
        System.out.print(result.left.left != null ? result.left.left.val + ", "  : null + ", ");
        System.out.print(result.left.right != null ? result.left.right.val + ", " : null + ", ");
        System.out.print(result.right.left != null ? result.right.left.val + ", " : null + ", ");
        System.out.print(result.right.right != null ? result.right.right.val + " " : null + " ");
    }
}


