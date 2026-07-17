package Strings.Easy;

/*
Problem: Is Subsequence
LeetCode: 392
Difficulty: Easy
Main Topic: String / Two Pointers
Optimized Pattern: Two Pointer Traversal

Approach:
Hume do strings s aur t di gayi hain.

Hume check karna hai ki string s, string t ki
subsequence hai ya nahi.

Subsequence ka matlab:

String s ke saare characters string t me same
order me present hone chahiye.

Characters ke beech extra characters aa sakte hain,
lekin order change nahi hona chahiye.

Example:

s = "abc"
t = "ahbgdc"

String t me characters is order me milte hain:

a -> b -> c

Isliye s, t ki subsequence hai.

Output:

true

Important:

Characters continuous hona zaroori nahi hai.

Example:

s = "abc"
t = "a12b34c"

Yahan a, b aur c ke beech extra characters hain,
lekin order same hai.

Isliye output true hoga.

Two Pointer Approach:

Hum ek pointer currentOfS use karenge.

currentOfS:
String s ke current character ka index track karega.

String t ko start se end tak traverse karenge.

Har character par check karenge:

s.charAt(currentOfS) == t.charAt(i)

Agar characters match karte hain, toh currentOfS
ko ek position aage badha denge.

Agar characters match nahi karte, toh string t ka
current character ignore kar denge.

String t ka traversal har iteration me aage badhega.

End me agar:

currentOfS == s.length()

ho gaya, iska matlab string s ke saare characters
same order me string t ke andar mil gaye hain.

Isliye true return karenge.

Example 1:

Input:

s = "abc"
t = "ahbgdc"

Traversal:

s ka current character = a

t ka character = a
Match mila.
currentOfS = 1

Ab s ka current character = b

t ka character = h
Match nahi mila.

t ka character = b
Match mila.
currentOfS = 2

Ab s ka current character = c

t ka character = g
Match nahi mila.

t ka character = d
Match nahi mila.

t ka character = c
Match mila.
currentOfS = 3

s.length() bhi 3 hai.

Output:

true

Example 2:

Input:

s = "axc"
t = "ahbgdc"

Traversal:

a match ho jaata hai.

Uske baad x, string t me nahi milta.

Isliye s ke saare characters match nahi hote.

Output:

false

Example 3:

Input:

s = "abc"
t = "cxyanb"

Required order:

a -> b -> c

String t me c, a aur b se pehle present hai.

Starting wala c ignore ho jayega.

a aur b match hone ke baad koi c present nahi hai.

Output:

false

Example 4:

Input:

s = ""
t = "ahbgdc"

Empty string har string ki subsequence hoti hai.

currentOfS = 0
s.length() = 0

Output:

true

Variables:

s:
String jise subsequence ke roop me check karna hai.

t:
Main string jiske andar s ke characters ko same
order me search karna hai.

currentOfS:
String s ke current character ka index track karta
hai.

i:
String t ko traverse karne ke liye loop variable.

Time Complexity: O(n)

Yahan n, string t ki length hai.

Hum string t ko maximum ek baar traverse karte hain.

Space Complexity: O(1)

Hum sirf fixed variables currentOfS aur i use
kar rahe hain.

Koi extra array ya data structure use nahi kiya
gaya hai.
*/

public class LC392_IsSubsequence {

    public static boolean isSubsequence(String s, String t) {

        /*
         String s ke current character ka index
         track karne ke liye pointer.
        */
        int currentOfS = 0;

        /*
         String t ko start se end tak traverse
         karenge.
        */
        for (int i = 0; i < t.length(); i++) {

            /*
             currentOfS < s.length() condition
             StringIndexOutOfBoundsException se
             protect karti hai.

             Agar s aur t ke current characters
             match karte hain, toh s ke pointer
             ko aage badha denge.
            */
            if (currentOfS < s.length()
                    && s.charAt(currentOfS) == t.charAt(i)) {

                currentOfS++;
            }
        }

        /*
         Agar currentOfS string s ki length ke
         equal hai, toh s ke saare characters
         same order me t ke andar mil gaye hain.
        */
        return currentOfS == s.length();
    }

    public static void main(String[] args) {

        String s = "abc";
        String t = "ahbgdc";

        boolean result = isSubsequence(s, t);

        System.out.println("String s: " + s);
        System.out.println("String t: " + t);
        System.out.println("Is Subsequence: " + result);
    }
}