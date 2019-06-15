package com.leetcode.tree;

public class ConstructBinarySearchTreeFromPreorderTraversal {
    static int i = 0;

    // 8,5,1,7,10,12
    /*
         8
       /   \
      5     7
     /     / \
    1     10  12

    */
    public static TreeNode bstFromPreOrder(int[] preorder) {
        return bstFromPreOrder(preorder, Integer.MAX_VALUE);
    }

    static TreeNode bstFromPreOrder(int[] preorder, int max) {
        if(i > preorder.length - 1 || preorder[i] > max) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[i++]);
        root.left = bstFromPreOrder(preorder, root.val);
        root.right = bstFromPreOrder(preorder, max);
        return root;
    }

    public static void main(String[] args) {
        int[] preOrderTree = new int[]{8, 5, 1, 7, 10, 12};

        TreeNode root = bstFromPreOrder(preOrderTree);

        System.out.print(root != null ? root.val + ", " : null + " , ");

        System.out.print(root.left != null ? root.left.val + ", " : null + ", ");

        System.out.print(root.right != null ? root.right.val + ", " : null + ", ");

        System.out.print(root.left.left != null ? root.left.left.val + ", " : null + ", ");

        System.out.print(root.left.right != null ? root.left.right.val + ", " : null + ", ");

        System.out.print(root.right.left != null ? root.right.left.val + ", "  : null + ", ");

        System.out.print(root.right.right != null ? root.right.right.val + ", "  : null + ", ");

    }
}
