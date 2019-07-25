package com.leetcode.tree;

/**
 * https://leetcode.com/problems/binary-tree-pruning
 *
 * Time   :  O(N), N is the number of nodes in the tree and we process each node once
 * Space  :  O(H), H is the height of the tree
 */
public class BinaryTreePruning {
    /**
     Beginning from the bottom, for null nodes we just return null. If the node is 1, or if there is any child of it is not null,
     we return itself, otherwise we return null. In this way, only when a node has two null children, and itself is also 0,
     we return null and the null will be assigned to its parent’s left/right, so we pruned the tree.
     */
    public TreeNode pruneTree(TreeNode root) {
        if(root == null)
            return null;

        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);

        if(root.left == null && root.right == null && root.val == 0)
            return null;

        return root;
    }
}
