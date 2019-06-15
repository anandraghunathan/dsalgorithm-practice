package com.leetcode.tree;

public class MaximumBinaryTree {

    /**
     *
     * Time complexity : O(n^2)
     *
     * The function construct is called n times. At each level of the recursive tree,
     * we traverse over all the n elements to find the maximum element. In the average case,
     * there will be a logn levels leading to a complexity of O(nlogn).
     * In the worst case, the depth of the recursive tree can grow upto n, which happens in the
     * case of a sorted nums array, giving a complexity of O(n^2)
     *
     * Space complexity : O(n)
     *
     * The size of the setset can grow upto n in the worst case. In the average case,
     * the size will be nlogn for nn elements in nums, giving an average case complexity of O(log n)
     *
     */
    public static TreeNode constructMaximumBinaryTree(int[] nums) {
        return constructMaxBinaryTree(nums, 0, nums.length);
    }

    static TreeNode constructMaxBinaryTree(int[] nums, int start, int end) {
        if(start == end)
            return null;

        int max_i = max(nums, start, end);
        TreeNode root = new TreeNode(nums[max_i]);

        root.left = constructMaxBinaryTree(nums, start, max_i);

        root.right = constructMaxBinaryTree(nums, max_i + 1, end);

        return root;
    }

    static int max(int[] nums, int start, int end) {
        int max_i = start;
        for(int i = start; i < end; i++) {
            if(nums[max_i] < nums[i]) {
                max_i = i;
            }
        }
        return max_i;
    }

    public static void main(String[] args) {
        TreeNode t1 = constructMaximumBinaryTree(new int[]{3,2,1,6,0,5});

        System.out.print(t1 != null ? t1.val + ", " : null + " , ");

        System.out.print(t1.left != null ? t1.left.val + ", " : null + ", ");

        System.out.print(t1.right != null ? t1.right.val + ", " : null + ", ");

        System.out.print(t1.left.left != null ? t1.left.left.val + ", "  : null + ", ");

        System.out.print(t1.left.right != null ? t1.left.right.val + ", "  : null + ", ");

        System.out.print(t1.left.right.right != null ? t1.left.right.right.val + ", "  : null + ", ");

        System.out.print(t1.right.left != null ? t1.right.left.val + ", "  : null + ", ");

        //System.out.print(t1.right.right != null ? t1.right.right.val + ", "  : null + ", ");
    }
}
