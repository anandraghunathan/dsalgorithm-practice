package com.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/path-sum-ii/discuss/36683/DFS-with-one-LinkedList-accepted-java-solution/34805
 *
 * time complexity: O(nlogn) instead of O(n)
 * space complexity: O(nlogn)
 * where n is the total number of nodes in the tree
 *
 *
 * Worst case: all of the paths from root to leaf have the target sum.
 * For example: the tree is a perfect tree with all the same values.
 *
 * Space complexity:
 *
 *      The number of paths = the number of leaf nodes = (n + 1)/2 = O(n) and the path length is logn,
 *      so the result list will be O(nlogn) as you can see.
 *
 *
 * Time complexity:
 *      You may think that the time complexity is O(n) since basically we are doing DFS, we visit each node once.
 *      But remember that when you add the current path list to result list, you use
 *      result.add(new ArrayList(currentResult));: means that every time you find the valid path, you make a copy of them,
 *      then add it to the result, which takes time O(logn) which is equal to the number of nodes in the path.
 *      Total (n + 1)/2 paths, so time complexity: O(nlogn)
 *
 */
public class PathSumII {
    public static List<List<Integer>> pathSum(TreeNode root, int sum) {
        // Result list of list with pathSum combination that sums to the given sum
        List<List<Integer>> res = new ArrayList();

        // Curr root val added at each recursive call
        List<Integer> cur = new ArrayList();

        // Helper function to find the pathSum
        pathSum(root, sum, cur, res);
        return res;
    }

    public static void pathSum(TreeNode root, int sum, List<Integer> cur, List<List<Integer>> res){
        if(root == null)
            return;

        // Add the current root val to the cur list
        cur.add(root.val);

        // Check if this current node is a leaf node, if yes, add the cur list to the res list of list
        if(root.left == null && root.right == null && root.val == sum)
            res.add(new ArrayList(cur));

            // Else we need to call this fn recursively until we hit the leaf node as per the question (root to lead node)
        else {
            pathSum(root.left, sum - root.val, cur, res);
            pathSum(root.right, sum - root.val, cur, res);
        }
        // remove the existing cur root to back track and find other combinations that sums to the given sum
        cur.remove(cur.size() - 1);
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(5);
        t1.left = new TreeNode(4);
        t1.right = new TreeNode(8);
        t1.left.left = new TreeNode(11);
        t1.left.left.left = new TreeNode(7);
        t1.left.left.right = new TreeNode(2);
        t1.right.left = new TreeNode(13);
        t1.right.right = new TreeNode(4);
        t1.right.right.left = new TreeNode(5);
        t1.right.right.right = new TreeNode(1);

        System.out.println("");
        System.out.print("[");
        System.out.println();
        for(List<Integer> path : pathSum(t1, 22)) {
            System.out.print(" " + path + " ");
        }
        System.out.println();
        System.out.print("]");
    }
}
