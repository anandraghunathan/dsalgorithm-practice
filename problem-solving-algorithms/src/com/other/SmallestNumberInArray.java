package com.other;

public class SmallestNumberInArray {

    public static int smallest(int[] arr) {
//        for(int i = 0; i < arr.length-1; i++) {
//            for (int j = 1; j < arr.length-1; j++) {
//                int temp = 0;
//                if (arr[j] < arr[i]) {
//                    temp = arr[j];
//                    arr[j] = arr[i];
//                    arr[i] = temp;
//                }
//            }
//        }
//        return arr[2];
        int min = arr[0];
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] < min)
                min = arr[i];
        }
        return min;
    }

    public static int secondSmallest(int[] arr) {
        int min = arr[1];
        for(int i = 1; i < arr.length; i++) {
            if(arr[i] < min)
                min = arr[i];
        }
        return min;
    }

    public static void main(String[] args) {
        System.out.println(smallest(new int[]{7,5,6,2,0,9,3,1,4}));
        System.out.println(secondSmallest(new int[]{7,5,6,2,0,9,3,1,4}));
    }
}
