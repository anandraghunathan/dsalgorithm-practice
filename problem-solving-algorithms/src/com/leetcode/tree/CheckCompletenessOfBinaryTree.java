package com.leetcode.tree;

import java.util.LinkedList;
import java.util.Queue;

public class CheckCompletenessOfBinaryTree {
    /**
     https://leetcode.com/problems/check-completeness-of-a-binary-tree/

     Intuition:
     We can perform BFS (level-order traversal) using a queue to find if the tree
     is a complete one.

     Algorithm:
     We will keep adding the nodes till we hit a null node. Once null node is hit,
     there shouldn't be anymore nodes added into the queue, if a new node gets added
     after the null node, it means the tree is not a complete tree.

     Time  : O(N), N is the number of nodes, we are going through each node of the tree.
     Space : O(N), we are using the Queue to store the nodes.
     */
    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        /*
            To check if the tree is complete. Once the flag becomes true, no further nodes
            should get added to the queue after
        */
        boolean isComplete = false;
        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            // Once we hit the null node, we set the flag to true
            if(node == null)
                isComplete = true;
            else {
                /*
                    Once the flag is set to true, there should never be another node added
                    to the queue, this means its not a complete tree, so return false immediately
                */
                if(isComplete)
                    return false;
                // If the flag is still false, add current node's left and right nodes
                queue.offer(node.left);
                queue.offer(node.right);
            }
        }
        /*
            If we have come here, it means we haven't hit the negative condition to say the
            tree isn't a complete binary tree, so we simply return true
        */
        return true;
    }

    /**
     *  Test case tree - This is not a complete binary tree
     *
     *            1
     *          /  \
     *         2    3
     *        / \    \
     *       4   5    6
     *
     *
     */
    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        t1.left = new TreeNode(2);
        t1.right = new TreeNode(3);
        t1.left.left = new TreeNode(4);
        t1.left.right = new TreeNode(5);
        t1.right.right = new TreeNode(6);

        CheckCompletenessOfBinaryTree obj = new CheckCompletenessOfBinaryTree();
        System.out.println(obj.isCompleteTree(t1));
    }
}
