package com.leetcode.array;

import java.util.HashMap;
import java.util.Map;

public class nRepeatedElement {
    public static int repeatedNTimes(int[] A) {
        Map<Integer, Integer> count = new HashMap();
        for (int x: A) {
            count.put(x, count.getOrDefault(x, 0) + 1);
        }

        for (int k: count.keySet()) {
            if (count.get(k) > 1)
                return k;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.print(repeatedNTimes(new int[]{1, 2, 5, 6}));
    }
}
