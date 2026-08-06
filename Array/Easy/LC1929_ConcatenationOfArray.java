package Array.Easy;

/*
Problem: Concatenation of Array
LeetCode: 1929
Difficulty: Easy
Main Topic: Array
Optimized Pattern: Direct Index Mapping

Approach:
Hume nums naam ka integer array diya jaata hai.

Hume ek naya array result banana hai jisme nums array
do baar continuously present ho.

Agar:
nums = [1, 2, 1]

Toh result hoga:
[1, 2, 1, 1, 2, 1]

Result array ki length nums array ki length se double hogi:

result.length = 2 * nums.length

Har index i ke liye nums[i] ko do positions par store karenge:

result[i] = nums[i]
result[i + nums.length] = nums[i]

Example:
nums = [1, 2, 1]

i = 0:
result[0] = 1
result[3] = 1

i = 1:
result[1] = 2
result[4] = 2

i = 2:
result[2] = 1
result[5] = 1

Final Result:
[1, 2, 1, 1, 2, 1]

Why Direct Index Mapping?
Because har nums element ko result array ki exact
do positions par directly store kiya ja raha hai.

Time Complexity: O(n)
Space Complexity: O(n)

Here:
n = nums array ki length
*/

import java.util.Arrays;

public class LC1929_ConcatenationOfArray {

    public static int[] getConcatenation(int[] nums) {

        int[] result = new int[2 * nums.length];

        for (int i = 0; i < nums.length; i++) {

            result[i] = nums[i];

            result[i + nums.length] = nums[i];
        }

        return result;
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 1};

        int[] result = getConcatenation(nums);

        System.out.println("Original Array: " + Arrays.toString(nums));
        System.out.println("Concatenated Array: " + Arrays.toString(result));
    }
}