package com.leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *  Solved May 03 2019
 *  https://leetcode.com/problems/subsets-ii/
 *
 * Time  :  O(2 ^ n) as total 2 ^ n possible subsets can be there for n items.
 * Space : O( n + n) = O(n) is the (maximum depth of recursion tree + 'num' list space)
 *
 */
public class SubsetsWithDuplicates {
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> powerset = new ArrayList<>();
        // sorting is required so we can do the comparison of current with previous with respect to duplicates
        Arrays.sort(nums);
        generatePowersetWithDup(powerset, new ArrayList<>(), nums, 0);
        return powerset;
    }

    public static void generatePowersetWithDup(List<List<Integer>> powerset, List<Integer> subset, int[] nums, int start) {
        powerset.add(new ArrayList(subset));
        for(int i = start; i < nums.length; i++) {
            // When a number has the same value with its previous, we have to skip the current one, so continue
            if(i > start && nums[i] == nums[i - 1]) continue; // To skip duplicates
            subset.add(nums[i]);
            generatePowersetWithDup(powerset, subset, nums, i + 1);
            subset.remove(subset.size() - 1);
        }
    }
    public static void main(String[] args) {
        System.out.println("[");
        System.out.print("    ");
        for(List<Integer> nums : subsetsWithDup(new int[]{1, 2, 2})) {
            System.out.print("[ ");
            for(int num : nums) {
                System.out.print(num +" ");
            }
            System.out.print("]");
        }
        System.out.println("");
        System.out.println("]");
    }
}
