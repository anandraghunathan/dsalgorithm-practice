package com.leetcode.binarysearch;

/**
 * https://leetcode.com/problems/peak-index-in-a-mountain-array/
 */
public class PeakIndexMountainArray {

    public static int peakIndexInMountainArray(int[] A) {
        int lo = 0, hi = A.length - 1;
        // continually narrow search until just one element remains
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (A[mid] < A[mid + 1])
                lo = mid + 1;
            else
                hi = mid;
        }
        return lo;
    }

    public static void main(String[] args) {
        System.out.println(peakIndexInMountainArray(new int[]{10, 20, 15, 2, 23, 90, 67}));
    }
}
