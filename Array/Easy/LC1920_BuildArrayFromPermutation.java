package Array.Easy;

/*
Problem: Build Array from Permutation
LeetCode: 1920
Difficulty: Easy
Main Topic: Array
Optimized Pattern: Direct Index Mapping

Approach:
Hume ek permutation array nums diya hota hai.
Ek new array ans banana hai jahan:

ans[i] = nums[nums[i]]

Sabse pehle nums[i] ki value nikalenge.
Phir us value ko dobara nums array ke index ki tarah use karenge.

Example:
nums = [0, 2, 1, 5, 3, 4]

i = 1:
nums[1] = 2
nums[nums[1]] = nums[2] = 1

Isliye ans[1] = 1

Why Direct Index Mapping?
Because har answer directly nums ke ek index ki value se mil raha hai.
Hume searching ya sorting ki zarurat nahi hai.

Time Complexity: O(n)
Space Complexity: O(n)
*/

import java.util.Arrays;

public class LC1920_BuildArrayFromPermutation {

    public static int[] buildArray(int[] nums) {

        int[] ans = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {

            int firstValue = nums[i];

            ans[i] = nums[firstValue];
        }

        return ans;
    }

    public static void main(String[] args) {

        int[] nums = {0, 2, 1, 5, 3, 4};

        int[] result = buildArray(nums);

        System.out.println("Result: " + Arrays.toString(result));
    }
}