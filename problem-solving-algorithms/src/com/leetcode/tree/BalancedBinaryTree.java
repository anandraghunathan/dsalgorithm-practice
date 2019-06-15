package com.leetcode.tree;

public class BalancedBinaryTree {
    public static boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        return Math.abs(left - right) <= 1;

    }

//              3
//             / \
//             9  20
//               /  \
//              15   7

    public static int maxDepth(TreeNode node) {
        if(node == null)
            return 0;

        return Math.max(maxDepth(node.left), maxDepth(node.right)) + 1;
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

        System.out.println(isBalanced(t1));
    }
}
