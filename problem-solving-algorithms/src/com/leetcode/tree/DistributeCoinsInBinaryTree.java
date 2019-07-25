package com.leetcode.tree;

public class DistributeCoinsInBinaryTree {
    static int ans;
    public static int distributeCoins(TreeNode root) {
        ans = 0;
        dfs(root);
        return ans;
    }

    public static int dfs(TreeNode node) {
        if (node == null)
            return 0;
        int left = dfs(node.left);
        int right = dfs(node.right);
        ans += Math.abs(left) + Math.abs(right);
        return node.val + left + right - 1;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(0);
        treeNode.left = new TreeNode(3);
        treeNode.right = new TreeNode(0);
        System.out.println(distributeCoins(treeNode));
    }
}
