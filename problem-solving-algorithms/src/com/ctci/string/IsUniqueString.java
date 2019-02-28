package com.ctci.string;

public class IsUniqueString {
    public static void main(String[] args) {
        System.out.println(isUniqueString("fancay"));
    }

    public static boolean isUniqueString(String str) {

        boolean[] boolArr = new boolean[128];
        for(int i = 0; i < str.length(); i++) {
            int val = str.charAt(i);
            System.out.println("i = " +str.charAt(i));
            if(boolArr[val]) {
                return false;
            }
            boolArr[val] = true;
        }
        return true;
    }
}
