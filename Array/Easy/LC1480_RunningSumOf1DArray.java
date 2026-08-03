package Array.Easy;

/*
Problem: Running Sum of 1d Array
LeetCode: 1480
Difficulty: Easy
Main Topic: Array
Optimized Pattern: Prefix Sum / In-Place Modification

Approach:
Hume nums array diya jaata hai.

Har index par starting index 0 se current index tak ke
elements ka sum store karna hai.

Original nums array ko hi update karenge.

Har index i par:
nums[i] = nums[i] + nums[i - 1]

Yahan nums[i - 1] me previous index tak ka running sum
already stored hota hai.

Loop index 1 se start hoga kyunki nums[0] ka running sum
nums[0] hi rahega.

Example:
nums = [1, 2, 3, 4]

Initially:
[1, 2, 3, 4]

i = 1:
nums[1] = 2 + 1 = 3
[1, 3, 3, 4]

i = 2:
nums[2] = 3 + 3 = 6
[1, 3, 6, 4]

i = 3:
nums[3] = 4 + 6 = 10
[1, 3, 6, 10]

Output:
[1, 3, 6, 10]

Why In-Place Prefix Sum?
Previous index par running sum already available hota hai.
Isliye extra result array banane ki zarurat nahi padti.

Time Complexity: O(n)
Extra Space Complexity: O(1)

Here:
n = nums array ki length
*/

import java.util.Arrays;

public class LC1480_RunningSumOf1DArray {

    public static int[] runningSum(int[] nums) {

        for (int i = 1; i < nums.length; i++) {
            nums[i] = nums[i] + nums[i - 1];
        }

        return nums;
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 4};

        int[] result = runningSum(nums);

        System.out.println("Running Sum: " + Arrays.toString(result));
    }
}