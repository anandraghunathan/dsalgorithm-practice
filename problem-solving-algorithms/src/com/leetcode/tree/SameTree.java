package com.leetcode.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class SameTree {

    /**
     * Recursive approach
     */
    public static boolean isSameTreeR(TreeNode p, TreeNode q) {
        if(p == null && q == null)
            return true;

        if(p == null || q == null)
            return false;

        if(p.val != q.val)
            return false;

        return isSameTreeR(p.left, q.left) && isSameTreeR(p.right, q.right);
    }

    /**
     * Iterative Stack approach
     */
    public static boolean isSameTreeIS(TreeNode p, TreeNode q) {

        Stack<TreeNode> stackP = new Stack();
        Stack<TreeNode> stackQ = new Stack();

        stackP.push(p);
        stackQ.push(q);

        while(!stackP.isEmpty() || !stackQ.isEmpty()) {
            TreeNode rootP = stackP.pop();
            TreeNode rootQ = stackQ.pop();

            if(rootP == null && rootQ == null) {
                continue;
            } else if((rootP == null || rootQ == null) || (rootP.val != rootQ.val)) {
                return false;
            }

            if(rootP.right != null)
                stackP.push(rootP.right);
            if(rootQ.right != null)
                stackQ.push(rootQ.right);
            if(stackP.size() != stackQ.size())
                return false;

            if(rootP.left != null)
                stackP.push(rootP.left);
            if(rootQ.left != null)
                stackQ.push(rootQ.left);
            if(stackP.size() != stackQ.size())
                return false;
        }
        return true;
    }

    public static boolean isSameTreeIQ(TreeNode p, TreeNode q) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(p);
        queue.offer(q);

        while(!queue.isEmpty()) {
            TreeNode rootP = queue.poll();
            TreeNode rootQ = queue.poll();

            if(rootP == null && rootQ == null) {
                continue;
            } else if((rootP == null || rootQ == null) || (rootP.val != rootQ.val)) {
                return false;
            } else {
                queue.offer(rootP.left);
                queue.offer(rootQ.left);
                queue.offer(rootP.right);
                queue.offer(rootQ.right);
            }
        }
        return true;
    }
    public static void main(String[] args) {
        TreeNode p = new TreeNode(1);
        p.left = new TreeNode(2);

        TreeNode q = new TreeNode(1);
        q.right = new TreeNode(2);

        //System.out.println(isSameTreeR(p, q));
        System.out.println(isSameTreeIS(p, q));
        //System.out.println(isSameTreeIQ(p, q));
    }
}
