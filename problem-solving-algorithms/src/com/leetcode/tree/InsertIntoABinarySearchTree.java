package com.leetcode.tree;

/**
 * Created by Anand Raghunathan on 2019-07-24
 *
 * https://leetcode.com/problems/insert-into-a-binary-search-tree/
 *
 * Time  : O(n) worst case
 * Space : O(H) for recursive and O(1) for iterative solution
 */
public class InsertIntoABinarySearchTree {
    /**
     * Recursive solution
     */
    public TreeNode insertIntoBST(TreeNode root, int val) {
        // Create the node with the val when you have traversed to the bottom of the tree on either side
        if(root == null)
            return new TreeNode(val);

        // Check for the val whether it is greater or smaller than the current root val recursively
        if(val > root.val)
            // Recursively call the fn and assign its return value to the root's right if the val > current root
            root.right = insertIntoBST(root.right, val);
        else
            // Recursively call the fn and assign its return value to the root's left if the val < current root
            root.left = insertIntoBST(root.left, val);
        return root;
    }

    /**
     * Iterative solution
     */
    public TreeNode insertIntoBSTIterative(TreeNode root, int val) {
        TreeNode curr = root;

        while(curr != null) {
            if(val > curr.val) {
                if (curr.right != null)
                    curr = curr.right;
                else {
                    curr.right = new TreeNode(val);

                    // Break is required as we are finished finding the spot whether the node has to added
                    // Otherwise, time limit exceeded issue will happen
                    break;
                }
            } else {
                if (curr.left != null)
                    curr = curr.left;
                else {
                    curr.left = new TreeNode(val);
                    // Break is required as we are finished finding the spot whether the node has to added
                    // Otherwise, time limit exceeded issue will happen
                    break;
                }
            }
        }
        return root;
    }
}
