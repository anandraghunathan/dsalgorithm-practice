package com.leetcode.bitmanipulation;

public class MissingNumber {
    public static int missingNumber(int[] nums) {
        int missing = nums.length;
        for(int i = 0; i < nums.length; i++) {
            missing ^= i ^ nums[i];
        }
        return missing;
    }

    public static void main(String[] args) {
        System.out.println(missingNumber(new int[]{3, 5, 6, 0, 4, 1}));
    }
}
