package com.leetcode.array;

import java.util.HashMap;
import java.util.Map;

/**
 *  https://leetcode.com/problems/majority-element
 */
public class MajorityElement {
    /**
     *  Boyer Moore Voting Algorithm
     *
     *  Time  : O(n), Boyer-Moore performs constant work exactly n times, so the algorithm runs in linear time.
     *
     *  Space : O(1), no extra space
     *
     */
    // 7, 7, 5, 7, 5, 1, 5, 7, 5, 5, 7, 7, 7, 7, 7, 7
    public static int majorityElementBMVA(int[] nums) {
        int count = 0;
        Integer candidate = null;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }

        if(count == 0)
            return -1;

        return count > nums.length/2 ? candidate : -1;
    }


    /**
     *  HashMap & logic
     *
     *  Time  : O(N)
     *  Space : O(N)
     */
    public static int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for(int candidate : map.keySet()) {
            int candidateCount = map.get(candidate);
            if(candidateCount > nums.length / 2)
                return candidate;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(majorityElementBMVA(new int[]{2,1,2,4,7}));
    }
}
