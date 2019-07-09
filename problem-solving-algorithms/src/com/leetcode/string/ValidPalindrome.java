package com.leetcode.string;

public class ValidPalindrome {
    /*
     * Traverse the String by having two pointers head and tail, one from left to right
     * and the other from right to left. Ignore the special characters that are not letters
     * or digits. When a character is found, check if left and right are the same by converting
     * into lowercase, otherwise return false.
     */
    public static boolean isPalindrome(String s) {
        if(s.isEmpty())
            return true;

        int head = 0;
        int tail = s.length() - 1;
        char cHead, cTail;

        while(head < tail) {
            cHead = s.charAt(head);
            cTail = s.charAt(tail);

            if(!Character.isLetterOrDigit(cHead))
                head++;

            else if(!Character.isLetterOrDigit(cTail))
                tail--;

            else {
                if(Character.toLowerCase(cHead) != Character.toLowerCase(cTail)) {
                    return false;
                }
                head++;
                tail--;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("\"A man, a plan, a canal: Panama\""));
    }
}
