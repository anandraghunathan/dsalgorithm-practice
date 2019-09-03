package com.leetcode.tree;

public class LongestUnivaluePath {
    int res = 0;
    public int longestUnivaluePath(TreeNode root) {
        longestUnivaluePathHelper(root, root.val);
        return res;
    }

    public int longestUnivaluePathHelper(TreeNode root, int currVal) {
        if(root == null)
            return 0;

        int left = longestUnivaluePathHelper(root.left, root.val);
        int right = longestUnivaluePathHelper(root.right, root.val);

        res = Math.max(res, left + right);
        if(root.val == currVal)
            return Math.max(left, right) + 1;
        return 0;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(5);
        treeNode.left = new TreeNode(1);
        treeNode.right = new TreeNode(5);
        treeNode.left.left = new TreeNode(1);
        treeNode.left.right = new TreeNode(1);
        //treeNode.right.left = new TreeNode(15);
        treeNode.right.right = new TreeNode(5);
        LongestUnivaluePath obj = new LongestUnivaluePath();
        System.out.println(obj.longestUnivaluePath(treeNode));
    }
}
