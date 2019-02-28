package com.leetcode.array;

public class RemoveElement {
    public static int removeElement(int[] nums, int val) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            //System.out.println("Curr i - " + i + " and Curr j - " +j);
            if (nums[j] != val) {
                System.out.println(" \n\n Before nums["+i+"] = " +nums[i] + " Before nums["+j+"] = " +nums[j]);
                nums[i] = nums[j];
                i++;
                System.out.println(" After nums["+i+"] = " +nums[i] + " After nums["+j+"] = " +nums[j]);
                for (int x = 0; x < nums.length; x++) {
                    System.out.print("");
                    System.out.print(" "+ nums[x]);
                    System.out.print("");
                }
                System.out.print("\n Removing duplicates...\n");

                for (int x = 0; x < nums.length; x++) {
                    System.out.print("");
                    System.out.print(" "+ nums[x]);
                    System.out.print("");
                }
            }
        }
        for (int x = 0; x < nums.length; x++) {
            System.out.print("");
            System.out.print(" "+ nums[x]);
            System.out.print("");
        }
        return i;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {0,1,2,2,3,0,4,2};
        System.out.println("\n \n Remove the element passed as val = " +removeElement(arr, 2));
    }
}
