package com.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 *  Solved on May 03 2019
 *  https://leetcode.com/problems/combination-sum/
 *
 *  Time  : O(N ^ target) where N is a length of candidates array.
 *  Space : O(target).
 */

public class CombinationSum {
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> combinations = new ArrayList();
        combinationSum(combinations, new ArrayList(), candidates, target, 0);
        return combinations;
    }

    public static void combinationSum(List<List<Integer>> combinations, List<Integer> combinationList, int[] candidates, int remain, int start) {
        if(remain < 0)
            return;
        else if(remain == 0)
            combinations.add(new ArrayList(combinationList));
        else {
            for(int i = start; i < candidates.length; i++) {
                combinationList.add(candidates[i]);
                combinationSum(combinations, combinationList, candidates, remain - candidates[i], i);
                combinationList.remove(combinationList.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("[");
        System.out.print("    ");
        for(List<Integer> nums : combinationSum(new int[]{2, 3, 6, 7}, 7)) {
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
