package com.leetcode.segmenttree;

public class RangeSumQueryImmutable {
    /**
     https://leetcode.com/problems/range-sum-query-immutable/

     https://www.youtube.com/watch?v=ZMOFmHBVEcg

     We can we pre-compute the cummulative sum from index 0 to k. We can use this information
     to derive Sum(i, j).

     Time : O(1) time per query, O(n) time for pre-computation. Since the cumulative sum is
     cached, each sumRange query can be calculated in O(1) time.

     Space complexity : O(n). Sum array length.
     */
    int[] sum;
    public RangeSumQueryImmutable(int[] nums) {
        if(nums.length != 0) { // Input len check for empty input
            sum = new int[nums.length + 1];
            for(int i = 0; i < nums.length; i++) {
                sum[i + 1] = nums[i] + sum[i]; // current nums element + current sum (memo) element
            }
        }
    }

    public int sumRange(int i, int j) {
        if(i == 0)
            return sum[j + 1]; // Return the entire sum if the lower bound isn't given
        /*
            After building the cache we have O(1) access to range sums.
                index        0  1  2
                nums:      [ 1, 2, 3 ]
                cache:  [ 0, 1, 3, 6 ]
                index     0  1  2  3

            Give me the sum from index 1 to index 2.
                j = 2
                i = 1

            Look at the cache:
                cache:  [ 0, 1, 3, 6 ]
                index     0  1  2  3

            We know the sum will be 5. What do we need to subtract?
                6 is at index 3. 1 is at index 1.
                j = 2
                i = 1
            So our answer will be A[j + 1] - A[i].

            If we were indexing off of 0 then we would have to do
            A[j] - A[i - 1] but we choose to add a position at the
            front of the array to make things easier.
       */
        return sum[j + 1] - sum[i]; // Upper bound + 1 (cause we start our cache at 0) - lower bound
    }

    public static void main(String[] args) {
        RangeSumQueryImmutable obj = new RangeSumQueryImmutable(new int[]{-2, 0, 3, -5, 2, -1});
        System.out.println("Sum Range 0 - 2 = " +obj.sumRange(0, 2));
        System.out.println("Sum Range 2 - 5 = " +obj.sumRange(2, 5));
        System.out.println("Sum Range 2 - 5 = " +obj.sumRange(0, 5));
    }
}
