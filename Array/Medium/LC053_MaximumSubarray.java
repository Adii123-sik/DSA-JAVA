package Array.Medium;

/*
Problem: Maximum Subarray
LeetCode: 53
Difficulty: Medium
Main Topic: Array
Optimized Pattern: Kadane's Algorithm

Approach:
Hume continuous subarray ka maximum sum nikalna hai.

Kadane's Algorithm me hum current subarray sum track karte hain.
Har index par decide karte hain:
1. Ya to current element se new subarray start karo
2. Ya previous subarray me current element add karo

currentSum = max(nums[i], currentSum + nums[i])
maxSum = max(maxSum, currentSum)

Why Kadane's Algorithm?
Because maximum subarray sum ko single pass me O(n) time me find kar sakte hain.

Time Complexity: O(n)
Space Complexity: O(1)
*/

public class LC053_MaximumSubarray {
    public static int maxSubArraySum(int[] nums) {
        int currSum = nums[0];
        int maxSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            currSum=Math.max(nums[i], currSum+nums[i]);
            maxSum=Math.max(maxSum, currSum);
        }
    return maxSum;
    }

    public static void main(String[] args) {

        int arr[]={1};

        System.out.println(maxSubArraySum(arr));

    }
}
