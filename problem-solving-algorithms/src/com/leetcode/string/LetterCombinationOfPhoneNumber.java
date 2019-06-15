package com.leetcode.string;

import java.util.*;

/**
 *  RUNTIME: O(3^N x 4^M) where N is the number of digits in the input that maps to 3 letters (e.g. 2, 3, 4, 5, 6, 8)
 *  and M is the number of digits in the input that maps to 4 letters (e.g. 7, 9),
 *  and N+M is the total number digits in the input.
 *
 *  SPACE: O(3^N x 4^M) since one has to keep O(3^N x 4^M) solutions.
 *
 *
 *  We naturally backtrack when we traverse a tree. Here it uses a stack because it's a recursive function.
 *  So when we pop, we backtrack. Imagine the following input "234". You have a stack where you push the function
 *  backtrack multiple times. Each call contains a combination of letters and we're trying to find the valid ones
 *  (=contains k number of letters where k=length of the input). The stack trace would look like that
 *  for example where ">>" means push (= go forward) and "<<" means pop (= backtrack). Then finally, "[ ]" means
 *  we found a valid combination.
 *
 * Root >> "a" >> "ad" >> ["adg"] << "ad" >> ["adh"] << "ad" >> ["adi"] << "ad" << "a" << Root >>
 *     "b" >> "bd" >> ["bdg"] << "bd" >> ["bdh"] << "bd" >> ["bdi"] << "bd" << "b" << Root >> "c" >> etc.
 *
 * That's how we backtrack in this solution. We simply pop... (I shorten the stack trace for you to understand).
 * The term "backtracking" is confusing because people think we only traverse a tree.
 * But it also means we have to accept and/or ignore certain values along the way in order to build the final output.
 * That's what the backtracking algorithm is all about.
 *
 */
public class LetterCombinationOfPhoneNumber {
    static Map<String, String> phone = new HashMap<String, String>() {{
        put("2", "abc");
        put("3", "def");
        put("4", "ghi");
        put("5", "jkl");
        put("6", "mno");
        put("7", "pqrs");
        put("8", "tuv");
        put("9", "wxyz");
    }};

    static List<String> output = new ArrayList<String>();

    public static void backtrack(String combination, String digits) {
        // if there is no more digits to check
        if (digits.length() == 0) {
            // the combination is done
            output.add(combination);
        }
        // if there are still digits to check
        else {
            // iterate over all letters which map
            // the next available digit
            String digit = digits.substring(0, 1);
            String letters = phone.get(digit);
            for (int i = 0; i < letters.length(); i++) {
                String letter = letters.substring(i, i + 1);
                // append the current letter to the combination
                // and proceed to the next digits
                backtrack(combination + letter, digits.substring(1));
            }
        }
    }

    public static List<String> letterCombinations(String digits) {
        if (digits.length() != 0)
            backtrack("", digits);
        return output;
    }

    public static List<String> letterCombinationsIterative(String digits) {
        LinkedList<String> res = new LinkedList<>();
        // digits length check, return empty list if input is empty
        if(digits.length() == 0)
            return res;

        // Phone number keypad string array
        String[] phone = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        res.add("");

        // Iterate through the length of the input digits
        for(int i = 0; i < digits.length(); i++) {

            // Get the first character passed as the input, and then the second and so on
            int key = Character.getNumericValue(digits.charAt(i));

            // Fetch the characters with length 1 like 'a', 'b', 'c'
            while(res.peek().length() == i) {
                String combination = res.remove();
                // For each input digit, add its corresponding letter
                for(char letter : phone[key].toCharArray()) {
                    // Add the current combination and the letter
                    res.add(combination + letter);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        //System.out.println(letterCombinations("23"));
        System.out.println(letterCombinationsIterative("23"));
    }
}
