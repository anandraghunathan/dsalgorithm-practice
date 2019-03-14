package com.leetcode.array;

import java.util.ArrayList;
import java.util.List;

public class MajorityElementsMoreThanOne {
    public static List<Integer> majorityElements(int[] nums) {
        int count = 0;
        List<Integer> candidates = new ArrayList<>();

        for(int num : nums) {
            if(!candidates.contains(num)) {
                candidates.add(num);
            }

            count += (candidates.contains(num)) ? 1 : -1;
        }
//        for(int i = 0; i < nums.length; i++) {
//            if(!candidates.contains(nums[i]) && candidates.get(i) != nums[i]) {
//                candidates.remove(nums[i]);
//            }
//        }
        return candidates;
    }

    public static void main(String[] args) {
        System.out.println(majorityElements(new int[]{3,2,3}));
    }
}
