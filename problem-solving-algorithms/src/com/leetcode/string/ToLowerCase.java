package com.leetcode.string;

public class ToLowerCase {
    public static String toLowerCase(String str) {
        char[] a = str.toCharArray();
        for(int i=0; i<a.length; i++)
            if(a[i] >= 'A' && a[i] <= 'Z')
                a[i] = (char) (a[i] - 'A' + 'a');
        return new String(a);
    }

    public static void main(String[] args) {
        toLowerCase("Hello");
    }
}
