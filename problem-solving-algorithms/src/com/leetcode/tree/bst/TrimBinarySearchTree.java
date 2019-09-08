package com.leetcode.tree.bst;

import com.leetcode.tree.*;

public class TrimBinarySearchTree {
    /**
         https://leetcode.com/problems/trim-a-binary-search-tree/

         Intuition:
         Do a pre-order traversal and make a decision at each step based on the current node's val
         whether its higher or lower than the boundaries given

         Time Complexity: O(N), where N is the total number of nodes in the given tree. We visit each
         node at most once.

         Space Complexity: O(N). Even though we don't explicitly use any additional memory, the call
         stack of our recursion could be as large as the number of nodes in the
         worst case.
     */
    public TreeNode trimBST(TreeNode root, int L, int R) {
        if(root == null)
            return null;
        /*
            If the value of this node is less than L, then the whole left subtree will be smaller,
            so we can discard the left sub tree and return the root of the trimmed right sub tree
        */
        if(root.val < L)
            return trimBST(root.right, L, R);

        /*
            If the value of this node is greater than R, then the whole right subtree will be greater
            so we can discard the right sub tree and return the root of the trimmed left sub tree
        */
        if(root.val > R)
            return trimBST(root.left, L, R);

        /*
            If the value of this node does not need to be deleted, we need to pass this recursive call
            downwards to both sides
        */
        root.left = trimBST(root.left, L, R);
        root.right = trimBST(root.right, L, R);

        // All the processing of the subtrees done, now return the trimmed root node
        return root;
    }
}
