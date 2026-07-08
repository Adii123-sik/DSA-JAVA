package Array.Easy;

/*
Problem: Remove Duplicates from Sorted Array
LeetCode: 26
Difficulty: Easy
Main Topic: Array
Optimized Pattern: Two Pointers

Approach:
Array already sorted hai, isliye duplicate elements side-by-side honge.
Hum ek pointer k use karenge jo unique elements ki position track karega.
Jab bhi nums[i] previous unique element se different hoga,
to usko next unique position par place kar denge.

Time Complexity: O(n)
Space Complexity: O(1)
*/

import java.util.*;

public class LC026_RemoveDuplicatesFromSortedArray {

    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int k = 1; // unique elements count

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[k - 1]) {
                nums[k] = nums[i];
                k++;
            }
        }

        return k;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2};

        int k = removeDuplicates(nums);

        System.out.println("Unique Count: " + k);
        System.out.println("Array after removing duplicates:");

        for (int i = 0; i < k; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}