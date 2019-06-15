package com.leetcode.hard;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

// https://leetcode.com/problems/binary-tree-postorder-traversal/

public class BinaryPostOrderTraversal {
    public List<Integer> postorderTraversalIterative(TreeNode root) {
        LinkedList<Integer> postOrderList = new LinkedList();

        if(root == null)
            return postOrderList;

        Stack<TreeNode> stack = new Stack();
        stack.push(root);

        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            postOrderList.addFirst(node.val);

            if(node.left != null)
                stack.push(node.left);

            if(node.right != null)
                stack.push(node.right);
        }
        return postOrderList;
    }

    public static List<Integer> postorderTraversalRecursive(TreeNode root) {
        List<Integer> postOrderList = new ArrayList();
        postorderTraversalHelper(root, postOrderList);
        return postOrderList;
    }

    private static void postorderTraversalHelper(TreeNode root, List<Integer> postOrderList) {
        if(root != null) {
            if(root.left != null)
                postorderTraversalHelper(root.left, postOrderList);
            if(root.right != null)
                postorderTraversalHelper(root.right, postOrderList);
            postOrderList.add(root.val);
        }
    }
}
