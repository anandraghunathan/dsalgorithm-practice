package com.leetcode.string;

public class RerverseWordsString {
    public static void main(String[] args) {
        String [] stringArray = "T".split(" ");

        //char [] charArray = input.toCharArray();

        String finalString = "";

        System.out.println(stringArray.length);
        System.out.println(stringArray.length-1);
        for(int i=stringArray.length; i>=0; i--) {
            System.out.println("Counter: " +i);
            System.out.println("Array: " +stringArray[i]);
           // finalString += s[i] + " ";
           finalString += stringArray[i] + " ";
        }

        System.out.println("Reversed String is : " +finalString.substring(0, finalString.length()-1));
        //System.out.println(reverseWords("This is Anand Raghunathan y'all"));

    }

//    public static String reverseWords(String s) {
//        String[] stringArray = s.split(" ");
//
//        String finalString = "";
//
//        for(int i = stringArray.length-1; i >= 0; i--) {
//            finalString += stringArray[i].trim();
//        }
//        return finalString;
//    }
}
