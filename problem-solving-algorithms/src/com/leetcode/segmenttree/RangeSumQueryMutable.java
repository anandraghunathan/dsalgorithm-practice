package com.leetcode.segmenttree;

// TODO Segment tree approach
public class RangeSumQueryMutable {
    /**
        https://leetcode.com/problems/range-sum-query-mutable

        Time  : O(n) - range sum query, O(1) - update query.
                For range sum query we access each element from the array for constant time and in the worst case we
                access n elements. Therefore time is O(n). Time of update query is O(1).

         Space : O(1). No extra space.
     */
    int[] nums;
    public RangeSumQueryMutable(int[] nums) {
        this.nums = nums;
    }

    public void update(int i, int val) {
        if(i <= nums.length - 1) {
            this.nums[i] = val;
        }
    }

    public int sumRange(int i, int j) {
        int sum = 0;
        while(i <= j) {
            sum += nums[i];
            i++;
        }
        return sum;
    }

    public static void main(String[] args) {
        RangeSumQueryMutable obj = new RangeSumQueryMutable(new int[]{1, 3, 5});
        System.out.println("Sum Range (Before Update) = " +obj.sumRange(0, 2));
        obj.update(1, 2);
        System.out.println("Sum Range (After Update) = " +obj.sumRange(0, 2));
    }
}
