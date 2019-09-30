package com.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 *  https://leetcode.com/problems/combination-sum-iv/
 *
 *  Requirement modified version where similar combinations such as [1,1,2] and [2,1,1] are not considered as different
 *  combination sums. We can simply return the size of the res list for the number of combination sums matching that
 *  criteria
 */
public class CombinationsIV {
    public List<List<Integer>> combinationSum4(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        combinationSum4Helper(nums, target, 0, new ArrayList(), res);
        return res;
    }

    private void combinationSum4Helper(int[] nums, int target, int start, List<Integer> subList, List<List<Integer>> res) {
        if(target < 0) {
            return;
        } else if(target == 0) {
            res.add(new ArrayList(subList));
            return;
        } else {
            for(int i = start; i < nums.length; i++) {
                subList.add(nums[i]);
                combinationSum4Helper(nums, target - nums[i], i, subList, res);
                subList.remove(subList.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        CombinationsIV obj = new CombinationsIV();
        System.out.println("[");
        System.out.print("    ");
        List<List<Integer>> res = obj.combinationSum4(new int[]{1,2,3}, 4);
        int resCount = res.size();
        for(List<Integer> nums : res) {
            System.out.print("[ ");
            int numsCount = nums.size();
            for(int num : nums) {
                System.out.print(num);
                System.out.print(numsCount-- > 1 ? ", " : "");
            }
            System.out.print(resCount-- > 1 ? "]," : "]");
        }
        System.out.println("");
        System.out.println("]");
    }
}
