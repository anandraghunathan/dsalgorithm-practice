package com.leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/permutations-ii/
public class PermutationsWithDuplicates {
    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        permute(list, new ArrayList<>(), nums, new boolean[nums.length]);
        return list;
    }

    private static void permute(List<List<Integer>> list, List<Integer> tempList, int [] nums, boolean [] used){
        if(tempList.size() == nums.length){
            list.add(new ArrayList<>(tempList));
        } else{
            for(int i = 0; i < nums.length; i++){
                if(used[i])
                    continue;
                if(i > 0 && nums[i] == nums[i-1] && !used[i - 1])
                    continue;
                used[i] = true;
                tempList.add(nums[i]);
                permute(list, tempList, nums, used);
                used[i] = false;
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
