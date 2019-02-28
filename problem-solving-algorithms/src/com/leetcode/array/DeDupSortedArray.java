package com.leetcode.array;

public class DeDupSortedArray {
    public static int removeDuplicates(int[] nums) {
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            //System.out.println("Curr i - " + i + " and Curr j - " +j);
            if (nums[j] != nums[i]) {
                System.out.println(" \n\n Before nums["+i+"] = " +nums[i] + " Before nums["+j+"] = " +nums[j]);
                i++;
                System.out.println(" After nums["+i+"] = " +nums[i] + " After nums["+j+"] = " +nums[j]);
                for (int x = 0; x < nums.length; x++) {
                    System.out.print("");
                    System.out.print(" "+ nums[x]);
                    System.out.print("");
                }
                System.out.print("\n Removing duplicates...\n");
                nums[i] = nums[j];
                for (int x = 0; x < nums.length; x++) {
                    System.out.print("");
                    System.out.print(" "+ nums[x]);
                    System.out.print("");
                }
            }
        }
        return i + 1;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {0,0,1,1,1,2,2,3,3,4};
        System.out.println("\n \n Deduplicated array length = " +removeDuplicates(arr));
    }
}
