package com.leetcode.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {
    public static List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> wrapList = new LinkedList<>();

        if(root == null)
            return wrapList;

        queue.offer(root);
        while(!queue.isEmpty()) {
            int level = queue.size();
            List<Integer> subList = new LinkedList<>();
            while(level-- > 0) {
            //for(int i = 0; i < level; i++) {
                if (queue.peek().left != null)
                    queue.offer(queue.peek().left);
                if (queue.peek().right != null)
                    queue.offer(queue.peek().right);
                subList.add(queue.poll().val);
            }
            wrapList.add(subList);
        }
        return wrapList;
    }

//          To be output tree
//                3
//              /   \
//             9     20
//            / \   /  \
//           8   16 15  7
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3);
        treeNode.left = new TreeNode(9);
        treeNode.right = new TreeNode(20);
        treeNode.left.left = new TreeNode(8);
        treeNode.left.right = new TreeNode(16);
        treeNode.right.left = new TreeNode(15);
        treeNode.right.right = new TreeNode(7);
        System.out.println("BFS - Top Down - "+levelOrder(treeNode));
    }
}
