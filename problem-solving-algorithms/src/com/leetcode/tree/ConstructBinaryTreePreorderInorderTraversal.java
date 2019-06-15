package com.leetcode.tree;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreePreorderInorderTraversal {

    /**
     *
     * @param preorder
     * @param inorder
     * @return
     *
     * Added the HashMap optimization to the inOrder array instead of looping through the inOrder array
     * for each recursive call to compute the inIndex
     */
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inMap = new HashMap<>();
        for(int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }
        return helper(0, 0, inorder.length - 1, preorder, inorder, inMap);
    }

    /**
     *
     * @param preStart
     * @param inStart
     * @param inEnd
     * @param preorder
     * @param inorder
     * @param inMap
     * @return
     *
     * Added the HashMap optimization to the inOrder array instead of looping through the inOrder array
     * for each recursive call to compute the inIndex
     *
     */
    public static TreeNode helper(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder, Map<Integer, Integer> inMap) {
        if (preStart > preorder.length - 1 || inStart > inEnd) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preStart]);
        int inIndex = inMap.get(root.val);; // Index of current root in inorder
//        for (int i = inStart; i <= inEnd; i++) {
//            if (inorder[i] == root.val) {
//                inIndex = i;
//                break;
//            }
//        }
        root.left = helper(preStart + 1, inStart, inIndex - 1, preorder, inorder, inMap);
        root.right = helper(preStart + inIndex - inStart + 1, inIndex + 1, inEnd, preorder, inorder, inMap);
        return root;
    }

//      To be output tree
//              3
//             / \
//             9  20
//               /  \
//              15   7
    public static void main(String[] args) {
        int[] preOrderTree = new int[]{8, 5, 1, 7, 10, 12};
        int[] inOrderTree = new int[]{1, 5, 8, 10, 7, 12};

        TreeNode root = buildTree(preOrderTree, inOrderTree);

        System.out.print(root != null ? root.val + ", " : null + " , ");

        System.out.print(root.left != null ? root.left.val + ", " : null + ", ");

        System.out.print(root.right != null ? root.right.val + ", " : null + ", ");

        System.out.print(root.left.left != null ? root.left.left.val + ", " : null + ", ");

        System.out.print(root.left.right != null ? root.left.right.val + ", " : null + ", ");

        System.out.print(root.right.left != null ? root.right.left.val + ", "  : null + ", ");

        System.out.print(root.right.right != null ? root.right.right.val + ", "  : null + ", ");

    }
}
