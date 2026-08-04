package Array.Easy;

/*
Problem: Sum of Unique Elements
LeetCode: 1748
Difficulty: Easy
Main Topic: Array
Optimized Pattern: Frequency Counting

Approach:
Hume nums array diya jaata hai.

Hume sirf un elements ka sum return karna hai jo array me
exactly ek baar present hain.

Sabse pehle frequency array ki help se har number ka
count store karenge.

LeetCode constraints ke according nums[i] ki value
1 se 100 ke beech hoti hai.

Isliye:
int[] frequency = new int[101];

Har number num ke liye:
frequency[num]++;

Uske baad nums array ko dobara traverse karenge.

Agar kisi number ki frequency 1 hai:
frequency[num] == 1

toh us number ko sum me add kar denge.

Example:
nums = [1, 2, 3, 2]

Frequency:
1 -> 1 time
2 -> 2 times
3 -> 1 time

Unique Elements:
1 and 3

Sum:
1 + 3 = 4

Output:
4

Why Frequency Counting?
Frequency array se hum efficiently check kar sakte hain ki
har element array me kitni baar present hai.

Time Complexity: O(n)
Space Complexity: O(1)

Space O(1) isliye hai kyunki frequency array ka size
fixed 101 hai aur input size ke saath increase nahi hota.
*/

import java.util.Arrays;

public class LC1748_SumOfUniqueElements {

    public static int sumOfUnique(int[] nums) {

        int[] frequency = new int[101];

        // Count frequency of every number
        for (int num : nums) {
            frequency[num]++;
        }

        int sum = 0;

        // Add only unique elements
        for (int num : nums) {

            if (frequency[num] == 1) {
                sum += num;
            }
        }

        return sum;
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 2};

        int result = sumOfUnique(nums);

        System.out.println("Array: " + Arrays.toString(nums));
        System.out.println("Sum of Unique Elements: " + result);
    }
}