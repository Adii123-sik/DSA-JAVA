package Strings.Easy;

/*
Problem: Longest Common Prefix
LeetCode: 14
Difficulty: Easy
Main Topic: String
Optimized Pattern: Horizontal Scanning

Approach:
Hume strings ka ek array diya gaya hai.

Hume sabhi strings ke starting me aane wala
longest common part find karna hai.

String ke starting part ko prefix kaha jata hai.

Example:

Word:
flower

Possible Prefixes:

f
fl
flo
flow
flowe
flower

Input:

strs = {"flower", "flow", "flight"}

Sabhi strings ko starting se compare karenge.

flower
flow
flight

Teenon strings:

"f" se start hoti hain.

"fl" se start hoti hain.

Lekin "flo" se "flight" start nahi hoti.

Isliye longest common prefix:

"fl"

Hum array ki first string ko initial prefix maan lenge.

prefix = strs[0]

Uske baad array ki remaining strings ke saath prefix
compare karenge.

Check karenge ki current string prefix se start hoti hai
ya nahi.

Iske liye startsWith() method use karenge.

Agar current string prefix se start nahi hoti,
toh prefix ka last character remove karenge.

Example:

prefix = "flower"

Current string:

"flow"

"flow" string "flower" se start nahi hoti.

Isliye prefix ko chhota karenge:

flower
flowe
flow

Ab "flow" string "flow" se start hoti hai.

Uske baad next string "flight" ke saath compare karenge.

Current prefix:

flow

"flight" string "flow" se start nahi hoti.

Prefix ko chhota karenge:

flow
flo
fl

Ab "flight" string "fl" se start hoti hai.

Final answer:

"fl"

Agar prefix empty ho jata hai,
toh iska matlab koi common prefix nahi hai.

Isliye empty string return karenge.

Example 1:
Input:
strs = {"flower", "flow", "flight"}

Output:
"fl"

Example 2:
Input:
strs = {"dog", "racecar", "car"}

Kisi bhi string ka starting character common nahi hai.

Output:
""

Variables:

prefix:
Abhi tak mila common prefix store karta hai.

i:
Array ki remaining strings ko traverse karta hai.

strs[i]:
Current string ko represent karta hai.

Time Complexity: O(n * m)

Yahan:

n:
Strings ki total count hai.

m:
Prefix ya shortest string ki maximum length hai.

Space Complexity: O(1)
*/

public class LC14_LongestCommonPrefix {

    public static String longestCommonPrefix(String[] strs) {

        /*
         Agar array null hai ya array ke andar
         koi string nahi hai, toh empty string return karo.
        */
        if (strs == null || strs.length == 0) {
            return "";
        }

        /*
         First string ko starting common prefix
         maan lo.
        */
        String prefix = strs[0];

        /*
         Array ki second string se comparison
         start karo.
        */
        for (int i = 1; i < strs.length; i++) {

            /*
             Jab tak current string prefix se start
             nahi hoti, prefix ko chhota karte raho.
            */
            while (!strs[i].startsWith(prefix)) {

                /*
                 Prefix ka last character remove karo.
                */
                prefix =
                        prefix.substring(0, prefix.length() - 1);

                /*
                 Agar prefix empty ho gaya,
                 toh koi common prefix available nahi hai.
                */
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }

        /*
         Sabhi strings ka longest common prefix
         return karo.
        */
        return prefix;
    }

    public static void main(String[] args) {

        String[] strs = {
                "flower",
                "flow",
                "flight"
        };

        String result = longestCommonPrefix(strs);

        System.out.print("Strings: ");

        for (String word : strs) {
            System.out.print(word + " ");
        }

        System.out.println();
        System.out.println(
                "Longest Common Prefix: " + result
        );
    }
}