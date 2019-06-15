package com.leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NaryTreeLevelOrderTraversal {
    public static List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();

        if(root == null)
            return res;

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()) {
            List<Integer> sublist = new ArrayList<>();
            int size = queue.size();

            while(size-- > 0) {
                Node curr = queue.poll();
                sublist.add(curr.val);
                for(Node node : curr.children)
                    queue.offer(node);
            }
            res.add(sublist);
        }
        return res;
    }

    public static void main(String[] args) {
        // Todo to test on IntelliJ. Already executed and working on Leetcode
    }
}
