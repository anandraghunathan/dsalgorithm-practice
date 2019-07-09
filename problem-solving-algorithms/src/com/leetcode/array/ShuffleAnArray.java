package com.leetcode.array;

import java.util.Random;

/**
 * https://leetcode.com/problems/shuffle-an-array/
 */
public class ShuffleAnArray {
    static int[] array;
    static int[] original;

    static Random random = new Random();

    public ShuffleAnArray(int[] nums) {
        // Instantiating array to nums and original to nums clone
        array = nums;
        original = nums.clone();
    }

    /** Resets the array to its original configuration and return it. */
    public static int[] reset() {
        // Resetting array to its original configuration
        array = original;
        original = original.clone();
        return array;
    }

    /** Generates a random number between given min and max based on the current index vs max array index */
    public static int randomRange(int min, int max) {

        // + min is because it increases the randomness even better
        return random.nextInt(max - min) + min;
    }

    /** Swapping the numbers inside the array */
    public static void swapAt(int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    /** Returns a random shuffling of the array. */
    public static int[] shuffle() {
        for(int i = 0; i < array.length; i++) {
            swapAt(i, randomRange(i, array.length));
        }
        return array;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        ShuffleAnArray sf = new ShuffleAnArray(nums);
        System.out.print("Reset: ");
        for(int r: reset()) {
            System.out.print(r +", ");
        }
        System.out.println();
        System.out.print("Shuffle: ");
        for(int s: shuffle()) {
            System.out.print(s+ ", ");
        }
        System.out.println();
    }
}
