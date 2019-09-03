package com.leetcode.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 *  https://leetcode.com/problems/binary-search-tree-iterator/
 *
 *  Can be solved using a few approaches. PQ approach is slow as we have to compare the val before we store it.
 *
 *  LinkedList and Stack are fast, but LinkedList approach used O(n) space instead of O(h)
 *
 *  Stack is the fastest, next() and hasNext() will run in average O(1) time and uses O(h) memory,
 *  where h is the height of the tree.
 */
public class BinarySearchTreeIterator {
    /* PriorityQueue<Integer> pq;
    public BinarySearchTreeIterator(TreeNode root) {
        pq = new PriorityQueue(new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return a - b;
            }
        });
        addNodes(root);
    }

    // In order traversal
    public void addNodes(TreeNode root) {
        if(root == null)
            return;
        addNodes(root.left);
        pq.offer(root.val);
        addNodes(root.right);
    }

    // @return the next smallest number
    public int next() {
        if(hasNext())
            return pq.poll();
        return -1;
    }

    // @return whether we have a next smallest number
    public boolean hasNext() {
        return pq.peek() != null;
    }

    */

    /* Queue<Integer> queue;
    public BinarySearchTreeIterator(TreeNode root) {
        queue = new LinkedList();
        addNodes(root);
    }

    public void addNodes(TreeNode root) {
        if(root == null)
            return;
        addNodes(root.left);
        queue.offer(root.val);
        addNodes(root.right);
    }

    // @return the next smallest number
    public int next() {
        if(hasNext())
            return queue.poll();
        return -1;
    }

    // @return whether we have a next smallest number
    public boolean hasNext() {
        return queue.peek() != null;
    } */

    /**
     * Intuition:
     *  https://leetcode.com/problems/binary-search-tree-iterator/discuss/52526/Ideal-Solution-using-Stack-(Java)
     */
    Stack<TreeNode> stack;
    public BinarySearchTreeIterator(TreeNode root) {
        /*
            Initialize the stack and call the addNodes method to add all the left nodes to the
            stack starting from the root node, move down one step each.
        */
        stack = new Stack();
        addNodes(root);
    }

    public void addNodes(TreeNode root) {
        /*
            Fill the stack by adding the root node first, then its left, and then its left and
            so on, therefore the last node added, that node will the smallest element in the BST
            will be the first one that will popped from the stack.
        */
        while(root != null) {
            stack.push(root);
            root = root.left;
        }
    }

    /** @return the next smallest number */
    public int next() {
        // Pop the smallest element from the stack.
        TreeNode currNode = stack.pop();
        /*
            Call the addNodes method to probe and add if it has right nodes iteratively.
            This will probe if the currNode's right node if that has further left nodes
        */
        addNodes(currNode.right);

        // Return the currNode val as the result for the next node val
        return currNode.val;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        // Simply return if the stack is empty
        return !stack.isEmpty();
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(7);
        treeNode.left = new TreeNode(3);
        treeNode.left.right = new TreeNode(5);
        treeNode.right = new TreeNode(15);
        treeNode.right.left = new TreeNode(9);
        treeNode.right.right = new TreeNode(20);

        BinarySearchTreeIterator obj = new BinarySearchTreeIterator(treeNode);
        System.out.println(obj.next());
        System.out.println(obj.next());
        System.out.println(obj.next());
        System.out.println(obj.next());
        System.out.println(obj.hasNext());
        System.out.println(obj.next());
        System.out.println(obj.hasNext());
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
