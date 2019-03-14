package com.leetcode.string;

public class CustomSortString {

    static String customSortString(String S, String T) {

        int[] count = new int[26];
        for(char c : T.toCharArray()) {
            ++count[c - 'a'];
        }

        StringBuilder sb = new StringBuilder();
        for(char c : S.toCharArray()) {
            while(count[c - 'a']-- > 0) {
                sb.append(c);
            }
        }

        for(char c = 'a'; c <= 'z'; c++) {
            while(count[c - 'a']-- > 0) {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(customSortString("cba", "abcd"));
    }
}
