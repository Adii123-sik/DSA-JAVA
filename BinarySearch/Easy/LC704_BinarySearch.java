package BinarySearch.Easy;

/*
Problem: Binary Search
LeetCode: 704
Difficulty: Easy
Main Topic: Binary Search / Array
Optimized Pattern: Standard Binary Search

Approach:
Hume ek sorted integer array nums diya gaya hai aur ek integer target diya gaya hai.

Hume array me target search karna hai.

Agar target array me present hai, toh uska index return karna hai.

Agar target array me present nahi hai, toh -1 return karna hai.

Important:
Array ascending order me sorted hai.

Example 1:
Input:
nums = [-1, 0, 3, 5, 9, 12]
target = 9

Output:
4

Explanation:
Target 9 array ke index 4 par present hai.

Example 2:
Input:
nums = [-1, 0, 3, 5, 9, 12]
target = 2

Output:
-1

Explanation:
Target 2 array me present nahi hai.

Why Binary Search:
Array sorted hai, isliye hume har element ko individually check
karne ki zarurat nahi hai.

Binary Search har iteration me search range ko half kar deta hai.

Har iteration me:
1. Search range ka middle index calculate karenge.
2. Agar nums[mid] target ke equal hai, toh mid return karenge.
3. Agar nums[mid] target se bada hai, toh left side me search karenge.
4. Agar nums[mid] target se chhota hai, toh right side me search karenge.

Example:
nums = [-1, 0, 3, 5, 9, 12]
target = 9

Initial range:
start = 0
end = 5

First iteration:
mid = 2
nums[mid] = 3

3 target 9 se chhota hai.

Isliye target right side me ho sakta hai:

start = mid + 1
start = 3

Second iteration:
start = 3
end = 5
mid = 4
nums[mid] = 9

Target mil gaya.

Return:
4

Variables:
- start:
  Current search range ka starting index.

- end:
  Current search range ka ending index.

- mid:
  Current search range ka middle index.

Safe Mid Calculation:
Hum directly ye use nahi karenge:

mid = (start + end) / 2

Kyunki large values ke case me start + end integer overflow
kar sakta hai.

Isliye safe formula use karenge:

mid = start + (end - start) / 2

Time Complexity: O(log n)
Space Complexity: O(1)
*/

public class LC704_BinarySearch {

    public static int search(int[] nums, int target) {

        /*
         Search range ka starting index.
        */
        int start = 0;

        /*
         Search range ka ending index.
        */
        int end = nums.length - 1;

        /*
         Jab tak valid search range available hai,
         tab tak binary search continue karenge.
        */
        while (start <= end) {

            /*
             Safe way se middle index calculate kar rahe hain.

             Ye avoid karta hai:

             start + end ke integer overflow ko.
            */
            int mid = start + (end - start) / 2;

            /*
             Agar middle element target ke equal hai,
             toh target mil gaya.

             Target ka index return karenge.
            */
            if (nums[mid] == target) {
                return mid;
            }

            /*
             Agar middle element target se bada hai,
             toh target sirf left half me ho sakta hai.

             Mid already check ho chuka hai,
             isliye end ko mid - 1 karenge.
            */
            if (nums[mid] > target) {
                end = mid - 1;

            } else {

                /*
                 Agar middle element target se chhota hai,
                 toh target sirf right half me ho sakta hai.

                 Mid already check ho chuka hai,
                 isliye start ko mid + 1 karenge.
                */
                start = mid + 1;
            }
        }

        /*
         Loop complete hone ka matlab hai ki
         target array me present nahi hai.
        */
        return -1;
    }


    public static void main(String[] args) {

        int[] nums = {-1, 0, 3, 5, 9, 12};
        int target = 9;

        int result = search(nums, target);

        System.out.println("Array: [-1, 0, 3, 5, 9, 12]");
        System.out.println("Target: " + target);
        System.out.println("Target Index: " + result);
    }
}