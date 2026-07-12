package Strings.Easy;
/*
Problem: Capitalize the Title
LeetCode: 2129
Difficulty: Easy
Main Topic: String
Optimized Pattern: String Traversal

Approach:
Hume given title ke har word ko LeetCode ke rules ke according
capitalize karna hai.

Rules:
1. Agar word ki length 1 ya 2 hai:
   - Poore word ko lowercase me convert karna hai.

2. Agar word ki length 3 ya usse zyada hai:
   - Word ke first character ko uppercase karna hai.
   - Baaki sabhi characters ko lowercase karna hai.

Example:
Input:
"First leTTeR of EACH Word"

Words:
"First"  -> Length 5 -> First
"leTTeR" -> Length 6 -> Letter
"of"     -> Length 2 -> of
"EACH"   -> Length 4 -> Each
"Word"   -> Length 4 -> Word

Output:
"First Letter of Each Word"

Important:
Har word ka first letter uppercase nahi karna hai.

Agar word ki length 1 ya 2 hai, toh woh complete lowercase rahega.

Example:
"is" -> is
"of" -> of
"a"  -> a

String Methods Used:

split(" "):
Sentence ko spaces ke according alag-alag words me divide karta hai.

toLowerCase():
Poore word ko lowercase me convert karta hai.

substring(1):
Word ke index 1 se last tak ke characters return karta hai.

Character.toUpperCase():
Character ko uppercase me convert karta hai.

Time Complexity: O(n)
Space Complexity: O(n)
*/

public class LC2129_CapitalizeTheTitle {

    public static String capitalizeTitle(String title) {

        // Title ko words me divide karo
        String[] words = title.split(" ");

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < words.length; i++) {

            // Sabse pehle poore word ko lowercase karo
            String word = words[i].toLowerCase();

            // Agar word ki length 3 ya usse zyada hai
            if (word.length() > 2) {

                // First character ko uppercase karo
                char firstCharacter =
                        Character.toUpperCase(word.charAt(0));

                sb.append(firstCharacter);

                // First character ke baad remaining word append karo
                sb.append(word.substring(1));

            } else {

                // Length 1 ya 2 hai toh complete lowercase append karo
                sb.append(word);
            }

            // Last word ke baad space add nahi karna
            if (i < words.length - 1) {

                sb.append(" ");
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {

        String title = "First leTTeR of EACH Word";

        String result = capitalizeTitle(title);

        System.out.println("Original Title: " + title);
        System.out.println("Capitalized Title: " + result);
    }
}