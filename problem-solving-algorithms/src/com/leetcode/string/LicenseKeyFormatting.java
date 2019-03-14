package com.leetcode.string;

public class LicenseKeyFormatting {
    public static String licenseKeyFormatting(String S, int K) {
        int i = S.length() - 1;
        StringBuilder sb = new StringBuilder();
        int k = 0;

        while (i >= 0) {
            char c = S.charAt(i);
            if (c != '-') {
                if (k < K) {
                    sb.append(c);
                    k++;
                } else {
                    k = 0;
                    sb.append('-');
                    sb.append(c);
                    k++;
                }
            }
            i--;
        }
        return sb.reverse().toString().toUpperCase();
    }

    public static void main(String[] args) {
        System.out.println(licenseKeyFormatting("IK2-5g-3-J", 4));
    }
}