package Array.Easy;

/*
Problem: Plus One
LeetCode: 66
Difficulty: Easy
Main Topic: Array
Optimized Pattern: Carry Simulation

Approach:
Number array ke form me diya hota hai.
Hume last digit se plus one karna hai.
Agar digit 9 nahi hai, to simply +1 karke return kar denge.
Agar digit 9 hai, to usko 0 karenge aur carry previous digit me jayegi.
Agar saare digits 9 hain, jaise [9,9,9], to new array banana padega [1,0,0,0].

Why Carry Simulation?
Because addition hamesha right side se hoti hai aur carry left side me move hoti hai.

Time Complexity: O(n)
Space Complexity: O(1) normally, O(n) only when all digits are 9
*/

import java.util.Arrays;

public class LC066_PlusOne {

    public static int[] plusOne(int[] digits) {

        for (int i = digits.length - 1; i >= 0; i--) {

            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }

            digits[i] = 0;
        }

        int[] result = new int[digits.length + 1];
        result[0] = 1;

        return result;
    }

    public static void main(String[] args) {
        int[] digits = {1, 2, 3};

        int[] result = plusOne(digits);

        System.out.println("Result: " + Arrays.toString(result));
    }
}