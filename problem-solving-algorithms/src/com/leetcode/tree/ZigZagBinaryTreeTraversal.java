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

        boolean order = false;

        while(!queue.isEmpty()) {
            int size = queue.size();
            LinkedList<Integer> subList = new LinkedList();
            order = !order;
            while(size-- > 0) {
                if(queue.peek().left != null)
                    queue.offer(queue.peek().left);
                if(queue.peek().right != null)
                    queue.offer(queue.peek().right);

                if(order)
                    subList.add(queue.poll().val);
                else
                    subList.addFirst(queue.poll().val);
            }
            wrapList.add(subList);
        }
        return wrapList;
    }
//          Sample input tree
//                3
//              /   \
//             9     20
//            / \   /  \
//           8   16 15  7

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        treeNode.left.left = new TreeNode(4);
        treeNode.left.right = new TreeNode(5);
        treeNode.right.left = new TreeNode(6);
        treeNode.right.right = new TreeNode(7);
        treeNode.left.left.left = new TreeNode(8);
        treeNode.left.right.left = new TreeNode(9);
        treeNode.right.right.right = new TreeNode(10);
        System.out.println("BFS - Zig Zag - "+zigzagLevelOrder(treeNode));
    }
}
