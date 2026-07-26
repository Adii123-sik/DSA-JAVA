package Array.Easy;

/*
Problem: Find Numbers with Even Number of Digits
LeetCode: 1295
Difficulty: Easy
Main Topic: Array
Optimized Pattern: Digit Counting

Approach:
Hume integers ka ek nums array diya jaata hai.

Har number ke total digits count karenge.
Digit count karne ke liye number ko repeatedly 10 se divide karenge.

Example:
number = 345

345 / 10 = 34
34 / 10  = 3
3 / 10   = 0

Isliye 345 me total 3 digits hain.

Digits count karne ke baad modulus operator se check karenge:

digitCount % 2 == 0

Agar remainder 0 hai, to digit count even hai aur answer ko
1 se increase kar denge.

Finally, even number of digits wale elements ka total count
return karenge.

Example:
nums = [12, 345, 2, 6, 7896]

12   -> 2 digits -> Even
345  -> 3 digits -> Odd
2    -> 1 digit  -> Odd
6    -> 1 digit  -> Odd
7896 -> 4 digits -> Even

Output: 2

Why Digit Counting?
Because repeatedly 10 se divide karne par har iteration me
number ka ek digit remove ho jaata hai.

Time Complexity: O(n * d)
Space Complexity: O(1)

Here:
n = nums array ki length
d = ek number me maximum digits
*/

import java.util.Arrays;

public class LC1295_FindNumbersWithEvenNumberOfDigits {

    public static int findNumbers(int[] nums) {

        int answer = 0;

        for (int num : nums) {

            int digitCount = 0;

            while (num > 0) {
                num = num / 10;
                digitCount++;
            }

            if (digitCount % 2 == 0) {
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {

        int[] nums = {12, 345, 2, 6, 7896};

        int result = findNumbers(nums);

        System.out.println("Array: " + Arrays.toString(nums));
        System.out.println("Result: " + result);
    }
}