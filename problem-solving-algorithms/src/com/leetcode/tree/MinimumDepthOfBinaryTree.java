package com.leetcode.tree;

public class MinimumDepthOfBinaryTree {
    public static int minDepth(TreeNode root) {
        if(root == null)
            return 0;
        if(root.left != null && root.right != null)
            return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
        else
            return Math.max(minDepth(root.left), minDepth(root.right)) + 1;
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(3);
        t1.left = new TreeNode(9);
        t1.right = new TreeNode(20);
        t1.right.left = new TreeNode(15);
        t1.right.right = new TreeNode(7);

//        System.out.print(t1 != null ? t1.val + ", " : null + " , ");
//
//        System.out.print(t1.left != null ? t1.left.val + ", " : null + ", ");
//
//        System.out.print(t1.right != null ? t1.right.val + ", " : null + ", ");
//
//        System.out.print(t1.right.left != null ? t1.right.left.val + ", "  : null + ", ");
//
//        System.out.print(t1.right.right != null ? t1.right.right.val + ", "  : null + ", ");

        System.out.println(minDepth(t1));
    }
}
