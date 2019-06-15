package com.leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://leetcode.com/problems/combination-sum-ii/
public class CombinationSumWithoutDuplicateReuse {
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> combinationsSum = new ArrayList<>();
        Arrays.sort(candidates);
        combinationsSum2(combinationsSum, new ArrayList<>(), candidates, target, 0);
        return combinationsSum;
    }

    public static void combinationsSum2(List<List<Integer>> combinationsSum, List<Integer> combinationList, int[] candidates, int remain, int start) {
        if(remain < 0)
            return;
        else if(remain == 0)
            combinationsSum.add(new ArrayList<>(combinationList));
        else {
            for(int i = start; i < candidates.length; i++) {
                if(i > start && candidates[i] == candidates[i - 1])
                    continue;
                combinationList.add(candidates[i]);
                combinationsSum2(combinationsSum, combinationList, candidates, remain - candidates[i], i + 1);
                combinationList.remove(combinationList.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("[");
        System.out.print("    ");
        for(List<Integer> nums : combinationSum2(new int[]{10,1,2,7,6,1,5}, 8)) {
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
