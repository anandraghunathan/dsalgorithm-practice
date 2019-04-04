package com.leetcode.array;

public class ShortestUnsortedContiguousSubarray {
    public static int findUnsortedSubarray(int[] nums) {
        int n = nums.length, beg = -1, end = -2, min = nums[n-1], max = nums[0];
        for (int i=1;i<n;i++) {
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[n-1-i]);
            if (nums[i] < max) end = i;
            if (nums[n-1-i] > min) beg = n-1-i;
        }
        return end - beg + 1;
    }

    public static void main(String[] args) {
        System.out.println(findUnsortedSubarray(new int[] {2, 6, 4, 8, 10, 9, 15}));
    }
}
