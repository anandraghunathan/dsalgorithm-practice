package com.leetcode.binarysearch;

/**
 * https://leetcode.com/problems/search-in-rotated-sorted-array/
 */
public class SearchRotatedSortedArray {
    public static int search(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length - 1;

        // continue searching while [lo,hi] is not empty
        while (lo <= hi) {
            int mid = (lo + hi) / 2;

            if (nums[mid] == target)
                return mid;

            if (nums[lo] < nums[mid]) {
                if(target >= nums[lo] && target < nums[mid])
                    hi = mid - 1;
                else
                    lo = mid + 1;
            } else if (nums[lo] > nums[mid]){
                if(target > nums[mid] && target <= nums[hi])
                    lo = mid + 1;
                else
                    hi = mid - 1;
            } else {
                // When nums[lo] == nums[mid], move to the next number
                lo++;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        // System.out.println(search(new int[]{4,5,6,7,0,1,2}, 3));
        System.out.println(search(new int[]{3,1}, 1));
    }
}