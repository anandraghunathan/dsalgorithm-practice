package com.leetcode.tree;

public class MaximumDepthOfNAryTree {
    int max = 0;
    public int maxDepth(Node root) {
        if (root == null)
            return 0;

        maxDepthHelper(root, 1);
        return max;
    }

    public int maxDepthHelper(Node root, int depth) {
        max = Math.max(max, depth);
        for(Node child : root.children) {
            maxDepthHelper(child, depth + 1);
        }
        return max;
    }

    public static void main(String[] args) {
        // Todo
    }
}
