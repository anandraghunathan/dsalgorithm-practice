package com.leetcode.array;

public class FirstAndLastPositionOfElementInArray {
    // Linear search algorithm
    public int[] searchRange(int[] nums, int target) {
        int[] targetRange = {-1, -1};
        int n = nums.length;
        for(int i = 0; i < n; i++) {
            if(nums[i] == target) {
                targetRange[0] = i;
                break;
            }
        }
        if(targetRange[0] == -1)
            return targetRange;

        for(int i = n - 1; i >= 0; i --) {
            if(nums[i] == target) {
                targetRange[1] = i;
                break;
            }
        }
        return targetRange;
    }

    public static void main(String[] args) {
        System.out.println();
    }
}
