package com.leetcode.math;

public class ExcelSheetColumnNumber {
    public static int titleToNumber(String s) {
        int colnum = 0;
        for(int i = 0; i < s.length(); i++)
            colnum = colnum * 26 + (s.charAt(i) - 'A' + 1);
        return colnum;
    }

    public static void main(String[] args) {
        System.out.println(titleToNumber("ZY"));
    }
}
