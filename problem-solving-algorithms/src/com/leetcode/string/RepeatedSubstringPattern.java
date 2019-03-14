package com.leetcode.string;

public class RepeatedSubstringPattern {

    // O(N * M)
    public static boolean repeatedSubstringPattern(String s) {
        int l = s.length();

        for(int i = l/2; i >= 1; i--) {
            if(l % i == 0) {
                int m = l/i;
                String subS = s.substring(0, i);
                StringBuilder sb = new StringBuilder();
                for(int j = 0; j < m; j++) {
                    sb.append(subS);
                }
                if(sb.toString().equals(s)) return true;
            }
        }
        return false;
    }


    // O(N + M)
    public static boolean repeatedSubstringPatternUsingKMP(String s) {
        int[] prefix = kmp(s.toCharArray());
        int len = prefix[s.length() - 1];
        int n = s.length();
        return (len > 0 && n % (n - len) == 0);
    }

    public static int[] kmp(char[] pattern) {
        int[] lps = new int[pattern.length];
        int index = 0;

        for(int i = 1; i < pattern.length;) {
            if(pattern[i] == pattern[index]) {
                lps[i] = index + 1;
                index++;
                i++;
            } else {
                if(index != 0) {
                    index = lps[index - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }

    public static void main(String[] args) {
        System.out.println(repeatedSubstringPattern("abcdabcdabcd"));
        //System.out.println(repeatedSubstringPatternUsingKMP("abcdabcdabcd"));
    }

}
