package com.leetcode.array;

public class FirstAndLastPositionOfElementInArray {
    // Linear search algorithm
    public int[] searchRangeL(int[] nums, int target) {
        int[] targetRange = {-1, -1};
        int n = nums.length;
        for(int i = 0; i < n; i++) {
            if(nums[i] == target) {
                targetRange[0] = i;
                break;
            }
        }
        if(targetRange[0] == -1)
            return targetRange;

        for(int i = n - 1; i >= 0; i --) {
            if(nums[i] == target) {
                targetRange[1] = i;
                break;
            }
        }
        return targetRange;
    }

    // Binary Search
    public static int[] searchRangeB(int[] nums, int target) {
        int[] targetPos = new int[2];
        targetPos[0] = findStartingIndex(nums, target);
        targetPos[1] = findEndingIndex(nums, target);
        return targetPos;
    }

    public static int findStartingIndex(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int index = -1;

        while(start <= end) {
            int mid = start + (end - start) / 2;

            if(nums[mid] == target)
                index = mid;

            if(nums[mid] >= target)
                end = mid - 1;
            else
                start = mid + 1;
        }
        return index;
    }

    public static int findEndingIndex(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int index = -1;

        while(start <= end) {
            int mid = start + (end - start) / 2;

            if(nums[mid] == target)
                index = mid;

            if(nums[mid] <= target)
                start = mid + 1;
            else
                end = mid - 1;
        }
        return index;
    }

    public static void main(String[] args) {
        for(int num : searchRangeB(new int[]{5,7,7,8,8,10}, 9)) {
            System.out.print(num + "  ");
        }
    }
}
