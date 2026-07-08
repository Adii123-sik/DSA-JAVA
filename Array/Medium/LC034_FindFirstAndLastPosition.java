package Array.Medium;

/*
Problem: Find First and Last Position of Element in Sorted Array
LeetCode: 34
Difficulty: Medium
Main Topic: Binary Search

Approach:
- Array sorted hai.
- Target ki first position find karni hai.
- Target ki last position find karni hai.
- Dono ke liye binary search use karenge.

Time Complexity: O(log n)
Space Complexity: O(1)
*/

import java.util.Arrays;

public class LC034_FindFirstAndLastPosition {

    public static int[] searchRange(int[] nums, int target) {
        int first = findFirst(nums, target);
        int last = findLast(nums, target);

        return new int[]{first, last};
    }

    public static int findFirst(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int ans = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] == target) {
                ans = mid;
                end = mid - 1; // left side me aur first position search karo
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return ans;
    }

    public static int findLast(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int ans = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] == target) {
                ans = mid;
                start = mid + 1; // right side me aur last position search karo
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 8;

        int[] result = searchRange(nums, target);

        System.out.println(Arrays.toString(result));
    }
}