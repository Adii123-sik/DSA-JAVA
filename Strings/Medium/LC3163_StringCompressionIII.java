package Strings.Medium;
/*
Problem: String Compression III
LeetCode: 3163
Difficulty: Medium
Main Topic: String
Optimized Pattern: String Traversal / Run-Length Encoding

Approach:
Hume given word ko compress karna hai.

Compression Rule:
- Consecutive same characters ko count karna hai.
- Pehle count append karna hai.
- Uske baad character append karna hai.
- Ek group me maximum 9 same characters hi allowed hain.

Example 1:
Input:
"abcde"

Har character ek baar aaya hai:

a -> 1a
b -> 1b
c -> 1c
d -> 1d
e -> 1e

Output:
"1a1b1c1d1e"

Example 2:
Input:
"aaaaaaaaaaaaaabb"

'a' total 14 baar hai.

Lekin ek group me maximum 9 characters allowed hain.

First 9 a:
9a

Remaining 5 a:
5a

2 b:
2b

Output:
"9a5a2b"

Important:
Agar count ko 9 par stop nahi karenge, toh output "14a2b"
aa sakta hai, jo LeetCode 3163 ke rules ke according wrong hai.

Isliye while loop me:

count < 9

condition lagana zaroori hai.

Time Complexity: O(n)
Space Complexity: O(n)
*/

public class LC3163_StringCompressionIII {

    public static String compressedString(String word) {

        StringBuilder compressedString = new StringBuilder();

        for (int i = 0; i < word.length(); i++) {

            int count = 1;

            /*
             Same consecutive characters ko count karo.

             Conditions:
             1. i last index se pehle hona chahiye.
             2. Current aur next character same hone chahiye.
             3. Count maximum 9 tak hi jaana chahiye.
            */
            while (i < word.length() - 1
                    && word.charAt(i) == word.charAt(i + 1)
                    && count < 9) {

                count++;
                i++;
            }

            // Pehle count append karo
            compressedString.append(count);

            // Uske baad character append karo
            compressedString.append(word.charAt(i));
        }

        return compressedString.toString();
    }

    public static void main(String[] args) {

        String word = "aaaaaaaaaaaaaabb";

        String result = compressedString(word);

        System.out.println("Original Word: " + word);
        System.out.println("Compressed String: " + result);
    }
}