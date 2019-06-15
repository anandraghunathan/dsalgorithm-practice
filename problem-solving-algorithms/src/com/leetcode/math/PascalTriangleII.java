package com.leetcode.math;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PascalTriangleII {
    public static List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<>();
        for(int i = 0; i <= rowIndex; i++) {
            row.add(0, 1);
            for(int j = 1; j < row.size() - 1; j++) {
                row.set(j, row.get(j) + row.get(j + 1));
            }
        }
        return row;
    }

    public static void main(String[] args) {
        System.out.println(getRow(3));
    }
}
