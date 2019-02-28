package com.leetcode.string;

public class ReverseVowels {
    public static String reverseVowels(String s) {
        char[] a = s.toCharArray();
        if(s != null || s != "") {
            int i = 0;
            int j = s.length()-1;
            while (i < j) {
                while (!isVowel(a[i])) {
                    i++;
                    continue;
                }

                while (!isVowel(a[j])) {
                    j--;
                    continue;
                }

                char temp = a[i];
                a[i] = a[j];
                a[j] = temp;
                i++;
                j--;
            }
        }
        return new String(a);
    }

    public static boolean isVowel(char a) {
        char lowerChar = Character.toLowerCase(a);
        return lowerChar == 'a' || lowerChar == 'e'
                || lowerChar == 'i' || lowerChar == 'o'
                || lowerChar == 'u' || lowerChar == 'A'
                || lowerChar == 'E' || lowerChar == 'I'
                || lowerChar == 'O' || lowerChar == 'U';
    }

    public static void main(String[] args) {
        System.out.println("Reversed Vowels Input: ");
        System.out.println(reverseVowels("leetcOdE"));
    }
}
