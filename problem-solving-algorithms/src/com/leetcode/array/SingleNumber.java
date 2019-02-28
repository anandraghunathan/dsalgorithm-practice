package com.leetcode.array;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class SingleNumber {
    public static int singleNumber(int[] nums) {
        Map<Integer, Integer> singleMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(!singleMap.containsKey(nums[i])) {
                singleMap.put(nums[i], i);
            } else {
                singleMap.remove(nums[i]);
            }
        }
        Iterator it = singleMap.keySet().iterator();
        if(it.hasNext()) {
            return (int) it.next();
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(singleNumber(new int[]{1,2,25,1,2}));
    }
}
