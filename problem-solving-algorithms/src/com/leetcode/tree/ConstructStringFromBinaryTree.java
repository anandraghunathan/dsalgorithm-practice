package com.leetcode.tree;

/**
 * https://leetcode.com/problems/construct-string-from-binary-tree/
 *
 */
public class ConstructStringFromBinaryTree {
    public static String tree2str(TreeNode t) {
        if (t == null)
            return "";

        String result = t.val + "";

        String left = tree2str(t.left);
        String right = tree2str(t.right);

        if (left == "" && right == "")
            return result;
        if (left == "")
            return result + "()" + "(" + right + ")";
        if (right == "")
            return result + "(" + left + ")";

        return result + "(" + left + ")" + "(" + right + ")";
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
//        treeNode.left = new TreeNode(2);
//        //treeNode.left.left = new TreeNode(4);
//        treeNode.left.right = new TreeNode(4);
        treeNode.right = new TreeNode(3);
        System.out.println(tree2str(treeNode));
    }
}
