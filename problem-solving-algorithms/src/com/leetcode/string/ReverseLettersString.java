package com.leetcode.string;

public class ReverseLettersString {
    public static void main(String[] args)
    {
        String stringInput = "This is Anand Raghunathan y'all";
        char[] charInput = {'h','e','l','l','o'};
        System.out.println("Reversed String Input: ");
        System.out.println(reverseString(stringInput.toCharArray()));
        System.out.println("Reversed Char Input: ");
        System.out.println(reverseString(charInput));

        String input = "Advait Anand";
        char[] try1 = input.toCharArray();

        System.out.println("char array: " +try1);
        System.out.println("char array length: " +try1);

        for (int i = try1.length-1; i>=0; i--)
            System.out.print(try1[i]);
    }

    public static char[] reverseString(char[] s) {
        int i = 0;
        int j = s.length - 1;
        while (i <= j) {
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            i++; j--;
        }
        return s;
    }
}