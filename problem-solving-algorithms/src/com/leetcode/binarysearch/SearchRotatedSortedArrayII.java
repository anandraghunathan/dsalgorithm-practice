package com.leetcode.binarysearch;

public class SearchRotatedSortedArrayII {
    public static boolean search (int[] nums, int target){
        int lo = 0;
        int hi = nums.length - 1;

        // continue searching while [lo,hi] is not empty
        while (lo <= hi) {
            int mid = (lo + hi) / 2;

            if (nums[mid] == target)
                return true;

            if (nums[lo] < nums[mid]) {
                if (target >= nums[lo] && target < nums[mid])
                    hi = mid - 1;
                else
                    lo = mid + 1;
            } else if (nums[lo] > nums[mid]) {
                if (target > nums[mid] && target <= nums[hi])
                    lo = mid + 1;
                else
                    hi = mid - 1;
            } else {
                //duplicates, we know nums[mid] != target, so nums[lo] != target
                //based on current information, we can only move left pointer to skip one cell
                //thus in the worst case, we would have target: 2, and array like 11111111, then
                //the running time would be O(n)
                lo++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(search(new int[]{2,5,6,4,4,4,0,2}, 0));
    }
}
