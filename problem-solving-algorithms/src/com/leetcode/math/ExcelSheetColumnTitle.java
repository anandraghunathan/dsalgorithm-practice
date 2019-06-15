package com.leetcode.math;

public class ExcelSheetColumnTitle {
    public static String convertToTitle(int n) {
        StringBuilder res = new StringBuilder();

        while(n > 0) {
            n--;
            res.append((char)('A' + n % 26));
            n = n/26;
        }
        return res.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(convertToTitle(701));
    }
}
