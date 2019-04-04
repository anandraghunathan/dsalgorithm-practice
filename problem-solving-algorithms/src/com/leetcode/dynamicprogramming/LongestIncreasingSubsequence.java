package com.leetcode.dynamicprogramming;

import java.util.Arrays;

/** DP approach
 * Runtime: O(n ^ 2)
 */
public class LongestIncreasingSubsequence {
    public static int lengthOfLIS_DP(int[] nums) {
        // Base case
        if(nums.length <= 1)
            return nums.length;

        // This will be our array to track longest sequence length
        int T[] = new int[nums.length];

        // Fill each position with value 1 in the array
        for(int i=0; i < nums.length; i++)
            T[i] = 1;


        // Mark one pointer at i. For each i, start from j=0.
        for(int i=1; i < nums.length; i++)
        {
            for(int j=0; j < i; j++)
            {
                // It means next number contributes to increasing sequence.
                if(nums[j] < nums[i])
                {
                    // But increase the value only if it results in a larger value of the sequence than T[i]
                    // It is possible that T[i] already has larger value from some previous j'th iteration
                    if(T[j] + 1 > T[i])
                    {
                        T[i] = T[j] + 1;
                    }
                }
            }
        }

        // Find the maximum length from the array that we just generated
        int longest = 0;
        for(int i=0; i < T.length; i++)
            longest = Math.max(longest, T[i]);

        return longest;
    }

    /** DP approach
     * Runtime: O(n ^ 2)
     */

    public static int lengthOfLIS_DP_BinarySearch(int[] nums) {
        int[] dp = new int[nums.length];
        int len = 0;
        for (int num : nums) {
            int i = Arrays.binarySearch(dp, 0, len, num);
            if (i < 0) {
                i = -(i + 1);
            }
            dp[i] = num;
            if (i == len) {
                len++;
            }
        }
        return len;
    }

    public static void main(String[] args) {
        //System.out.println(lengthOfLIS_DP(new int[]{10,9,2,5,3,7,101,18}));
        System.out.println(lengthOfLIS_DP_BinarySearch(new int[]{0, 8, 4, 12, 2}));
    }
}
