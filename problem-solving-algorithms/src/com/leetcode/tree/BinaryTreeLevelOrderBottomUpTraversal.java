package com.leetcode.tree;

import java.util.LinkedList;
import java.util.List;

public class BinaryTreeLevelOrderBottomUpTraversal {
    public static List<List<Integer>> levelOrderFromBottom(TreeNode root) {
        List<List<Integer>> wrapList = new LinkedList<>();
        levelMaker(wrapList, root, 0);
        return wrapList;
    }

    public static void levelMaker(List<List<Integer>> list, TreeNode root, int level) {
        if(root == null) return;
        if(level >= list.size()) {
            list.add(0, new LinkedList<>());
        }
        levelMaker(list, root.left, level+1);
        levelMaker(list, root.right, level+1);
        list.get(list.size()-level-1).add(root.val);
    }

//          To be output tree bottom up
//               3
//              / \
//              9  20
//               /  \
//              15   7
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3);
        treeNode.left = new TreeNode(9);
        treeNode.right = new TreeNode(20);
        treeNode.right.left = new TreeNode(15);
        treeNode.right.right = new TreeNode(7);
        System.out.println("DFS - Bottom Up - "+levelOrderFromBottom(treeNode));
    }
}
