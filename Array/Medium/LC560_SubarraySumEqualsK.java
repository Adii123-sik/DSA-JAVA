package Array.Medium;

/*
Problem: Subarray Sum Equals K
LeetCode: 560
Difficulty: Medium
Main Topic: Array / Prefix Sum

Approach: Brute Force
- Hume array ke andar total continuous subarrays count karne hain
  jinka sum exactly k ke equal ho.
- Har index ko subarray ka starting point maanenge.
- Inner loop se subarray ko aage expand karenge.
- Har naye starting index ke liye sum ko 0 reset karenge.
- Agar current subarray ka sum k ke equal ho jata hai,
  toh count ko increase karenge.
- Sum k ke equal milne ke baad loop ko break nahi karenge,
  kyunki array mein negative numbers bhi ho sakte hain.

Example 1:
Input:
nums = [1, 1, 1]
k = 2

Valid Subarrays:
[1, 1] -> Index 0 to 1
[1, 1] -> Index 1 to 2

Output:
2

Example 2:
Input:
nums = [1, 2, 3]
k = 3

Valid Subarrays:
[1, 2]
[3]

Output:
2

Time Complexity: O(n^2)
Space Complexity: O(1)
*/

public class LC560_SubarraySumEqualsK {

    public static int subarraySum(int[] nums, int k) {

        int count = 0;

        // Har index ko subarray ka starting point maanenge
        for (int start = 0; start < nums.length; start++) {

            int sum = 0;

            // Start index se subarray ko aage expand karenge
            for (int end = start; end < nums.length; end++) {

                sum += nums[end];

                // Agar current subarray ka sum k ke equal hai
                if (sum == k) {
                    count++;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {

        int[] nums = {1, 1, 1};
        int k = 2;

        int result = subarraySum(nums, k);

        System.out.println("Total subarrays with sum " + k + ": " + result);
    }
}