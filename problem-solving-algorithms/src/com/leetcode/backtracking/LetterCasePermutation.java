package com.leetcode.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode.com/problems/letter-case-permutation/
 *
 * Recursive backtrack problem trying all possibilities. Can be solved in DFS or BFS.
 */
public class LetterCasePermutation {
    public static List<String> letterCasePermutation(String S) {
        List<String> perms = new ArrayList<>();
        backtrack(perms, S.toCharArray(), 0);
        return perms;
    }

    private static void backtrack(List<String> perms, char[] chs, int idx) {
        if(chs.length == idx) {
            perms.add(new String(chs));
        } else {
            if(Character.isLetter(chs[idx])) {
                chs[idx] = Character.toLowerCase(chs[idx]);
                backtrack(perms, chs, idx+1);
                chs[idx] = Character.toUpperCase(chs[idx]);
            }
            backtrack(perms, chs, idx+1);
        }
    }

    public static List<String> letterCasePermutationIter(String S) {
        if(S == null || S.length() == 0)
            return new LinkedList();
        Queue<String> queue = new LinkedList<>();
        queue.offer(S);

        for(int i = 0; i < S.length(); i++) {
            if(Character.isDigit(S.charAt(i)))
                continue;
            int size = queue.size();
            for(int j = 0; j < size; j++) {
                String str = queue.poll();
                char[] chs = str.toCharArray();

                chs[i] = Character.toLowerCase(chs[i]);
                queue.offer(String.valueOf(chs));

                chs[i] = Character.toUpperCase(chs[i]);
                queue.offer(String.valueOf(chs));
            }
        }
        return new LinkedList(queue);
    }

    public static void main(String[] args) {
        //System.out.println(letterCasePermutation("a1b2"));
        System.out.println(letterCasePermutationIter("a1b2"));
    }
}
