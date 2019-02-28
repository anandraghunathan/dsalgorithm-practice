package com.ctci.string;

import java.util.HashMap;
import java.util.Map;

public class StringPermutation {
    public static void main(String[] args) {
        System.out.println(isPermutation("dog", "god"));
    }

    public static boolean isPermutation(String str1, String str2) {

        if (str1.length() != str2.length()) {
            return false;
        }

        Map<Integer, Character> strMap = new HashMap<>();
        for (int i = 0; i < str1.length(); i++) {
            strMap.put(i, str1.charAt(i));
        }

        if(!strMap.isEmpty()) {
            for (char strChar : str2.toCharArray()) {
                if (strMap.containsValue(strChar)) {
                    System.out.println("Strchar: "+strChar);
                    continue;
                }
                return false;
            }
        }
        return true;

//        int[] letters = new int[128];
//        char[] s_array = str1.toCharArray();
//        for (char c : s_array) {
//            letters[c]++;
//            System.out.println("Str1: "+c);
//        }
//        System.out.println();
//        for (int i = 0; i < str2.length(); i++) {
//            int c =  (int) str2.charAt(i);
//            letters[c]--;
//            System.out.println("Str2: "+c);
//            if (letters[c] < 0) {
//                return false;
//            }
//        }
//        return true;
    }
}
