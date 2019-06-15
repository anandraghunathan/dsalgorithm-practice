package com.leetcode.string;

import java.util.HashMap;
import java.util.Map;

public class FirstUniqueCharacter {
    public static int firstUniqChar(String s) {
        int[] arr = new int[26];
        int n = s.length();
        for(int i = 0; i < n; i++)
            arr[s.charAt(i) - 'a']++;
        for(int i = 0; i < n; i++)
            if(arr[s.charAt(i) - 'a'] == 1)
                return i;
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(firstUniqChar("loveleetcode"));
    }
}
