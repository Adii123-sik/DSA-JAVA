package Array.Easy;

/*
Problem: Shuffle the Array
LeetCode: 1470
Difficulty: Easy
Main Topic: Array
Optimized Pattern: Alternate Array Traversal

Approach:
Hume nums array diya jaata hai jisme total 2 * n elements hote hain.

Array ka format hota hai:

[x1, x2, ... xn, y1, y2, ... yn]

Hume target array is order me banana hai:

[x1, y1, x2, y2, ... xn, yn]

Array ke first half ka element nums[i] se milega.

Array ke second half ka corresponding element
nums[i + n] se milega.

Dono elements ko alternate order me answer array me store karenge.

Example:
nums = [2, 5, 1, 3, 4, 7]
n = 3

First Half:
[2, 5, 1]

Second Half:
[3, 4, 7]

Processing:

i = 0:
nums[0] = 2
nums[0 + 3] = nums[3] = 3

answer = [2, 3]

i = 1:
nums[1] = 5
nums[1 + 3] = nums[4] = 4

answer = [2, 3, 5, 4]

i = 2:
nums[2] = 1
nums[2 + 3] = nums[5] = 7

answer = [2, 3, 5, 4, 1, 7]

Why Alternate Traversal?
Because hum first half aur second half se ek-ek element
lekar alternate order me answer array me insert kar rahe hain.

Time Complexity: O(n)
Space Complexity: O(n)

Here:
n = nums array ke first half ki length
*/

import java.util.Arrays;

public class LC1470_ShuffleTheArray {

    public static int[] shuffle(int[] nums, int n) {

        int[] answer = new int[2 * n];

        int index = 0;

        for (int i = 0; i < n; i++) {

            // First half ka element
            answer[index] = nums[i];
            index++;

            // Second half ka corresponding element
            answer[index] = nums[i + n];
            index++;
        }

        return answer;
    }

    public static void main(String[] args) {

        int[] nums = {2, 5, 1, 3, 4, 7};
        int n = 3;

        int[] result = shuffle(nums, n);

        System.out.println("Original Array: " + Arrays.toString(nums));
        System.out.println("Shuffled Array: " + Arrays.toString(result));
    }
}