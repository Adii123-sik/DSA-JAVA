package Strings.Easy;

/*
Problem: Reverse String
LeetCode: 344
Difficulty: Easy
Main Topic: String / Two Pointers
Optimized Pattern: Two Pointer Swapping

Approach:
Hume characters ka ek array diya gaya hai.

Hume is character array ko reverse karna hai.

Important condition:

Character array ko in-place reverse karna hai.

Iska matlab:

Hume koi extra character array create nahi karna.

Example:

Input:

s = {'h', 'e', 'l', 'l', 'o'}

Output:

s = {'o', 'l', 'l', 'e', 'h'}

Hum two pointers ka use karenge.

Ek pointer array ke starting position par hoga:

start = 0

Dusra pointer array ke last position par hoga:

end = s.length - 1

Uske baad start aur end position ke characters
ko swap karenge.

Example:

Initial array:

h e l l o

start = h
end = o

Swap karne ke baad:

o e l l h

Ab dono pointers ko array ke center ki taraf
move karenge.

start++
end--

Next characters:

e aur l

Swap karne ke baad:

o l l e h

Jab start pointer end pointer ke equal ya
uske aage pahunch jayega, array completely
reverse ho chuka hoga.

Example 1:

Input:
s = {'h', 'e', 'l', 'l', 'o'}

Output:
{'o', 'l', 'l', 'e', 'h'}

Example 2:

Input:
s = {'H', 'a', 'n', 'n', 'a', 'h'}

Output:
{'h', 'a', 'n', 'n', 'a', 'H'}

Variables:

start:
Array ke starting character ka index store karta hai.

end:
Array ke ending character ka index store karta hai.

temp:
Swapping ke samay ek character temporarily
store karta hai.

Time Complexity: O(n)

Array ke lagbhag n / 2 characters ko swap karte hain.

Space Complexity: O(1)

Koi extra array ya data structure use nahi kiya gaya.
*/

public class LC344_ReverseString {

    public static void reverseString(char[] s) {

        /*
         Start pointer ko array ke first index
         par rakho.
        */
        int start = 0;

        /*
         End pointer ko array ke last index
         par rakho.
        */
        int end = s.length - 1;

        /*
         Jab tak start pointer end pointer se
         chhota hai, characters swap karte raho.
        */
        while (start < end) {

            /*
             Start position ke character ko
             temporarily store karo.
            */
            char temp = s[start];

            /*
             End position ke character ko
             start position par rakho.
            */
            s[start] = s[end];

            /*
             Temporarily stored character ko
             end position par rakho.
            */
            s[end] = temp;

            /*
             Start pointer ko right side move karo.
            */
            start++;

            /*
             End pointer ko left side move karo.
            */
            end--;
        }
    }

    public static void main(String[] args) {

        char[] s = {
                'h',
                'e',
                'l',
                'l',
                'o'
        };

        System.out.print("Original String: ");

        for (char character : s) {
            System.out.print(character);
        }

        reverseString(s);

        System.out.println();
        System.out.print("Reversed String: ");

        for (char character : s) {
            System.out.print(character);
        }
    }
}