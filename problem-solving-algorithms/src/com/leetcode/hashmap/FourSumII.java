package com.leetcode.hashmap;

import java.util.HashMap;
import java.util.Map;

public class FourSumII {
    /**
     Step 1 - Take the arrays A and B, and compute all the possible sums of two elements.
     Step 2 - Put the sum in the Hash map, and increase the hash map value if more than 1 pair
              sums to the same value.

     Step 3 - Compute all the possible sums of the arrays C and D.
     Step 4 - If the hash map contains the opposite value of the current sum, increase the count of
              four elements sum to 0 by the counter in the map. Which means we found a tuple that sums to 0.
     */
    public static int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> map = new HashMap();
        int res = 0;
        /** Step 1 */
        for(int i = 0; i < A.length; i++) {
            for(int j = 0; j < B.length; j++) {
                int sum = A[i] + B[j];
                /** Step 2 */
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }

        /** Step 3 */
        for(int i = 0; i < C.length; i++) {
            for(int j = 0; j < D.length; j++) {
                /** Step 4 */
                res += map.getOrDefault(-1 * (C[i] + D[j]), 0);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(fourSumCount(new int[]{1, 2}, new int[]{-2, -1}, new int[]{-1, 2}, new int[]{0, 2}));
    }
}
