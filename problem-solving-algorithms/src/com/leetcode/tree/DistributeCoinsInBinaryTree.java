package com.leetcode.tree;

/**
 * https://leetcode.com/problems/distribute-coins-in-binary-tree
 *
 *  Time Complexity: O(N), where N is the number of nodes in the tree.
 *
 *  Space Complexity: O(H), where H is the height of the tree.
 *
 */
public class DistributeCoinsInBinaryTree {
    /**
     dfs(node) determines the excess coins in the subtree or below this current node.
     dfs(node) = number of coins in the subtree - number of nodes in the subtree.

     Therefore, the number of moves we make from this current node (making dfs) to and from
     its children is abs(dfs(node.left)) + abs(dfs(node.right))

     After, we have an excess of node.val + dfs(node.left) + dfs(node.right) - 1 coins
     at this node.
     */
    static int ans;
    public static int distributeCoins(TreeNode root) {
        dfs(root);
        return ans;
    }

    public static int dfs(TreeNode root) {
        if(root == null)
            return 0;

        // Find the excess coins present in the left subtree of the root node
        int left = dfs(root.left);

        // Find the excess coins presrnt in the right subtree of the root node
        int right = dfs(root.right);

        // The number of moves we make from the current node to and from its children
        ans += Math.abs(left) + Math.abs(right);

        // Excess coins available after deducting one coin for the current node
        return root.val + left + right - 1;
    }

        /**
            Sample 1

               3
              / \
             1   1
            /     \
           0      0

           Sample 2
              0
             / \
            3   0
         */
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(0);
        treeNode.left = new TreeNode(3);
        treeNode.right = new TreeNode(0);
        System.out.println(distributeCoins(treeNode));
    }
}