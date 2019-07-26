package com.leetcode.array;

import java.util.HashMap;

/**
 * Created by Anand Raghunathan on 2019-07-25
 *
 * https://leetcode.com/problems/subarray-sum-equals-k
 *
 */
public class SumArraySumEqualsK {
    /**
     Without space in O(1) space. O(n ^ 2) time.

     1. Two pointers with one starting at the head of the array
     2. And another starting at the start of the first pointer
     3. Increment the sum for each index value of the second pointer
     4. Check if the sum is equal to the given k, if yes, increment the count variable
     */
    public static int subarraySumSlow(int[] nums, int k) {
        int count = 0;
        for(int i = 0; i < nums.length; i++) {
            int sum = 0;
            for(int j = i; j < nums.length; j++) {
                sum = sum + nums[j];
                if(sum == k)
                    count++;
            }
        }
        return count;
    }

    /**
     *
     * Time  : O(N)
     * Space : O(N)
     *
     *  If the cumulative sum up to two indices, say i and j is at a difference of k
     *  i.e. if sum[i] - sum[j] = k, the sum of elements lying between indices i and j is k.
     *
     *             1. Hashmap<sum[0,i - 1], frequency>
     *             2. sum[i, j] = sum[0, j] - sum[0, i - 1]    --> sum[0, i - 1] = sum[0, j] - sum[i, j]
     *                    k           sum      hashmap-key     -->  hashmap-key  =  sum - k
     *             3. now, we have k and sum.
     *                   As long as we can find a sum[0, i - 1], we then get a valid subarray
     *                  which is as long as we have the hashmap-key,  we then get a valid subarray
     *             4. Why don't map.put(sum[0, i - 1], 1) every time ?
     *                   if all numbers are positive, this is fine
     *                   if there exists negative number, there could be preSum frequency > 1
     *
     */
    public static int subarraySum(int[] nums, int k) {
        int count = 0, sum = 0;
        HashMap<Integer, Integer> map = new HashMap();

        /*
            Map is initialized to (0, 1) for those (sum - k) == 0 calculations which are valid sub-arrays
            but need to get counted. e.g. if k = 7 and sum = 7 (at second element for array is : 3, 4, 3, 8)
            at some iteration.....then sum - k = 0....this 0 will get counted in statement result += preSum.get(sum - k);
         */
        map.put(0, 1);

        for (int i = 0; i < nums.length; i++) {
            // Compute the cummulative sum up to all indices of the array
            sum += nums[i];

            /* If the map contains the element thats a difference of the
                cummlative sum till the current index and the given k, it means
                the sum is equal to k
            */
            if(map.containsKey(sum - k))
                // increment the count for the sub-array that sums to k
                count += map.get(sum - k);

            // Put new sum into the map with default value 0 if the sum (key) is not already present
            // If the sum (key) is already present, increment the value by 1.
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        // System.out.println(subarraySumSlow(new int[]{1, 1, 1}, 2));
        System.out.println(subarraySum(new int[]{1, 1, 1}, 2));
    }
}
