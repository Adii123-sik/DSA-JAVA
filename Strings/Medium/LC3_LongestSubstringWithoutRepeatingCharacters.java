package Strings.Medium;

import java.util.HashSet;

/*

Problem: Longest Substring Without Repeating Characters
LeetCode: 3
Difficulty: Medium
Main Topic: String
Optimized Pattern: Sliding Window + HashSet


Approach:

Hum HashSet ka use karke current window ke unique characters
store karenge.

Left aur right naam ke do pointers banayenge.

Right pointer string ko traverse karega aur current character ko
window mein add karega.

Agar current character pehle se HashSet mein present hai, toh left
pointer se characters remove karenge jab tak duplicate character
window se remove nahi ho jata.

Duplicate remove hone ke baad current character ko HashSet mein
add karenge.

Har step par current window ki length:

right - left + 1

calculate karke maximum length update karenge.


Time Complexity: O(n)
Space Complexity: O(n)

*/


public class LC3_LongestSubstringWithoutRepeatingCharacters {

    public static int lengthOfLongestSubstring(String s) {

        HashSet<Character> set = new HashSet<>();

        int left = 0;
        int maxCount = 0;

        for (int right = 0; right < s.length(); right++) {

            char currentChar = s.charAt(right);

            while (set.contains(currentChar)) {

                set.remove(s.charAt(left));
                left++;
            }

            set.add(currentChar);

            int currentLength = right - left + 1;

            maxCount = Math.max(maxCount, currentLength);
        }

        return maxCount;
    }


    public static void main(String[] args) {

        String s = "abcabcbb";

        System.out.println(
                "Longest Substring Length: "
                        + lengthOfLongestSubstring(s)
        );
    }
}