package Array.Easy;

/*
Problem: Remove Element
LeetCode: 27
Difficulty: Easy
Main Topic: Array
Optimized Pattern: Two Pointers

Approach:
Given array me jo value `val` ke equal nahi hai,
un elements ko starting positions par shift kar denge.
Pointer k valid elements ka count track karega.

Time Complexity: O(n)
Space Complexity: O(1)
*/

public class LC027_RemoveElement {

    public static int removeElement(int[] nums, int val) {

        int k = 0; // count of valid elements

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[k] = nums[i];
                k++;
            }

        }
        return k;

    }

    public static void main(String[] args) {

        int[] nums = { 3, 2, 2,1,1,6,4, 3 };
        int val = 3;

        int k = removeElement(nums, val);

        System.out.println("Valid Count: " + k);
        System.out.println("Array after removing element:");

        for (int i = 0; i < k; i++) {
            System.out.print(nums[i] + " ");
        }

    }
}
