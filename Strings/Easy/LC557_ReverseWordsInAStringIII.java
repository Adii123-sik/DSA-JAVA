package Strings.Easy;

/*
Problem: Reverse Words in a String III
LeetCode: 557
Difficulty: Easy
Main Topic: String / StringBuilder
Optimized Pattern: Word-by-Word Reverse Traversal

Approach:
Hume ek string s di gayi hai jisme multiple words single spaces
se separated hain.

Hume har word ke characters ko reverse karna hai,
lekin words ka original order same rakhna hai.

Example 1:
Input:
s = "Let's take LeetCode contest"

Output:
"s'teL ekat edoCteeL tsetnoc"

Explanation:
Let's     -> s'teL
take      -> ekat
LeetCode  -> edoCteeL
contest   -> tsetnoc

Words ka order same rahega.
Sirf har word ke andar ke characters reverse honge.

Example 2:
Input:
s = "Mr Ding"

Output:
"rM gniD"

Approach Using StringBuilder and Indexes:
Hum string ko word-by-word traverse karenge.

Har word ke liye:
1. Current word ka starting index store karenge.
2. i ko tab tak increase karenge jab tak space ya string ka end na mil jaye.
3. Current word ke last character se starting character tak traverse karenge.
4. Har character ko result StringBuilder me append karenge.
5. Agar current word last word nahi hai, toh result me space add karenge.

Important:
Outer loop ke andar while loop bhi i ko increase karta hai.

Last word ke case me while loop i ko s.length() tak le jata hai.

Isliye ye condition use karenge:

if (i != s.length())

Agar i kisi space par ruka hai:
Space result me add hogi.

Agar i string ke end tak pahunch gaya hai:
Last word ke baad extra space add nahi hogi.

Variables:
- result:
  Final reversed string store karega.

- wordStart:
  Current word ka starting index store karega.

- i:
  Current word ke end ya space ko locate karega.

- j:
  Current word ko reverse direction me traverse karega.

Time Complexity: O(n)
Space Complexity: O(n)

Note:
LeetCode problem ke according input string me:
- Leading spaces nahi hongi.
- Trailing spaces nahi hongi.
- Words ke beech exactly one space hogi.
*/

public class LC557_ReverseWordsInAStringIII {

    public static String reverseWords(String s) {

        /*
         Final reversed string store karne ke liye.
        */
        StringBuilder result = new StringBuilder();

        /*
         Current word ka starting index.
        */
        int wordStart = 0;

        /*
         String ko word-by-word traverse karenge.
        */
        for (int i = 0; i < s.length(); i++) {

            /*
             i ko current word ke end tak le jayenge.

             While loop tab rukega jab:
             1. Space mil jayegi.
             2. String ka end aa jayega.
            */
            while (i < s.length() && s.charAt(i) != ' ') {
                i++;
            }

            /*
             i current word ke baad wali space par hai
             ya s.length() ke equal hai.

             Isliye current word ka last character:
             i - 1 index par hoga.
            */
            int wordEnd = i - 1;

            /*
             Current word ko end se start tak traverse karke
             result me append karenge.
            */
            for (int j = wordEnd; j >= wordStart; j--) {
                result.append(s.charAt(j));
            }

            /*
             Agar i string length ke equal nahi hai,
             toh current word ke baad aur words available hain.

             Isliye words ke beech space add karenge.
            */
            if (i != s.length()) {
                result.append(' ');
            }

            /*
             Next word current space ke baad start hoga.
            */
            wordStart = i + 1;
        }

        return result.toString();
    }


    public static void main(String[] args) {

        String s = "Let's take LeetCode contest";

        String reversedWords = reverseWords(s);

        System.out.println("Input: " + s);
        System.out.println("Output: " + reversedWords);
    }
}