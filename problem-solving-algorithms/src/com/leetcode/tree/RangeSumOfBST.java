package com.leetcode.tree;

import java.util.Stack;

/**
 * https://leetcode.com/problems/range-sum-of-bst/
 */
public class RangeSumOfBST {
    static int sum;

    public static int rangeSumBST_recurive(TreeNode root, int L, int R) {
        sum = 0;
        sumBST(root, L, R);
        return sum;
    }

    /*
          10
         /  \
        5    15
       / \     \
      3   7     18

     */
    public static void sumBST(TreeNode node, int L, int R) {
        if (node != null) {
            if (L <= node.val && node.val <= R)
                sum += node.val;
            if (L < node.val)
                sumBST(node.left, L, R);
            if (node.val < R)
                sumBST(node.right, L, R);
        }
    }


    /*
          10
         /  \
        5    15
       / \     \
      3   7     18

     */
    public static int rangeSumBST_iterative(TreeNode root, int L, int R) {
        Stack<TreeNode> stack = new Stack();
        stack.push(root);

        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if(node != null) {
                if(node.val >= L && node.val <= R)
                    sum += node.val;

                if(node.val >= L)
                    stack.push(node.left);

                if(node.val <= R)
                    stack.push(node.right);
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(10);
        t1.left = new TreeNode(5);
        t1.right = new TreeNode(15);
        t1.left.left = new TreeNode(3);
        t1.left.right = new TreeNode(7);
        t1.right.right = new TreeNode(18);


        System.out.print(t1 != null ? t1.val + ", " : null + " , ");

        System.out.print(t1.left != null ? t1.left.val + ", " : null + ", ");

        System.out.print(t1.right != null ? t1.right.val + ", " : null + ", ");

        System.out.print(t1.left.left != null ? t1.left.left.val + ", "  : null + ", ");

        System.out.print(t1.left.right != null ? t1.left.right.val + ", "  : null + ", ");

        System.out.print(t1.right.left != null ? t1.right.left.val + ", "  : null + ", ");

        System.out.print(t1.right.right != null ? t1.right.right.val + ", "  : null + ", ");

        System.out.print("\n");

        System.out.println("Sum : " +rangeSumBST_recurive(t1, 7, 15));

        //System.out.println("Sum : " +rangeSumBST_iterative(t1, 7, 15));
    }
}
