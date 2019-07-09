package com.leetcode.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class IntersectionOfTwoArrays {
    public static int[] intersection(int[] nums1, int[] nums2) {
        if(nums1.length == 0 || nums2.length == 0)
            return new int[]{};
        HashMap<Integer, Integer> intersectedNumsMap = new HashMap<>();
        List<Integer> intersectedNumsList = new ArrayList<>();

        /* Iterate through the first nums1 array and add corresponding number as key,
         and its number of times (count) it's repeated as value */
        for(int i = 0; i < nums1.length; i++) {

            /* If the value to the number is NOT ALREADY present in the map,
            put the number and count 1 into the map */
            if(!intersectedNumsMap.containsKey(nums1[i]))
                intersectedNumsMap.put(nums1[i], 1);
        }

        // Iterate through the second nums2 array to compare this with the nums1 array
        for(int i = 0; i < nums2.length; i++) {
            /* If the map already contains the corresponding number && IF THE VALUE IS GREATER THAN 0 (WHICH MEANS THIS IS ALREADY ADDED TO THE RESULT LIST), add it to the array list, and deduct the count to calculate (if the same number is repeated) */
            if(intersectedNumsMap.containsKey(nums2[i]) && intersectedNumsMap.get(nums2[i]) > 0) {
                intersectedNumsList.add(nums2[i]);
                intersectedNumsMap.put(nums2[i], intersectedNumsMap.get(nums2[i]) - 1);
            }
        }

        // Form the int array to return the intersected numbers between the two arrays
        int[] res = new int[intersectedNumsList.size()];
        for(int i = 0; i < intersectedNumsList.size(); i++) {
            res[i] = intersectedNumsList.get(i);
        }
        return res;
    }

    public static void main(String[] args) {
        for(int n : intersection(new int[]{1,2,2,1}, new int[]{2,2})) {
            System.out.print(n + ", ");
        }
    }
}
