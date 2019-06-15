package com.leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class NaryTreePostorderTraversal {
    public static List<Integer> postorderList = new ArrayList<>();

    public static List<Integer> postorderRecursive(Node root) {
        if(root == null)
            return postorderList;

        for(Node node : root.children) {
            postorderRecursive(node);
        }

        postorderList.add(root.val);

        return postorderList;
    }

    public List<Integer> postorderIterative(Node root) {
        LinkedList<Integer> res = new LinkedList<>();

        if(root == null)
            return res;

        Stack<Node> stack = new Stack();
        stack.push(root);

        while(!stack.isEmpty()) {
            Node node = stack.pop();
            res.addFirst(node.val);
            for(Node child : node.children) {
                stack.push(child);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        // Todo to test on IntelliJ. Already executed and working on Leetcode
    }
}
