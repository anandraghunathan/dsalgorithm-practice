package com.leetcode.tree;

/**
 *  https://leetcode.com/problems/sum-root-to-leaf-numbers/
 *
 *  Intuition:
 *          Can be solved using DFS starting from root node and working our way down to the leaf node using pre-order traversal.
 *
 *          Basically, we first check if the current root has left and right nodes, if both are null, we simply return the
 *          prevVal * 10 + take the current node's val.
 *
 *          Otherwise, we do the DFS to explore more by going left and right of the current node till we get to the leaf node
 *          by passing the prevVal * 10 * currNode.val as the "prevVal" for the next recursion.
 *
 *          Time  : O(N), We traverse through all the nodes of the tree
 *          Space : O(H), not using any extra space. H is the maximum height of the tree
 */
public class SumRootToLeafNumbers {
    public int sumNumbers(TreeNode root) {
        return sumNumbersHelper(root, 0);
    }

    private int sumNumbersHelper(TreeNode currNode, int prevVal) {
        if(currNode == null)
            return 0;

        prevVal = prevVal * 10 + currNode.val;

        if(currNode.left == null && currNode.right == null)
            return prevVal;

        return sumNumbersHelper(currNode.left, prevVal) + sumNumbersHelper(currNode.right, prevVal);
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(4);
        treeNode.left = new TreeNode(9);
        treeNode.right = new TreeNode(0);
        treeNode.left.left = new TreeNode(5);
        treeNode.left.right = new TreeNode(1);

        SumRootToLeafNumbers obj = new SumRootToLeafNumbers();
        System.out.println(obj.sumNumbers(treeNode));
    }
}
