package com.leetcode.array;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {

    /** Boyer Moore Voting Algorithm */

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

        return candidate;
    }


    /** Map & Entry Set logic */
    public static int majorityElement(int[] nums) {
        Map<Integer, Integer> counts = populateMap(nums);

        Map.Entry<Integer, Integer> majorityEntry = null;

        for(Map.Entry<Integer, Integer> entry : counts.entrySet()) {
            if(majorityEntry == null || entry.getValue() > majorityEntry.getValue()) {
                majorityEntry = entry;
            }
        }
        return majorityEntry.getKey();
    }

    public static Map<Integer, Integer> populateMap(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums) {
            if(!map.containsKey(num)) {
                map.put(num, 1);
            } else {
                map.put(num, map.get(num)+ 1);
            }
        }
        return map;
    }

    public static void main(String[] args) {
        System.out.println(majorityElementBMVA(new int[]{2,1,2,3,2,1,2,3}));
    }
}
