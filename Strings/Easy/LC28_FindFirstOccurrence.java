package Strings.Easy;

/*
Problem: Find the Index of the First Occurrence in a String
LeetCode: 28
Difficulty: Easy
Main Topic: String / String Matching
Optimized Pattern: Brute Force String Matching

Approach:
Hume do strings di gayi hain:

1. haystack
2. needle

Hume haystack ke andar needle ka first occurrence
find karna hai.

Agar needle haystack ke andar mil jaata hai,
toh uska starting index return karna hai.

Agar needle haystack ke andar nahi milta,
toh -1 return karna hai.

Example:

haystack = "bsadutsab"
needle = "sad"

Indexes:

Index:       0 1 2 3 4 5 6 7 8
Character:   b s a d u t s a b

"sad" index 1 se start ho raha hai.

Isliye output:

1

Hum haystack ke har possible starting index se
needle ko match karne ki koshish karenge.

Ek pointer i haystack ke possible starting index
ko represent karega.

Ek pointer j needle ke characters ko track karega.

Har i ke liye:

j = 0 se matching start hogi.

Hum compare karenge:

haystack.charAt(i + j)

aur

needle.charAt(j)

Agar dono characters equal hain,
toh j ko ek step aage badhayenge.

Agar dono characters equal nahi hain,
toh while loop stop ho jayega aur next starting
index se matching try hogi.

Agar j needle ki length ke equal ho jaata hai,
toh iska matlab needle completely match ho gaya.

Us case me i return karenge.

Needle ko haystack me sirf index:

0 se n - m

tak hi check karna zaroori hai.

Example:

haystack length = 9
needle length = 3

n - m = 6

Possible starting indexes:

0, 1, 2, 3, 4, 5, 6

Index 7 ya 8 se 3 characters available nahi honge.

Example 1:
Input:

haystack = "sadbutsad"
needle = "sad"

"sad" sabse pehle index 0 se start hota hai.

Output:
0

Example 2:
Input:

haystack = "leetcode"
needle = "leeto"

"leeto" haystack ke andar nahi milta.

Output:
-1

Example 3:
Input:

haystack = "bsadutsab"
needle = "sad"

Matching:

i = 0

haystack[0] = 'b'
needle[0] = 's'

Characters equal nahi hain.

Next:

i = 1

haystack[1] = 's'
needle[0] = 's'

Match.

haystack[2] = 'a'
needle[1] = 'a'

Match.

haystack[3] = 'd'
needle[2] = 'd'

Match.

Needle completely match ho gaya.

Output:
1

Variables:

n:
Haystack string ki length ko store karta hai.

m:
Needle string ki length ko store karta hai.

i:
Haystack ke possible starting index ko track karta hai.

j:
Needle ke current character ko track karta hai.

Time Complexity:
O((n - m + 1) * m)

Worst Case:
O(n * m)

Space Complexity:
O(1)
*/

public class LC28_FindFirstOccurrence {

    public static int strStr(String haystack, String needle) {

        int n = haystack.length();
        int m = needle.length();

        /*
         Agar needle ki length haystack se badi hai,
         toh needle haystack ke andar kabhi nahi mil sakta.
        */
        if (m > n) {
            return -1;
        }

        /*
         Haystack ke har possible starting index se
         needle ko match karne ki koshish karo.

         Last possible starting index:

         n - m
        */
        for (int i = 0; i <= n - m; i++) {

            /*
             Har naye starting index ke liye
             needle ki matching index 0 se start hogi.
            */
            int j = 0;

            /*
             Jab tak needle ke saare characters check
             nahi ho jaate aur current characters equal hain,
             tab tak matching continue karo.
            */
            while (j < m
                    && haystack.charAt(i + j) == needle.charAt(j)) {

                j++;
            }

            /*
             Agar j needle ki length ke equal ho gaya,
             toh needle completely match ho gaya.

             Isliye haystack ka starting index i return karo.
            */
            if (j == m) {
                return i;
            }
        }

        /*
         Agar needle haystack ke andar kahin bhi
         nahi mila, toh -1 return karo.
        */
        return -1;
    }

    public static void main(String[] args) {

        String haystack = "bsadutsab";
        String needle = "sad";

        int result = strStr(haystack, needle);

        System.out.println("Haystack: " + haystack);
        System.out.println("Needle: " + needle);
        System.out.println("First Occurrence Index: " + result);
    }
}