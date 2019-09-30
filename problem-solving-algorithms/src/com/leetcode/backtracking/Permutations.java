package com.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 *  Solved on May 08 2019
 *  https://leetcode.com/problems/permutations/
 *
 *  Time  : O( n * n! ), if we have 3 elements in the given array, then the TC will be (3 * 3!) -> (3 * (3 * 2 * 1))
 *          There is O(n^2) time complexity for each permutation
 *  Space : O(n)
 */
public class Permutations {
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        backtrack(list, new ArrayList<>(), nums);
        return list;
    }

    private static void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums) {
        if(tempList.size() == nums.length){
            /**
             *  We do the below instead of list.add(tempList) because list will save templist pointer last address and
             *  last address is null. so the output is all null. It is necessary to create a new ArrayList to save
             *  templist each time.
             *
             *  tempList is a list that is used throughout all the recursive calls to keep track of the current recursion
             *  path. When we finally reach the base case, we cannot add this same list to the list of lists. This is
             *  because when you add tempList, you are adding a reference to tempList. This means that other recursive
             *  paths can modify the path you just inserted into the final list of lists.
             *
             *  In short, if we add the list directly into result, it will change later because list will be modified
             *  many times (lists are mutable). So we add its deep copy into the result.
             *
             */
            list.add(new ArrayList<>(tempList));
        } else{
            for(int i = 0; i < nums.length; i++){
                if(tempList.contains(nums[i]))
                    continue; // element already exists, skip
                tempList.add(nums[i]);
                backtrack(list, tempList, nums);

                /**
                 * To generate all possible permutations, we need to remove the least recently added element while we
                 * are going up the recursive call stack. In the first iteration of the for loop we add all permutations,
                 * that start with nums[0]. Then, before we can begin building all permutations starting with nums[1],
                 * we need to clear the tempList (which currently contains permutations from the first iteration of the
                 * for loop) - that's exactly what tempList.remove(tempList.size() - 1) line does.
                 */
                tempList.remove(tempList.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("[");
        System.out.print("    ");
        for(List<Integer> nums : permute(new int[]{1, 2, 3})) {
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
