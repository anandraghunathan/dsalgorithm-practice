package com.other;

/** Not a Leetcode problem */

public class PriceDifference {

    public static int priceDifference(int[] arr) {

        int n = arr.length;
        int min = 0;
        int max = 0;

        // Only one element
        if (n == 1) {
            min = arr[0];
            max = arr[0];
        }
        // Two or more elements in the array
        else {
            if (arr[0] < arr[1]) {
                min = arr[0];
                max = arr[1];
            } else {
                min = arr[1];
                max = arr[0];
            }


            for (int i = 2; i < n; i++) {
                if (arr[i] < min) {
                    min = arr[i];
                } else if (arr[i] > max) {
                    max = arr[i];
                }
            }
        }
        return max - min;
    }

    public static int[] sortTheArray(int[] arr) {


        for (int firstUnsortedIndex = 1; firstUnsortedIndex < arr.length; firstUnsortedIndex++) {
            int newElement = arr[firstUnsortedIndex];
            int i;
            for(i = firstUnsortedIndex; i > 0 && arr[i - 1] > newElement; i--) {
                arr[i] = arr[i-1];
            }
            arr[i] = newElement;
        }
        return arr;
    }

    public static void main(String[] args) {

        // Input array
        int[] arr = new int[] {500, 100, 2332};

        // Call the method to sort the array in a non-decreasing order
        //sortTheArray(arr);

        // Find min and max values from the given array
        System.out.println("Price Difference = "+priceDifference(arr));

        // Print the price difference between the largest and smallest price
        //System.out.println("Price Difference: " +(arr[arr.length-1]-arr[0]));
    }
}
