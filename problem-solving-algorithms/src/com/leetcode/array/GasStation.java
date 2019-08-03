package com.leetcode.array;

/**
 * https://leetcode.com/problems/gas-station/
 *
 * Time : O(N)
 * Space: O(1)
 */
public class GasStation {
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        /*
            If sum of gas is more than sum of cost, then there must be a solution.
            And the question guaranteed that the solution is unique
        */
        int sumGas = 0, sumCost = 0, start = 0, tank = 0;
        for(int i = 0; i < gas.length; i++) {

            // Keep adding the gas at each index of the gas array
            sumGas += gas[i];

            // Keep adding the cost at each index of the gas array
            sumCost += cost[i];

            // The gas left behind in the tank is gas at index minus the cost at the same index
            tank += gas[i] - cost[i];

            /*
                Tank can't be negative cause it means the car wont reach the destination.
                Therefore, reset the tank and move the start to the next index

            */
            if(tank < 0) {
                start = i + 1;
                tank = 0;
            }
        }

        if(sumGas < sumCost)
            return -1;
        else
            return start;
    }

    public static void main(String[] args) {
        System.out.println(canCompleteCircuit(new int[]{1,2,3,4,5}, new int[]{3,4,5,1,2}));
    }
}
