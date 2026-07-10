package Array.Easy;

import java.util.Arrays;

/*

Problem: Move Zeroes
LeetCode: 283
Difficulty: Easy
Main Topic: Array
Optimized By: Two Pointer Approach


Approach:

Hum do pointers left aur right use karenge.

Right pointer array ke har element ko check karega.
Agar nums[right] zero hai to right pointer ko aage badha denge.

Agar nums[right] non-zero hai to nums[right] aur nums[left]
ko swap kar denge.

Swap karne ke baad left aur right dono pointers ko increment karenge.

Isse saare non-zero elements starting mein aa jayenge aur
saare zero elements array ke last mein move ho jayenge.


Time Complexity: O(n)
Space Complexity: O(1)

*/


public class LC283_MoveZeros {

    public static void moveZeroes(int[] nums) {

        int left = 0;
        int right = 0;

        for (int i = 0; i < nums.length; i++) {

            if (nums[right] == 0) {

                right++;

            } else {

                int temp = nums[right];
                nums[right] = nums[left];
                nums[left] = temp;

                left++;
                right++;
            }
        }
    }


    public static void main(String[] args) {

        int[] nums = {0, 1, 0, 3, 12};

        System.out.println("Before: " + Arrays.toString(nums));

        moveZeroes(nums);

        System.out.println("After: " + Arrays.toString(nums));
    }
}