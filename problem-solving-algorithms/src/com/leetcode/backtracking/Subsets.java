package com.leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *  Solved May 03 2019
 *  https://leetcode.com/problems/subsets
 *
 * Time  :  O(2 ^ n) as total 2 ^ n possible subsets can be there for n items.
 * Space : O( n + n) = O(n) is the (maximum depth of recursion tree + 'num' list space)
 *
 */
public class Subsets {
    /**
     *
     * 2 ^ n = total subsets. So if nums length is 3, we will have 2 ^ 3 = 8 all subsets (Power set)
     */
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        //Arrays.sort(nums); // contemplating whether this is required
        subsets(list, new ArrayList<>(), nums, 0);
        return list;
    }

    private static void subsets(List<List<Integer>> list , List<Integer> tempList, int [] nums, int start){
        list.add(new ArrayList<>(tempList));
        for(int i = start; i < nums.length; i++){
            tempList.add(nums[i]);
            subsets(list, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println("[");
        System.out.print("    ");
        for(List<Integer> nums : subsets(new int[]{1, 2, 3})) {
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
