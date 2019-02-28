package com.ctci.string;

import java.util.HashMap;
import java.util.Map;

public class OneEditAway {
    public static void main(String[] args) {
        System.out.println(oneEditAway("bales", "pale"));
    }

    public static boolean oneEditAway(String s1, String s2) {
        int unmatched = 0;

        if (s1.equalsIgnoreCase(s2)) {
            return true;
        }

        int s1Length = s1.length();
        int s2Length = s2.length();

        if (s1Length != s2Length) {
            unmatched++;

            if (s1.length() > s2.length() && s1Length - s2Length > 1) {
                return false;
            }

            if (s2.length() > s1.length() && s2Length - s1Length > 1) {
                return false;
            }
        }

        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();

        Map<Integer, Character> compareMap = new HashMap<>();
        for (int i = 0; i < c1.length; i++) {
            compareMap.put(i, c1[i]);
        }

        for(char c : c2) {
            if(!compareMap.containsValue(c)) {
                unmatched++;
            }
        }

        if(unmatched > 1) {
            return false;
        }
        return true;
    }
}
