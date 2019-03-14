package com.other;

import java.util.HashMap;
import java.util.Map;

public class ZeroInSubArrayMap {

    static String findZeroInSubArrayInMap(int[] arr) {
        int sum = 0;
        Map<Integer, Integer> zeroMap = new HashMap<>();

        for(int i = 0; i < arr.length; i++) {
            sum += arr[i];

            if(sum == 0 || zeroMap.get(sum) != null) {
                return "Found zero sum at indexes: " +(i - 1)+ " and " +i;
            }
            zeroMap.put(sum, i);
        }

        return "No zero sub-array found";
    }

    public static void main(String args[]) {
        System.out.print(findZeroInSubArrayInMap(new int[]{-2, -1, 2, 1, 4, 5, -5}));
        System.out.println("\n");
    }
}
