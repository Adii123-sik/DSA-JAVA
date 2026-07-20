package Array.Easy;

import java.util.Arrays;
import java.util.HashSet;

/*

Problem: Intersection of Two Arrays
LeetCode: 349
Difficulty: Easy
Main Topic: Array
Optimized Pattern: HashSet


Approach:

Hume do integer arrays nums1 aur nums2 diye gaye hain.

Sabse pehle nums1 ke saare elements ko firstSet naam ke HashSet
mein store karenge.

HashSet duplicate elements ko automatically ignore kar deta hai.

Uske baad nums2 ko traverse karenge.

Agar nums2 ka current element firstSet mein present hai, toh iska
matlab woh element dono arrays mein common hai.

Common element ko resultSet mein add karenge.

ResultSet bhi HashSet hai, isliye result mein koi duplicate element
nahi aayega.

Last mein resultSet ke elements ko integer array mein convert karke
return karenge.


Time Complexity: O(n + m)

n = nums1 ki length
m = nums2 ki length

Space Complexity: O(n + m)

*/


public class LC349_IntersectionOfTwoArrays {

    public static int[] intersection(int[] nums1, int[] nums2) {

        HashSet<Integer> firstSet = new HashSet<>();
        HashSet<Integer> resultSet = new HashSet<>();

        for (int i = 0; i < nums1.length; i++) {
            firstSet.add(nums1[i]);
        }

        for (int i = 0; i < nums2.length; i++) {

            if (firstSet.contains(nums2[i])) {
                resultSet.add(nums2[i]);
            }
        }

        int[] result = new int[resultSet.size()];
        int index = 0;

        for (int number : resultSet) {
            result[index] = number;
            index++;
        }

        return result;
    }


    public static void main(String[] args) {

        int[] nums1 = {4, 9, 5};
        int[] nums2 = {9, 4, 9, 8, 4};

        int[] result = intersection(nums1, nums2);

        System.out.println(
                "Intersection: " + Arrays.toString(result)
        );
    }
}