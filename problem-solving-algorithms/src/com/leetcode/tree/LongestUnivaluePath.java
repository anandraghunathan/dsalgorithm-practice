package com.leetcode.tree;

/**
 * https://leetcode.com/problems/longest-univalue-path
 *
 * Intuition: We can do a in-order traversal to find the left and right sub-nodes and only increment the res counter
 * only when the current root val is equal to the prev root val.
 *
 */
public class LongestUnivaluePath {
    int res;
    // return the longest length up to root
    public int longestUnivaluePath(TreeNode root) {
        longestUnivaluePathHelper(root, root.val);
        return res;
    }

    // this recursion
    // 1.--> you must include this node
    // 2.--> you ONLY increment IF prevValue equals to this node's value
    public int longestUnivaluePathHelper(TreeNode currNode, int currNodeRootVal) {
        if(currNode == null)
            return 0;

        // Pass the current currNode val that will become the currNodeRootVal during the recursion
        int left = longestUnivaluePathHelper(currNode.left, currNode.val);
        int right = longestUnivaluePathHelper(currNode.right, currNode.val);

        /*
            Check if the current left + right is greater than the res we have as of right now in the current sub-tree

            left + right is the length of a path that goes from left subtree and through the current currNode to its
            right subtree. Like this / \ And from current currNode, we only return the longer branch between left and right.
         */
        res = Math.max(res, left + right);

        // ONLY increment the count IF the node.val is EQUAL TO its currNode val (currNodeRootVal)
        if(currNode.val == currNodeRootVal)
            /*
                If the rootVal and currNodeRootVal are the same, it means we found a path with nodes having the same value.
                The longer path could be either be on the left or right, so we pick the longer one among the two and
                add the current currNode node to it, so + 1
             */

            return Math.max(left, right) + 1;
        return 0; // If no subtree with nodes having the same value, then we simply return 0
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
