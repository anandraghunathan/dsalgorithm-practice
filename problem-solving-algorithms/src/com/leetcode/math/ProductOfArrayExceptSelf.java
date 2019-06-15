package com.leetcode.math;

public class ProductOfArrayExceptSelf {
    public static int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];
        res[0] = 1;
        // Populate the left to right first starting with the first index of the array
        for(int i = 1; i < len; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }

        int right = 1;
        // Populate the right to left.. starting with the last index of the array
        for(int i = len - 1; i >= 0; i--) {
            res[i] = res[i] * right;
            right = right * nums[i];
        }
        return res;
    }

    public static void main(String[] args) {
       int[] res = productExceptSelf(new int[] {1, 2, 3, 4});
       for(int n : res) {
           System.out.println(n);
       }
    }
}
