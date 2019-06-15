package com.leetcode.array;

public class FindMinimumInRotatedSortedArray {
    public static int minNumber(int[] nums) {
        int lo = 0;
        int hi = nums.length - 1;

        while(lo < hi) {
            int mid = (lo + hi) / 2;

            if(nums[mid] < nums[hi])
                hi = mid;
            else
                lo = mid + 1;
        }
        return nums[lo];
    }

    public static void main(String[] args) {
        System.out.println(minNumber(new int[]{5,4,3,1,2}));
    }
}
