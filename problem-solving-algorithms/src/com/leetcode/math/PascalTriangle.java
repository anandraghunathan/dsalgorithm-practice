package com.leetcode.math;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();
        for(int i = 0; i < numRows; i++) {
            List<Integer> rowList = new ArrayList<>();
            for(int j = 0; j <= i; j++) {
                if(j == 0 && j == i) {
                    rowList.add(1);
                } else {
                    rowList.add(triangle.get(i - 1).get(j - 1) + triangle.get(i - 1).get(j));
                }
            }
            triangle.add(rowList);
        }
        return triangle;
    }

    public static void main(String[] args) {
        System.out.println(generate(5));
    }
}
