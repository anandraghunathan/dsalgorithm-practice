package com.leetcode.array;

public class PeakIndexMountainArray {

    public static int peakIndexInMountainArray(int[] A) {
        int lo = 0, hi = A.length - 1;
        while (lo < hi) {
            int mi = lo + (hi - lo) / 2;
            if (A[mi] < A[mi + 1])
                lo = mi + 1;
            else
                hi = mi;
        }
        return lo;
    }

    public static void main(String[] args) {
        System.out.println(peakIndexInMountainArray(new int[]{10, 20, 15, 2, 23, 90, 67}));
    }
}
