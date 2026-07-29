package Array.Easy;

/*
Problem: Minimum Operations to Exceed Threshold Value I
LeetCode: 3065
Difficulty: Easy
Main Topic: Array
Optimized Pattern: Linear Traversal / Counting

Approach:
Hume nums array aur ek integer k diya jaata hai.

Array ke jitne elements k se chhote hain, un sabko remove
karna padega taaki remaining saare elements k ke equal
ya k se bade ho jaayen.

Isliye array ko ek baar traverse karenge.

Agar:
nums[i] < k

to count ko 1 se increase kar denge.

Finally, count return karenge.

Example:
nums = [2, 11, 10, 1, 3]
k = 10

2  < 10 -> count = 1
11 >= 10 -> ignore
10 >= 10 -> ignore
1  < 10 -> count = 2
3  < 10 -> count = 3

Output:
3

Why Linear Traversal?
Because har element ko sirf ek baar check kiya ja raha hai.
Kisi sorting ya extra data structure ki zarurat nahi hai.

Time Complexity: O(n)
Space Complexity: O(1)

Here:
n = nums array ki length
*/

import java.util.Arrays;

public class LC3065_MinimumOperationsToExceedThresholdValueI {

    public static int minOperations(int[] nums, int k) {

        int count = 0;

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] < k) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {

        int[] nums = {2, 11, 10, 1, 3};
        int k = 10;

        int result = minOperations(nums, k);

        System.out.println("Array: " + Arrays.toString(nums));
        System.out.println("Threshold K: " + k);
        System.out.println("Minimum Operations: " + result);
    }
}