package com.leetcode.tree;

public class ConstructBinaryTreePostorderInorderTraversal {
    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        return helper(postorder.length-1, 0, inorder.length-1, postorder, inorder);
    }
    private static TreeNode helper(int postStart, int inStart, int inEnd, int[] postorder, int[] inorder) {
        if(inStart>inEnd ||postStart<0) return null;
        TreeNode root = new TreeNode(postorder[postStart]);

        int inIndex = 0;
        for (int i=inStart; i<=inEnd; i++) {
            if(inorder[i] == root.val){
                inIndex = i;
                break;
            }
        }
        root.left = helper(postStart-(inEnd-inIndex)-1, inStart, inIndex-1, postorder, inorder);
        root.right = helper(postStart-1, inIndex+1, inEnd, postorder, inorder);

        return root;
    }

//      To be output tree
//              3
//             / \
//             9  20
//               /  \
//              15   7
    public static void main(String[] args) {
        int[] inOrderTree = new int[]{9,3,15,20,7};
        int[] postOrderTree = new int[]{9,15,7,20,3};

        TreeNode root = buildTree(inOrderTree, postOrderTree);

        System.out.print(root != null ? root.val + ", " : null + " , ");

        System.out.print(root.left != null ? root.left.val + ", " : null + ", ");

        System.out.print(root.right != null ? root.right.val + ", " : null + ", ");

        System.out.print(root.left.left != null ? root.left.left.val + ", " : null + ", ");

        System.out.print(root.left.right != null ? root.left.right.val + ", " : null + ", ");

        System.out.print(root.right.left != null ? root.right.left.val + ", "  : null + ", ");

        System.out.print(root.right.right != null ? root.right.right.val + ", "  : null + ", ");

    }
}
