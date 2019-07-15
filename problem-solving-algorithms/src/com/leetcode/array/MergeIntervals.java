package com.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/merge-intervals
 */
public class MergeIntervals {
    public static int[][] merge(int[][] intervals) {
        if(intervals.length <= 1)
            return intervals;

        /**
            Sorting the array. So if the given array is {15,18}, {8,10}, {1,3}, {2,6},
            it will be sorted to {1,3}, {2,6}, {8,10}, {15,18}. Lambda expression is
            used for the comparator that compares the first index of each pair to
            re-arrange/ sort the input array in an ascending order
        */
        Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));

        List<int[]> result = new ArrayList();

        // Take the first index of the 2D array
        int[] oldInterval = intervals[0];

        // Add the first index of the 2D array and add it to the result list
        result.add(oldInterval);

        // Iterate through the intervals array to compare the intervals between each element
        for(int[] newInterval : intervals) {

            /**
             Comparison between oldInterval - "[1, 3]", and newInterval - "[2, 6]"
             So, comparison between oldInterval's second index (first pair in the
             input array) - 3, and newIntervals's zeroth index (second pair in the
             input array) - 2.

             1. If condition, we find the max of oldInterval's
             first index and newInterval's first index. and assign it back to the first
             index of the oldInterval.
             2. Else condition, we assign the newInterval to the oldInterval for future
             comparison against new pairs of the input array, and add the newInterval
             pair to the result list
             */
            if(newInterval[0] <= oldInterval[1]) { // Overlapping intervals, move the end if needed
                oldInterval[1] = Math.max(oldInterval[1], newInterval[1]);
            } else {                               // Disjoint intervals, add the new interval to the list
                oldInterval = newInterval;
                result.add(newInterval);
            }
        }
        // Finally return the result list as an array with the result size as the index
        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {
        int[][] intervals = new int[][]
                                        {
                                                {15,18},
                                                {8,10},
                                                {1,7},
                                                {2,6}

                                        };
         int[][] merged = merge(intervals);

         for(int[] merge : merged) {
             System.out.print("[");
             for(int entry : merge) {
                 System.out.print(" "+entry);
             }
             System.out.print(" ]");
        }
    }
}
