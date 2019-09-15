package com.leetcode.tree;

public class SumOfRootToLeafBinaryNumbers {
    int res = 0;
    public int sumRootToLeaf(TreeNode root) {
        dfs(root, 0);
        return res;
    }

    private void dfs(TreeNode node, int val) {
        if(node == null)
            return;

        // Convert this binary into a number by multiplying by 2 and adding the current node.val
        val = val << 1 | node.val; // Other way to see this is val = val * 2 + node.val

        // If both current node's left and right are null, we simply add our computed val to the result.
        if(node.left == null && node.right == null) {
            res += val;
        }
        /*
            If we are here, it means there are more nodes to explore. So we DFS through to explore the left and right
            nodes of the current node
         */
        dfs(node.left, val);
        dfs(node.right, val);
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(0);
        treeNode.left.left = new TreeNode(0);
        treeNode.left.right = new TreeNode(1);
        treeNode.right = new TreeNode(1);
        treeNode.right.left = new TreeNode(0);
        treeNode.right.right = new TreeNode(1);

        SumOfRootToLeafBinaryNumbers obj = new SumOfRootToLeafBinaryNumbers();
        System.out.println(obj.sumRootToLeaf(treeNode));
    }
}
