package Strings.Easy;

/*
Problem: Check If Two String Arrays are Equivalent
LeetCode: 1662
Difficulty: Easy
Main Topic: String
Pattern: String Building

Approach:
Hume do string arrays word1 aur word2 diye jaate hain.

Sabse pehle word1 array ke sabhi strings ko StringBuilder
word1Result me append karenge.

Uske baad word2 array ke sabhi strings ko StringBuilder
word2Result me append karenge.

Finally, dono StringBuilder objects ko String me convert karke
.equals() method se unka content compare karenge.

Agar dono combined strings same hain, to true return karenge.
Otherwise false return karenge.

Example:
word1 = ["ab", "c"]
word2 = ["a", "bc"]

word1Result = "abc"
word2Result = "abc"

Output: true

Why StringBuilder?
StringBuilder repeatedly strings join karne ke liye normal String
concatenation se zyada efficient hota hai.

Important:
Strings ka content compare karne ke liye .equals() use hota hai.
== operator references compare karta hai, content nahi.

Time Complexity: O(n + m)
Space Complexity: O(n + m)

Here n and m represent the total number of characters
present in word1 and word2.
*/

public class LC1662_CheckIfTwoStringArraysAreEquivalent {

    public static boolean arrayStringsAreEqual(
            String[] word1,
            String[] word2
    ) {

        StringBuilder word1Result = new StringBuilder();
        StringBuilder word2Result = new StringBuilder();

        for (int i = 0; i < word1.length; i++) {
            word1Result.append(word1[i]);
        }

        for (int i = 0; i < word2.length; i++) {
            word2Result.append(word2[i]);
        }

        return word1Result
                .toString()
                .equals(word2Result.toString());
    }

    public static void main(String[] args) {

        String[] word1 = {"ab", "c"};
        String[] word2 = {"a", "bc"};

        boolean result = arrayStringsAreEqual(word1, word2);

        System.out.println("Result: " + result);
    }
}