package Strings.Easy;

/*
Problem: Valid Palindrome
LeetCode: 125
Difficulty: Easy
Main Topic: String / Two Pointers
Optimized Pattern: Two Pointer Technique

Approach:
Hume ek string s di gayi hai.

String ke andar:

- Uppercase letters ho sakte hain
- Lowercase letters ho sakte hain
- Numbers ho sakte hain
- Spaces ho sakte hain
- Special characters ho sakte hain

Hume sirf letters aur digits ko consider karna hai.

Spaces aur special characters ko ignore karna hai.

Uppercase aur lowercase letters ko same maana jayega.

Example:

'A' aur 'a' ko equal maana jayega.

Hum Two Pointer Technique use karenge.

Ek pointer string ke starting index par hoga:

left = 0

Dusra pointer string ke last index par hoga:

right = s.length() - 1

Sabse pehle left side se spaces aur special characters
skip karenge.

Uske baad right side se spaces aur special characters
skip karenge.

Phir left aur right characters ko lowercase me convert
karke compare karenge.

Agar dono characters equal nahi hain,
toh string palindrome nahi hai.

Isliye false return karenge.

Agar dono characters equal hain,
toh:

left ko ek step aage badhayenge.

right ko ek step peeche le jayenge.

Ye process tab tak chalega jab tak:

left < right

Agar saare characters successfully match ho jaate hain,
toh string valid palindrome hai.

Isliye true return karenge.

Example 1:
Input:
s = "A man, a plan, a canal: Panama"

Special characters aur spaces remove karne ke baad:

amanaplanacanalpanama

Reverse:

amanaplanacanalpanama

Dono same hain.

Output:
true

Example 2:
Input:
s = "race a car"

Special characters aur spaces remove karne ke baad:

raceacar

Reverse:

racaecar

Dono same nahi hain.

Output:
false

Variables:

left:
String ke starting side ke character ko track karta hai.

right:
String ke ending side ke character ko track karta hai.

leftChar:
Left side ke valid character ko lowercase me store karta hai.

rightChar:
Right side ke valid character ko lowercase me store karta hai.

Time Complexity: O(n)
Space Complexity: O(1)
*/

public class LC125_ValidPalindrome {

    public static boolean isPalindrome(String s) {

        int left = 0;
        int right = s.length() - 1;

        while (left < right) {

            /*
             Left side ke spaces aur special characters
             ko skip karo.
            */
            while (left < right
                    && !Character.isLetterOrDigit(s.charAt(left))) {

                left++;
            }

            /*
             Right side ke spaces aur special characters
             ko skip karo.
            */
            while (left < right
                    && !Character.isLetterOrDigit(s.charAt(right))) {

                right--;
            }

            /*
             Dono characters ko lowercase me convert karo,
             taaki uppercase aur lowercase ka difference
             ignore ho sake.
            */
            char leftChar =
                    Character.toLowerCase(s.charAt(left));

            char rightChar =
                    Character.toLowerCase(s.charAt(right));

            /*
             Agar left aur right characters equal nahi hain,
             toh string palindrome nahi hai.
            */
            if (leftChar != rightChar) {
                return false;
            }

            // Left pointer ko aage badhao
            left++;

            // Right pointer ko peeche le jao
            right--;
        }

        /*
         Agar saare characters successfully match ho gaye,
         toh string valid palindrome hai.
        */
        return true;
    }

    public static void main(String[] args) {

        String s = "A man, a plan, a canal: Panama";

        boolean result = isPalindrome(s);

        System.out.println("String: " + s);
        System.out.println("Is Valid Palindrome: " + result);
    }
}