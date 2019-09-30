package com.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 *  https://leetcode.com/problems/combination-sum-iii
 *
 *  Time  : O(C(9,k)) -> O(9 * k)
 *  Space : O(k)
 */
public class CombinationsSumIII {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> combinations = new ArrayList<>();
        combinationSumHelper(k, n, 1, new ArrayList<>(), combinations);
        return combinations;
    }

    public void combinationSumHelper(int k, int target, int start, List<Integer> subList, List<List<Integer>> combinations) {
        if(target < 0)
            return;
        else if(subList.size() == k && target == 0) {
            combinations.add(new ArrayList(subList));
            return;
        } else {
            for(int i = start; i <= 9; i++) {
                subList.add(i);
                combinationSumHelper(k, target - i, i + 1, subList, combinations);
                subList.remove(subList.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        CombinationsSumIII obj = new CombinationsSumIII();
        System.out.println("[");
        System.out.print("    ");
        List<List<Integer>> res = obj.combinationSum3(3, 9);
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
