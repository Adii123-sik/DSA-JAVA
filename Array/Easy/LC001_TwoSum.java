package Array.Easy;

/*
Problem: Two Sum
LeetCode: 1
Difficulty: Easy
Main Topic: Array
Optimized Pattern: HashMap / Hashing

Approach:
Use HashMap to store visited numbers and their indexes.
For every number, check whether target - current number already exists.

Time Complexity: O(n)
Space Complexity: O(n)
*/

import java.util.*;

public class LC001_TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map=new HashMap<>();

        for(int i=0;i<nums.length;i++){
            int required=target-nums[i];

            if(map.containsKey(required)){
                return new int[]{map.get(required),i};
            }

            map.put(nums[i],i );
        }

        return new int[]{-1,-1};
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;

        System.out.println(Arrays.toString(twoSum(nums, target)));
    }
}