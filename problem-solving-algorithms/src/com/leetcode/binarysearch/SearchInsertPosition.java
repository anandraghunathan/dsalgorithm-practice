package com.leetcode.binarysearch;

/**
 * https://leetcode.com/problems/search-insert-position/
 */
public class SearchInsertPosition {
    public static int searchInsert(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length - 1;

        // continue searching while [lo,hi] is not empty
        while(lo <= hi) {
            int mid = (lo + hi) / 2;
            if(nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return lo;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,3,5,6};
        System.out.println(searchInsert(arr, 7));
    }
}
