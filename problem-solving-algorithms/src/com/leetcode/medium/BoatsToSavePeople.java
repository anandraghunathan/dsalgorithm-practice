package com.leetcode.medium;

import java.util.Arrays;

public class BoatsToSavePeople {
    /**
     *
     * O[N log N) time, where N is the number of people.
     * O(n) space
     */
    public static int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);

        int boats = 0;
        int lightPerson = 0, heavyPerson = people.length - 1;

        while(lightPerson <= heavyPerson) {
            boats++;
            if(people[lightPerson] + people[heavyPerson] <= limit)
                lightPerson++;
            heavyPerson--;
        }
        return boats;
    }

    public static void main(String[] args) {
        //System.out.println(numRescueBoats(new int[] {3, 5, 3, 4}, 5));
        System.out.println(numRescueBoats(new int[] {3, 8, 7, 1, 4}, 9));
    }

}
