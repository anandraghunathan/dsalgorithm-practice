package com.leetcode.array;

/**
 * https://leetcode.com/problems/sort-colors
 */
public class SortColors {
    // Solved using 2 pointers (lo from left and hi from right) and an iterator i, swap the numbers.
    public static int[] sortColors(int[] A) {
        if(A==null || A.length<2) return null;
        int low = 0;
        int high = A.length-1;
        for(int i = low; i<=high;) {
            // Number can be 0, 1 or 2. Check for number 0
            if(A[i]==0) {
                // swap A[i] and A[low] and increment both i, low
                int temp = A[i];
                A[i] = A[low];
                A[low]=temp;
                i++;low++;
            }
            // Check for number 2
            else if(A[i]==2) {
                //swap A[i] and A[high] and high--;
                int temp = A[i];
                A[i] = A[high];
                A[high]=temp;
                high--;
            }
            // Check for number 1
            else {
                i++;
            }
        }
        return A;
    }

    public static void main(String[] args) {
        for(int a : sortColors(new int[]{2,0,2,1,1,0})) {
            System.out.print(a + ", ");
        }
    }
}
