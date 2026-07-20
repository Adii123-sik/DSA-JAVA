package Array.Easy;

import java.util.Arrays;

/*

Problem: Squares of a Sorted Array
LeetCode: 977
Difficulty: Easy
Main Topic: Array
Optimized Pattern: Two Pointers


Approach:

Hume ek sorted integer array diya gaya hai jisme negative aur positive
dono numbers ho sakte hain.

Negative number ka square bhi bada ho sakta hai, isliye largest square
array ke left end ya right end par milega.

Hum left aur right naam ke do pointers banayenge.

Dono pointers ke elements ka square compare karenge aur jo square bada
hoga, use result array ke last available index par store kar denge.

Uske baad selected pointer ko move karenge.

Result array ko right se left fill karne par hume sorted squares mil jayenge.


Time Complexity: O(n)
Space Complexity: O(n)

*/


public class LC977_SquaresOfASortedArray {

    public static int[] sortedSquares(int[] nums) {

        int left = 0;
        int right = nums.length - 1;

        int[] result = new int[nums.length];

        for (int i = nums.length - 1; i >= 0; i--) {

            int leftSquare = nums[left] * nums[left];
            int rightSquare = nums[right] * nums[right];

            if (leftSquare > rightSquare) {

                result[i] = leftSquare;
                left++;

            } else {

                result[i] = rightSquare;
                right--;
            }
        }

        return result;
    }


    public static void main(String[] args) {

        int[] nums = {-4, -1, 0, 3, 10};

        int[] result = sortedSquares(nums);

        System.out.println("Sorted Squares: " + Arrays.toString(result));
    }
}