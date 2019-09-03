package com.leetcode.tree;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/path-sum-iii/
 *
 */
public class PathSumIII {
    /**
     *       10
     *      /  \
     *     5   -3
     *    / \    \
     *   3   2   11
     *  / \   \
     * 3  -2   1
     *
     * Slow approach cause it does two DFS.
     *
     * pathSumFrom means the path sum starting at that node. While pathSumSlow means the sum inside the binary tree lead
     * by that node. If only pathSumFrom is called then it would only return number of paths starting at the root.
     *
     * Time  : O(n ^ 2) in the worst case (when no branching in tree, the sequence goes like 1 -> 2 -> 3 .. i --> n - 1 -> n),
     *          and the given sum has an upper bound of i possibilities
     *         O(NlogN) in best case. A balanced tree
     *
     * Space: O(N), due to recursion done twice, one DFS to find the root (pathFromSum),
     *              and the another DFS to find the sum inside the binary tree lead by that node.
     *
     *              1. pathSumFrom means pathSum starting at that node,
     *              2. pathSum means the sum inside the binary tree lead by that node.
     *
     *
     */
    public static int pathSumSlow(TreeNode root, int sum) {

        if(root == null)
            return 0;
        return pathSumFrom(root, sum)
                + pathSumSlow(root.left, sum)
                + pathSumSlow(root.right, sum);
    }

    private static int pathSumFrom(TreeNode node, int sum) {
        if (node == null)
            return 0;
        return (node.val == sum ? 1 : 0)
                + pathSumFrom(node.left, sum - node.val)
                + pathSumFrom(node.right, sum - node.val);
    }

    /**
     *       10
     *      /  \
     *     5   -3
     *    / \    \
     *   3   2   11
     *  / \   \
     * 3  -2   1
     *
     */
    public static int pathSum(TreeNode root, int sum) {
        Map<Integer, Integer> preSum = new HashMap<>();
        //preSum.put(0, 1); // Cause default sum = 0 has 1 possibility
        return helper(root, 0, sum, preSum);
    }

    public static int helper(TreeNode root, int currSum, int target, Map<Integer, Integer> preSum) {
        if(root == null)
            return 0;

        // Add the current root val to the sum calculated so far
        currSum += root.val;

        int res = preSum.getOrDefault(currSum - target, 0); //See if there is a sub-array sum equals to target
        preSum.put(currSum, preSum.getOrDefault(currSum, 0) + 1);

        //Extend to left and right child
        res += helper(root.left, currSum, target, preSum)
                    + helper(root.right, currSum, target, preSum);
        preSum.put(currSum, preSum.get(currSum) - 1); //Remove the current node so it wont affect other path
        return res;

    }
    /**
     *       10
     *      /  \
     *     5   -3
     *    / \    \
     *   3   2   11
     *  / \   \
     * 3  -2   1
     *
     */
    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(10);
        t1.left = new TreeNode(5);
        t1.right = new TreeNode(-3);
        t1.left.left = new TreeNode(3);
        t1.left.right = new TreeNode(2);
        t1.right.right = new TreeNode(11);
        t1.left.left.left = new TreeNode(3);
        t1.left.left.right = new TreeNode(-2);
        t1.left.right.right = new TreeNode(1);

        System.out.print(t1 != null ? t1.val + ", " : null + " , ");

        System.out.print(t1.left != null ? t1.left.val + ", " : null + ", ");

        System.out.print(t1.right != null ? t1.right.val + ", " : null + ", ");

        System.out.print(t1.left.left != null ? t1.left.left.val + ", "  : null + ", ");

        System.out.print(t1.left.right != null ? t1.left.right.val + ", "  : null + ", ");

        System.out.print(t1.left.right.left != null ? t1.left.right.left.val + ", "  : null + ", ");

        System.out.print(t1.right.right != null ? t1.right.right.val + ", "  : null + ", ");

        System.out.print(t1.left.left.left != null ? t1.left.left.left.val + ", "  : null + ", ");

        System.out.print(t1.left.left.right != null ? t1.left.left.right.val + ", "  : null);

        System.out.print(t1.right.left != null ? t1.right.left.val + ", "  : null + ", ");

        System.out.print(t1.left.right.right != null ? t1.left.right.right.val + ", "  : null + ", ");

        System.out.println("");
        //System.out.println(pathSum(t1, 8));
        System.out.println(pathSumSlow(t1, 8));
    }
}
