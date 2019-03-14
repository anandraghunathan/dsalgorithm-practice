package com.leetcode.string;

public class DIStringMatch {
    public static int[] diStringMatch(String S) {
        int n = S.length();
        int lo = 0;
        int hi = n;
        int[] match = new int[n + 1];
        for(int i = 0; i < n; i++) {
            if(S.charAt(i) == 'I') {
                match[i] = lo++;
            } else {
                match[i] = hi--;
            }
        }
        match[n] = lo;
        return match;
    }

    public static void main(String[] args) {
        for(int di : diStringMatch("DDI"))
            System.out.println(di);
    }
}
