package Array.Easy;



/*

Problem: Missing Number
LeetCode: 268
Difficulty: Easy
Main Topic: Array
Optimized By: Mathematical Sum Approach


Approach:

Array ki length ko n maan lenge.

0 se n tak numbers ka expected sum formula se nikalenge:

expectedSum = n * (n + 1) / 2

Uske baad array ke saare elements ka actual sum nikalenge.

Expected sum mein se actual sum subtract karne par
missing number mil jayega.


Time Complexity: O(n)
Space Complexity: O(1)

*/


public class LC268_MissingNumber {

    public static int missingNumber(int[] nums) {

        int n = nums.length;

        int expectedSum = n * (n + 1) / 2;
        int actualSum = 0;

        for (int i = 0; i < nums.length; i++) {
            actualSum = actualSum + nums[i];
        }

        return expectedSum - actualSum;
    }


    public static void main(String[] args) {

        int[] nums = {3, 0, 1};

        System.out.println("Missing Number: " + missingNumber(nums));
    }
}