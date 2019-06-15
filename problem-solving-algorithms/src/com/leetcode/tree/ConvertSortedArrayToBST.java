package com.leetcode.tree;

public class ConvertSortedArrayToBST {
    public static TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length == 0)
            return null;

        TreeNode node = sortedArrayToBSTHelper(nums, 0, nums.length - 1);
        return node;
    }

    public static TreeNode sortedArrayToBSTHelper(int[] nums, int lo, int hi) {
        if(lo > hi) // we are done
            return null;

        int mid = (lo + hi) / 2;
        TreeNode node = new TreeNode(nums[mid]);

        node.left = sortedArrayToBSTHelper(nums, lo, mid - 1);
        node.right = sortedArrayToBSTHelper(nums, mid + 1, hi);

        return node;
    }

    //      0
    //     / \
    //   -3   9
    //   /   /
    // -10  5
    public static void main(String[] args) {
        int[] nums = new int[]{-10, -3, 0, 5, 9};

        TreeNode t1 = sortedArrayToBST(nums);

        System.out.print(t1 != null ? t1.val + ", " : null + " , ");

        System.out.print(t1.left != null ? t1.left.val + ", " : null + ", ");

        System.out.print(t1.left.right != null ? t1.left.right.val + ", "  : null + ", ");

        System.out.print(t1.right != null ? t1.right.val + ", " : null + ", ");

        System.out.print(t1.right.right != null ? t1.right.right.val + ", "  : null + ", ");
    }
}
