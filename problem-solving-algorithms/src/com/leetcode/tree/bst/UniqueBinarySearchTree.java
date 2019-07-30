package com.leetcode.tree.bst;

/**
 * Created by Anand Raghunathan on 2019-07-30
 *
 * https://leetcode.com/problems/unique-binary-search-trees/
 *
 * Time: O(n ^ 2)
 * Space: O(n)
 */
public class UniqueBinarySearchTree {
    /**
     *
     * https://www.youtube.com/watch?v=GgP75HAvrlY
     *
     * https://leetcode.com/problems/unique-binary-search-trees/discuss/31707/Fantastic-Clean-Java-DP-Solution-with-Detail-Explaination
     */
    public static int numTrees(int n) {
        int[] dp = new int[n + 1];
        /*
            An empty tree is a solution to an empty list. Therefore, G(0) = 1, meaning for n == 0, an empty
            tree will be returned that equals 1
         */
        dp[0] = dp[1] = 1;

        for(int level = 2; level <= n; level++) {
            for(int root = 1; root <= level; root++) {
                /*
                    Multiply the left subtree and right subtree possibilities to get the all the structurally unique BST(s)
                    we can build given the specific root element (for example 1 as root for n = 3)
                 */
                dp[level] += dp[level - root] * dp[root - 1];
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(numTrees(5));
    }
}
