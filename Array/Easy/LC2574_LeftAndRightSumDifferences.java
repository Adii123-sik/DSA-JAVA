package Array.Easy;

/*
Problem: Left and Right Sum Differences
LeetCode: 2574
Difficulty: Easy
Main Topic: Array
Optimized Pattern: Prefix Sum / Running Sum

Approach:
Sabse pehle poore nums array ka total sum calculate karenge.

Har index i par:
- leftSum me current index se pehle wale elements ka sum hoga.
- rightSum ko totalSum se calculate karenge.

Formula:
rightSum = totalSum - leftSum - nums[i]

Current element ko minus isliye karte hain kyunki current element
na left side me aata hai aur na right side me.

Phir:
answer[i] = Math.abs(leftSum - rightSum)

Current index process hone ke baad nums[i] ko leftSum me add karenge,
kyunki next index ke liye current element left side ka part ban jayega.

Why Running Sum?
Because har index par left aur right side ko dobara traverse karne ki
zarurat nahi padti. Hum previous leftSum ko reuse karte hain.

Time Complexity: O(n)
Space Complexity: O(n)
*/

import java.util.Arrays;

public class LC2574_LeftAndRightSumDifferences {

    public static int[] leftRightDifference(int[] nums) {

        int[] answer = new int[nums.length];

        int totalSum = 0;
        int leftSum = 0;

        // Calculate total sum
        for (int num : nums) {
            totalSum += num;
        }

        // Calculate left and right difference
        for (int i = 0; i < nums.length; i++) {

            int rightSum = totalSum - leftSum - nums[i];

            answer[i] = Math.abs(leftSum - rightSum);

            leftSum += nums[i];
        }

        return answer;
    }

    public static void main(String[] args) {

        int[] nums = {10, 4, 8, 3};

        int[] result = leftRightDifference(nums);

        System.out.println("Result: " + Arrays.toString(result));
    }
}