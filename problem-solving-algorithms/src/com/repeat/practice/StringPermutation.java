package com.repeat.practice;

public class StringPermutation {
    public static void main(String[] args) {
        System.out.println(isStringPermutation("dog", "god"));
    }

    public static boolean isStringPermutation(String str1, String str2) {

        if(str1.length() != str2.length())
            return false;

        int[] permute = new int[128];
        for(char s1 : str1.toCharArray())
            permute[s1]++;

        for(int i = 0; i < str2.length(); i++) {
            int val = str2.charAt(i);
            permute[val]--;
            if (permute[val] < 0)
                return false;
        }
        return true;
    }
}
