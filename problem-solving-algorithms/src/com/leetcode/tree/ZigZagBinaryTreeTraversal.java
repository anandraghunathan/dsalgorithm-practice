package com.leetcode.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZigZagBinaryTreeTraversal {
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> wrapList = new LinkedList();

        if(root == null)
            return wrapList;

        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root);

        boolean normalOrder = false;

        while(!queue.isEmpty()) {
            int level = queue.size();
            LinkedList<Integer> subList = new LinkedList();
            normalOrder = !normalOrder;
            for(int i = 0; i < level; i++) {
                if(queue.peek().left != null)
                    queue.offer(queue.peek().left);
                if(queue.peek().right != null)
                    queue.offer(queue.peek().right);

                if(normalOrder)
                    subList.add(queue.poll().val);
                else
                    subList.addFirst(queue.poll().val);
            }
            wrapList.add(subList);
        }
        return wrapList;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3);
        treeNode.left = new TreeNode(9);
        treeNode.right = new TreeNode(20);
        treeNode.right.left = new TreeNode(15);
        treeNode.right.right = new TreeNode(7);
        System.out.println("BFS - Zig Zag - "+zigzagLevelOrder(treeNode));
    }
}
