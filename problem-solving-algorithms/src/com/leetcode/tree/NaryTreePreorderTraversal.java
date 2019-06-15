package com.leetcode.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class NaryTreePreorderTraversal {
    static List<Integer> preorderList = new ArrayList<>();

    public static List<Integer> preorderRecursive(Node root) {
        if(root == null)
            return preorderList;

        preorderList.add(root.val);

        for(Node node : root.children) {
            preorderRecursive(node);
        }
        return preorderList;
    }

    public List<Integer> preorderIterative(Node root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) {
            return res;
        }

        Stack<Node> stack = new Stack();
        stack.push(root);

        while(!stack.isEmpty()) {
            Node node = stack.pop();
            res.add(node.val);

            for(int i = node.children.size() - 1; i >= 0; i--) {
                stack.push(node.children.get(i));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        // Todo to test on IntelliJ. Already executed and working on Leetcode
    }
}
