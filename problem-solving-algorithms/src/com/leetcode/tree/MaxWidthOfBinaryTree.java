package com.leetcode.tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 *
 * https://leetcode.com/problems/maximum-width-of-binary-tree/
 *
 * Intuition:
 *      The idea is to traverse all the node in the tree in level order(Here I use one Queue to store each level's nodes.
 *      The time I traverse each level is the queue's size(the number of nodes from upper level)). Each time a node is
 *      traversed, the position of the node(as it is in a full binary tree) is stored in the HashMap. If the position
 *      of the parent node is 'n', then the left child is '2 * n' and the right child is '2 * n + 1'. The width of each
 *      level is the last node's position in this level subtracts the first node's position in this level plus 1.
 *
 * Algorithm:
 *      Traverse each node in breadth-first order, keeping track of that node's position. For each depth, the first
 *      node reached is the left-most, while the last node reached is the right-most.
 *
 * Time  : O(n), where n is the number of nodes in the input tree. We traverse every node.
 * Space : O(n), the size of our queue.
 */
public class MaxWidthOfBinaryTree {
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null)
            return 0;

        Queue<TreeNode> queue = new LinkedList();
        Map<TreeNode, Integer> map = new HashMap();
        map.put(root, 1); // root node is counted as 1 width as add that first
        queue.offer(root); // add the root node to the queue

        int maxWidth = 0;
        int currWidth = 0;
        while(!queue.isEmpty()) {
            int start = 0, end = 0;
            int maxQueueSize = queue.size();
            for(int size = 1; size <= maxQueueSize; size++) {
                TreeNode node = queue.poll();

                if(size == 1)
                    start = map.get(node);

                if(size == maxQueueSize)
                    end = map.get(node);

                if(node.left != null) {
                    map.put(node.left, map.get(node) * 2);
                    queue.offer(node.left);
                }

                if(node.right != null) {
                    map.put(node.right, map.get(node) * 2 + 1);
                    queue.offer(node.right);
                }
            }
            currWidth = end - start + 1;
            if(currWidth > maxWidth) {
                maxWidth = currWidth;
            }
        }
        return maxWidth;
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        t1.left = new TreeNode(2);
        t1.right = new TreeNode(3);
        t1.left.left = new TreeNode(4);
        t1.right.right = new TreeNode(5);
        t1.left.left.left = new TreeNode(6);
        t1.right.right.right = new TreeNode(7);

        MaxWidthOfBinaryTree obj = new MaxWidthOfBinaryTree();
        System.out.println(obj.widthOfBinaryTree(t1));
    }
}
