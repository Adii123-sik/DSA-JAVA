package Strings.Medium;

/*
Problem: Reverse Words in a String
LeetCode: 151
Difficulty: Medium
Main Topic: String
Optimized Pattern: Reverse Traversal / Two Pointers

Approach:
Hume given string ke words ka order reverse karna hai.

Important:
Hume har word ke characters reverse nahi karne hain.
Sirf words ki positions reverse karni hain.

Example:

Input:
"the sky is blue"

Words:
the
sky
is
blue

Output:
"blue is sky the"

Rules:
1. String ke starting spaces remove hone chahiye.
2. String ke ending spaces remove hone chahiye.
3. Words ke beech agar multiple spaces hain,
   toh output me sirf ek space honi chahiye.
4. Har word ke characters ka order same rehna chahiye.
5. Sirf words ka order reverse hona chahiye.

Example 1:
Input:
"the sky is blue"

Output:
"blue is sky the"

Example 2:
Input:
"  hello world  "

Starting aur ending me extra spaces hain.

Output:
"world hello"

Example 3:
Input:
"a good   example"

"good" aur "example" ke beech multiple spaces hain.

Output:
"example good a"

Optimized Logic:
String ko end se start ki taraf traverse karenge.

Kyun?

Kyuki original string ka last word,
reversed result ka first word banega.

Steps:
1. String ke last index se traversal start karo.
2. Extra spaces ko skip karo.
3. Current word ka ending index store karo.
4. Peeche move karke word ka starting index find karo.
5. Word ko StringBuilder me add karo.
6. Har do words ke beech sirf ek space add karo.
7. String ke start tak process repeat karo.

Variables:
- i:
  String ko right se left traverse karta hai.

- end:
  Current word ka ending index store karta hai.

- result:
  Reversed words ko store karta hai.

Example Dry Run:

Input:
"  the sky   is blue  "

Step 1:
End ki extra spaces skip hongi.

Current word:
blue

Result:
"blue"

Step 2:
"blue" se pehle ki spaces skip hongi.

Current word:
is

Result:
"blue is"

Step 3:
Current word:
sky

Result:
"blue is sky"

Step 4:
Current word:
the

Final Result:
"blue is sky the"

Time Complexity: O(n)
Space Complexity: O(n)

Note:
Java String immutable hoti hai.
Isliye final answer create karne ke liye
StringBuilder use kiya gaya hai.
*/

public class LC151_ReverseWordsInAString {

    public static String reverseWords(String s) {

        // Reversed words ko store karne ke liye
        StringBuilder result = new StringBuilder();

        /*
         String ke last index se traversal start karenge.

         Example:
         s = "hello world"

         i initially 'd' ke index par hoga.
        */
        int i = s.length() - 1;

        /*
         Jab tak string ke saare characters
         process nahi ho jaate.
        */
        while (i >= 0) {

            /*
             Extra spaces ko skip karo.

             Ye condition handle karegi:
             1. Ending spaces
             2. Words ke beech multiple spaces
             3. Starting spaces

             Example:
             "hello     world   "
                              ↑
             Last ki spaces skip ho jayengi.
            */
            while (i >= 0 && s.charAt(i) == ' ') {
                i--;
            }

            /*
             Agar spaces skip karte-karte
             i string ke bahar chala gaya,
             toh koi word process karne ke liye nahi bacha.
            */
            if (i < 0) {
                break;
            }

            /*
             Current word ka ending index store karo.

             Example:
             s = "hello world"
                        i = 'd'

             end = 'd' ka index
            */
            int end = i;

            /*
             Current word ke starting point tak move karo.

             Jab tak current character space nahi hai,
             tab tak left side move karte rahenge.

             Example:
             "hello world"
                    ← ← ← ← ←

             i eventually "world" se pehle wali
             space ke index par aa jayega.
            */
            while (i >= 0 && s.charAt(i) != ' ') {
                i--;
            }

            /*
             Agar result me pehle se koi word present hai,
             toh next word add karne se pehle
             sirf ek space add karo.

             Isse:
             - Starting space nahi aayegi
             - Ending space nahi aayegi
             - Multiple spaces nahi aayengi
            */
            if (result.length() > 0) {
                result.append(' ');
            }

            /*
             Current complete word ko result me add karo.

             Word ka starting index:
             i + 1

             Word ka ending index:
             end

             StringBuilder append method me
             ending index exclusive hota hai.

             Isliye end + 1 pass karenge.

             Example:
             Word = "blue"

             result.append(s, startIndex, endIndex + 1);
            */
            result.append(s, i + 1, end + 1);
        }

        // StringBuilder ko String me convert karke return karo
        return result.toString();
    }

    public static void main(String[] args) {

        String s = "  the sky   is blue  ";

        String reversedString = reverseWords(s);

        System.out.println("Original String: \"" + s + "\"");

        System.out.println("Reversed String: \"" + reversedString + "\"");
    }
}