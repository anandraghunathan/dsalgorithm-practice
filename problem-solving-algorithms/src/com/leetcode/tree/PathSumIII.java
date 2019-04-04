package com.leetcode.tree;

public class PathSumIII {
    /**
     *       10
     *      /  \
     *     5   -3
     *    / \    \
     *   3   2   11
     *  / \   \
     * 3  -2   1
     *
     */
    public static int pathSum(TreeNode root, int sum) {

        if(root == null)
            return 0;
        return pathSumFrom(root, sum)
                + pathSum(root.left, sum)
                + pathSum(root.right, sum);
    }

    private static int pathSumFrom(TreeNode node, int sum) {
        if (node == null)
            return 0;
        return (node.val == sum ? 1 : 0)
                + pathSumFrom(node.left, sum - node.val)
                + pathSumFrom(node.right, sum - node.val);
    }

    /**
     *       10
     *      /  \
     *     5   -3
     *    / \    \
     *   3   2   11
     *  / \   \
     * 3  -2   1
     *
     */
    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(10);
        t1.left = new TreeNode(5);
        t1.right = new TreeNode(-3);
        t1.left.left = new TreeNode(3);
        t1.left.right = new TreeNode(2);
        t1.right.right = new TreeNode(11);
        t1.left.left.left = new TreeNode(3);
        t1.left.left.right = new TreeNode(-2);
        t1.left.right.right = new TreeNode(1);

        System.out.print(t1 != null ? t1.val + ", " : null + " , ");

        System.out.print(t1.left != null ? t1.left.val + ", " : null + ", ");

        System.out.print(t1.right != null ? t1.right.val + ", " : null + ", ");

        System.out.print(t1.left.left != null ? t1.left.left.val + ", "  : null + ", ");

        System.out.print(t1.left.right != null ? t1.left.right.val + ", "  : null + ", ");

        System.out.print(t1.left.right.left != null ? t1.left.right.left.val + ", "  : null + ", ");

        System.out.print(t1.right.right != null ? t1.right.right.val + ", "  : null + ", ");

        System.out.print(t1.left.left.left != null ? t1.left.left.left.val + ", "  : null + ", ");

        System.out.print(t1.left.left.right != null ? t1.left.left.right.val + ", "  : null);

        System.out.print(t1.right.left != null ? t1.right.left.val + ", "  : null + ", ");

        System.out.print(t1.left.right.right != null ? t1.left.right.right.val + ", "  : null + ", ");

        System.out.println("");
        System.out.println(pathSum(t1, 8));
    }
}
