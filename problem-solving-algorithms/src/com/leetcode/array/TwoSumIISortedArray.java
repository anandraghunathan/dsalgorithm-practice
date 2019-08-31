package com.leetcode.array;

import java.util.HashMap;
import java.util.Map;

public class TwoSumIISortedArray {
    /**
     * Hashtable approach
     *
     * Time  : O(N), worst case we will explore all the numbers of the array to find the target sum
     * Space : O(N), worst case we will store all the numbers of the array to find the target sum
     *
     */
    public int[] twoSumSlow(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < numbers.length; i++) {
            int complement = target - numbers[i];
            if(map.containsKey(complement))
                return new int[]{map.get(complement) + 1, i + 1};
            map.put(numbers[i], i);
        }
        return new int[]{};
    }

    /**
     * Binary search approach, we are reducing the number of items to explore by 1 at each step
     * Time  : Best case O(log N), worst case O(N)
     * Space : O(1), constant space cause we don't use extra space to compute the target sum
     */
    public int[] twoSumFast(int[] numbers, int target) {
        int lo = 0, hi = numbers.length - 1;
        while(numbers[lo] + numbers[hi] != target) {
            if(numbers[lo] + numbers[hi] > target)
                hi--;
            else
                lo++;
        }
        return new int[]{lo + 1, hi + 1};
    }
}
