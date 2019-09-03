package com.leetcode.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/maximum-level-sum-of-a-binary-tree/
 *
 * Intuition: Use BFS, using a LinkedList, add nodes at each level. Keep a currLevel and maxLevel pointers to denote levels
 *            Then keep currLevelSum and maxSum pointers. Navigate through the size of the queue at each level. Add the
 *            node's vals at each level, subsequently add the currNode's left and right node if exist.
 *
 *            Finally, check if the currLevelSum is > than maxSum, if yes, make the maxSum to be the currLevelSum,
 *            and set the maxLevel to the currLevel that gets increment after all of the computing everything described above
 *
 * Time  : O(N) since each node is processed exactly twice. Push into queue and then to pop out.
 * Space : O(N) since we push each node into the queue to compute the max
 *         With bfs, space requirement is proportional to span, whereas with dfs it's proportional to the height.
 *
 */
public class MaxLevelSumBinaryTree {
    public int maxLevelSum(TreeNode root) {
        if(root == null)
            return -1;

        int maxSum = Integer.MIN_VALUE, currLevel = 1, maxLevel = 1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()) {
            // Declare currLevelSum just after the queue empty check and before we iterate through the currLevel nodes
            int currLevelSum = 0;
            for(int size = queue.size(); size > 0; size--) {
                TreeNode currNode = queue.poll();
                currLevelSum += currNode.val; // sum the currNode val as we iterate through the left and right nodes at each level

                if(currNode.left != null)
                    queue.offer(currNode.left);
                if(currNode.right != null)
                    queue.offer(currNode.right);
            }

            if(currLevelSum > maxSum) {
                maxSum = currLevelSum;
                maxLevel = currLevel; // At start, currLevel will be 1, then it gets incremented at each level (after for loop)
            }
            // Increment the currLevel after we process the nodes at the current level
            currLevel++;
        }
        return maxLevel;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(7);
        treeNode.left.left = new TreeNode(7);
        treeNode.left.right = new TreeNode(-8);
        treeNode.right = new TreeNode(0);

        MaxLevelSumBinaryTree obj = new MaxLevelSumBinaryTree();
        System.out.println(obj.maxLevelSum(treeNode));
    }
}
