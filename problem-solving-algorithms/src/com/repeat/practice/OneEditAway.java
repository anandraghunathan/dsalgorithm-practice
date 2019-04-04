package com.repeat.practice;

public class OneEditAway {
    static boolean oneEdit(String s, String t) {
        if(s.length() > t.length())
           return computeMatch(s, t);
        else
          return computeMatch(t, s);
    }

    static boolean computeMatch(String s, String t) {
        int unmatched = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            if(s.charAt(i) != t.charAt(i)) {
                unmatched++;
            }
        }

        return unmatched > 1 ? false : true;
    }

    public static void main(String[] args) {
        //System.out.println(oneEditAway("bales", "pale"));
        System.out.println(oneEdit("tales", "paless"));
    }

}
