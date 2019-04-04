package com.leetcode.tree;

public class PathSum {
    public static boolean hasPathSum(TreeNode root, int sum) {

        if(root == null)
            return false;

        if(root.left == null && root.right == null && sum - root.val == 0)
            return true;

        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }

//         1
//       /   \
//      3     2
//     / \   /  \
//    5   4 3    7

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        t1.left = new TreeNode(3);
        t1.right = new TreeNode(2);
        t1.left.right = new TreeNode(4);
        t1.left.left = new TreeNode(5);
        t1.right.left = new TreeNode(3);
        t1.right.right = new TreeNode(7);

        System.out.print(t1 != null ? t1.val + ", " : null + " , ");
        System.out.print(t1.left != null ? t1.left.val + ", " : null + ", ");
        System.out.print(t1.right != null ? t1.right.val + ", " : null + ", ");
        System.out.print(t1.left.left != null ? t1.left.left.val + ", "  : null + ", ");
        System.out.print(t1.left.right != null ? t1.left.right.val : null);

        System.out.println("");
        System.out.println(hasPathSum(t1, 13));
    }
}
