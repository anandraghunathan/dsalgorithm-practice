package com.leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *  Solved on May 03 2019
 *  https://leetcode.com/problems/permutations-ii/
 *
 *  Use an extra boolean array "boolean[] used" to indicate whether the value is added to list.
 *
 *  Sort the array "int[] nums" to make sure we can skip the same value.
 *
 *  When a number has the same value with its previous, we can use this number only if his previous is used
 *
 *  Time  : O( n * n! ), if we have 3 elements in the given array, then the TC will be (3 * 3!) -> (3 * (3 * 2 * 1))
 *          There is O(n^2) time complexity for each permutation
 *  Space : O(n)
 */
public class PermutationsWithDuplicates {
    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        // sorting is required so we can do the comparison of current with previous with respect to duplicates
        Arrays.sort(nums);
        permute(list, new ArrayList<>(), nums, new boolean[nums.length]);
        return list;
    }

    private static void permute(List<List<Integer>> list, List<Integer> tempList, int [] nums, boolean [] used){
        if(tempList.size() == nums.length){
            list.add(new ArrayList<>(tempList));
        } else{
            for(int i = 0; i < nums.length; i++){
                if(used[i]) // We have already used this element, so move on to the next index
                    continue;

                // When a number has the same value with its previous, we can use this number only if his previous is used
                if(i > 0 && nums[i] == nums[i-1] && !used[i - 1])
                    continue;

                used[i] = true; // make the current element's boolean index to true cause we now used this in our permutation
                tempList.add(nums[i]);
                permute(list, tempList, nums, used);
                used[i] = false; // Reset the boolean index of the current element to false again, since we are backtracking
                tempList.remove(tempList.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("[");
        System.out.print("    ");
        for(List<Integer> nums : permuteUnique(new int[]{1, 2, 2})) {
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
