package com.leetcode.binarysearch;

/** https://leetcode.com/problems/find-peak-element/ */
public class FindPeakElement {
    /**
     * What we are essentially doing is going in the direction of the rising slope(by
     * choosing the element which is greater than current). How does that guarantee the
     * result? Think about it, there are 2 possibilities.a) rising slope has to keep
     * rising till end of the array b) rising slope will encounter a lesser element and
     * go down.
     *
     * In both scenarios we will have an answer. In a) the answer is the end element
     * because we take the boundary as -INFINITY b) the answer is the largest element
     * before the slope falls.
     */
    public static int findPeakElement(int[] nums) {
        /**
         * For example an array [1, 2, 3, 4, 5] with the mid as 3, will be reduced to 4, 5 as 3 lies on a rising slope.
         * Therefore, the peak should exist on the right of 3, so 4 becomes lo and hi remains the same 5.
         * Now 4 becomes the mid for this 4, 5 sub-array, since 4 lies on a rising slope, further
         * reducing the search space to 5, which is returned as the peak element
         */
        int lo = 0;
        int hi = nums.length - 1;

        // continually narrow search until just one element remains
        while(lo < hi) {
            int mid = (lo + hi) / 2;
            if(nums[mid] < nums[mid + 1]) { // peak index is after mid.
                lo = mid + 1;
            } else if(nums[mid + 1] < nums[mid]) { // peak index is before mid.
                hi = mid;
            }
        }
        return lo;
    }

    public static void main(String[] args) {
        System.out.println(findPeakElement(new int[]{1,2,3,1}));
    }

}
