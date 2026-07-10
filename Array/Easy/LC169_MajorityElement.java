package Array.Easy;

/*

Problem: Majority Element
LeetCode: 169
Difficulty: Easy
Main Topic: Array
Optimized By: Boyer-Moore Voting Algorithm


Approach:

Hum candidate aur count naam ke do variables banayenge.

Agar count 0 ho jata hai to current element ko candidate bana denge.

Agar current element candidate ke equal hai to count increment karenge,
otherwise count decrement karenge.

Majority element n/2 se zyada baar present hota hai,
isliye cancellation ke baad last mein majority element hi candidate bachega.


Time Complexity: O(n)
Space Complexity: O(1)

*/


public class LC169_MajorityElement {

    public static int majorityElement(int[] nums) {

        int candidate = 0;
        int count = 0;

        for (int i = 0; i < nums.length; i++) {

            if (count == 0) {
                candidate = nums[i];
            }

            if (nums[i] == candidate) {
                count++;
            } else {
                count--;
            }
        }

        return candidate;
    }


    public static void main(String[] args) {

        int[] nums = {2, 2, 1, 1, 1, 2, 2};

        System.out.println("Majority Element: " + majorityElement(nums));
    }
}