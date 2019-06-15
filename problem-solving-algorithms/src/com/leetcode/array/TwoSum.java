package com.leetcode.array;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> twoSumMap = new HashMap<>();
        int[] complementArr = {};
        for(int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if(twoSumMap.containsKey(complement)) {
                complementArr = new int[]{twoSumMap.get(complement), i};
            }
            twoSumMap.put(nums[i], i);
        }
        return complementArr;
    }

    public static void main(String[] args) {
        int[] output = twoSum(new int[]{3, 7, 8, 6, 7, 2, 4}, 6);
        for (int i = 0; i < output.length; i++) {
            System.out.print(output[i] +", ");
        }
    }
}
