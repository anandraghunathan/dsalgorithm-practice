package com.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    public static List<List<String>> isPalindrome(String s) {
        List<List<String>> list = new ArrayList<>();
        isPalindrome(list, new ArrayList<>(), s, 0);
        return list;
    }

    public static void isPalindrome(List<List<String>> list, List<String> tempList, String s, int start){
        if(start == s.length())
            list.add(new ArrayList<>(tempList));
        else{
            for(int i = start; i < s.length(); i++){
                if(isPalindromeHelper(s, start, i)){
                    tempList.add(s.substring(start, i + 1));
                    isPalindrome(list, tempList, s, i + 1);
                    tempList.remove(tempList.size() - 1);
                }
            }
        }
    }

    public static boolean isPalindromeHelper(String s, int start, int end){
        while(start < end)
            if(s.charAt(start++) != s.charAt(end--))
                return false;
        return true;
    }

    public static void main(String[] args) {
        System.out.println("[");
        System.out.print("    ");
        for(List<String> str : isPalindrome("aab")) {
            System.out.print("[ ");
            for(String s : str) {
                System.out.print(s +" ");
            }
            System.out.print("]");
        }
        System.out.println("");
        System.out.println("]");
    }
}
