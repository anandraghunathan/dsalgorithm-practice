package com.leetcode.stack;

import java.util.Stack;

/**
 *  https://leetcode.com/problems/longest-absolute-file-path/
 *
 *  Time  : O(N)
 *  Space : O(N)
 */
public class LongestAbsoluteFilePath {
    public int lengthLongestPath(String input) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0); // "dummy" element
        int maxLen = 0;
        for(String s : input.split("\n")) {
            /*
                numOfTabs is the number of "\t", numOfTabs = 0  when "\t" is not found, because s.lastIndexOf("\t")
                returns -1. So normally, the first parent "dir" have numOfTabs 0.
            */
            int level = s.lastIndexOf("\t") + 1; // denoted the number of "\t"
            /*
                Level is defined as numOfTabs + 1.
                For example, in "dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext",
                dir is level 1, subdir1 and subdir2 are level 2, file.ext is level3
            */
            int currLevel = level + 1;
            /*
                The following part of code is the case that we want to consider when there are several subdirectories
                in a same level. We want to remove the path length of the directory or the file of same level and
                deeper/inner level from the current level; those we added during previous step, and calculate the path
                length of current directory or file that we are currently looking at.
            */
            while(currLevel < stack.size()) // Check if current level is less than the level
                stack.pop(); // find parent
            int currLen = stack.peek() + s.length() - level + 1; // remove "/t", add"/"
            stack.push(currLen);
            // check if it is file
            /*
                int currLen = stack.peek() + s.length() - level + 1;
                The reason for the +1 in the end is to append the ending slash if it was a directory.
                However regarding the piece of code below,
                    if (s.contains("."))
                        maxLen = Math.max(maxLen, curLen - 1);
                If we found out that the current string s we are dealing with is actually a FILE, then the
                previous \ appended by the +1 was unnecessary. Thus, -1 to remove the unnecessary \.
             */
            if(s.contains("."))
                maxLen = Math.max(maxLen, currLen - 1);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        LongestAbsoluteFilePath obj =  new LongestAbsoluteFilePath();
        //System.out.println(obj.lengthLongestPath("dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext"));
        System.out.println(obj.lengthLongestPath("dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext"));
    }
}
