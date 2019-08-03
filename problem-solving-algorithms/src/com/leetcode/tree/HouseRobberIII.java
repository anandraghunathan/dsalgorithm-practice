package com.leetcode.tree;

/**
 *   https://leetcode.com/problems/house-robber-iii
 *
 *   Time  : O(N) - We traverse the entire tree to compute the max amount that can be robbed
 *   Space : O(H) - Height of the tree
 */
public class HouseRobberIII {
    public static int rob(TreeNode root) {
        int[] res = robSub(root);
        return Math.max(res[0], res[1]);
    }

    /**
     *  Each tree root has two scenarios, as indicated by the array of two elements returned by the method,
     *      1. The max amount of money that can be robbed if the root is not robbed (first element of the array)
     *      2. The max amount of money that can be robbed if the root is robbed (second element of the array)
     *
     */
    private static int[] robSub(TreeNode root) {
        if (root == null)
            return new int[2]; // return an empty array of two elements when the current root is null

        // If the root is not robbed, we can rob the left and right subtrees
        int[] left = robSub(root.left);
        int[] right = robSub(root.right);

        /*
            The res array with two elements,
                one denoting the max amount that can be robbed with root not robbed,
                second denoting the max amount that can be robbed with root robbed
         */
        int[] res = new int[2];

        /**
         * For the 1st element of rob(root), we only need to sum up the larger elements of
         * rob(root.left) and rob(root.right), respectively, since root is not robbed
         * and we are free to rob its left and right subtrees.
         */
        res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);

        /**
         *  For the 2nd element of rob(root), however, we only need to add up the 1st elements of
         *  rob(root.left) and rob(root.right) (that denote the 3rd level in the tree plus the first level value),
         *  respectively, plus the value robbed from root itself, since in this case it's guaranteed that we cannot
         *  rob the nodes of root.left and root.right
         *
         *  In other words, rob the first level, skip the next level to root cause it can't be robbed, rob the third level
         */
        res[1] = root.val + left[0] + right[0];

        return res;
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(3);
        t1.left = new TreeNode(4);
        t1.right = new TreeNode(5);
        t1.left.left = new TreeNode(1);
        t1.left.right = new TreeNode(3);
        t1.right.right = new TreeNode(1);

        System.out.print("Before Robbing and without alerting the police - ");

        System.out.print(t1 != null ? t1.val + ", " : null + " , ");

        System.out.print(t1.left != null ? t1.left.val + ", " : null + ", ");

        System.out.print(t1.right != null ? t1.right.val + ", " : null + ", ");

        System.out.print(t1.left.right != null ? t1.left.right.val + ", "  : null + ", ");

        System.out.print(t1.right.right != null ? t1.right.right.val + ", "  : null + ", ");

        System.out.print("\n");

        System.out.print("Max amount robbed without alerting the police  - " +rob(t1));

        System.out.print("\n");
    }
}
