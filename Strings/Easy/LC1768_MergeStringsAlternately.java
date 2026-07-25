package Strings.Easy;

/*
Problem: Merge Strings Alternately
LeetCode: 1768
Difficulty: Easy
Main Topic: String
Optimized Pattern: Alternate Traversal

Approach:
Hume do strings word1 aur word2 di jaati hain.
Dono strings ke characters ko alternate order me result me add karna hai.

Har index i par:
- Agar word1 me character available hai, to word1.charAt(i) add karenge.
- Agar word2 me character available hai, to word2.charAt(i) add karenge.

Loop dono strings ki maximum length tak chalega.
Agar ek string pehle khatam ho jaati hai, to doosri string ke
remaining characters automatically result me add ho jayenge.

Example:
word1 = "abc"
word2 = "pqr"

Result:
a + p + b + q + c + r = "apbqcr"

Why Alternate Traversal?
Because hum dono strings ko same index se traverse karke
unke characters ko one-by-one alternate order me add kar rahe hain.

Time Complexity: O(n + m)
Space Complexity: O(n + m)
*/

public class LC1768_MergeStringsAlternately {

    public static String mergeAlternately(String word1, String word2) {

        StringBuilder result = new StringBuilder();

        int maxLength = Math.max(word1.length(), word2.length());

        for (int i = 0; i < maxLength; i++) {

            if (i < word1.length()) {
                result.append(word1.charAt(i));
            }

            if (i < word2.length()) {
                result.append(word2.charAt(i));
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {

        String word1 = "abc";
        String word2 = "pqr";

        String result = mergeAlternately(word1, word2);

        System.out.println("Result: " + result);
    }
}