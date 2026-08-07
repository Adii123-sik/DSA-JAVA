package Strings.Easy;

/*
Problem: Excel Sheet Column Title
LeetCode: 168
Difficulty: Easy
Main Topic: String
Optimized Pattern: Base-26 Conversion

Approach:
Hume ek integer columnNumber diya gaya hai.

Hume is number ko Excel sheet ke corresponding
column title me convert karke return karna hai.

Excel columns kuch is tarah represent hote hain:

1  -> A
2  -> B
3  -> C
...
26 -> Z
27 -> AA
28 -> AB
...
52 -> AZ
53 -> BA

Excel column system me total 26 letters hote hain:

A to Z

Normally base-26 conversion me digits:

0 to 25

hote hain.

Lekin Excel column numbering:

1 to 26

use karti hai.

Yahi is question ka main important point hai.

Isliye har iteration me sabse pehle:

columnNumber--

karenge.

Isse Excel ki 1-based indexing ko
0-based indexing me convert kar sakte hain.

Example:

1 -> 0 -> A
2 -> 1 -> B
3 -> 2 -> C
...
26 -> 25 -> Z

Ab current character ki position calculate
karne ke liye:

columnNumber % 26

use karenge.

Remainder ki value:

0 to 25

ke beech hogi.

Character calculate karne ke liye:

(char) ('A' + remainder)

use karenge.

Example:

'A' + 0  = A
'A' + 1  = B
'A' + 2  = C
...
'A' + 25 = Z

Current character calculate karne ke baad
remaining number ke liye:

columnNumber / 26

karenge.

Characters right se left calculate hote hain.

Isliye characters ko StringBuilder me append
karne ke baad final answer ko reverse karna
padega.


Example 1:
Input:

columnNumber = 1

Step:

columnNumber--

1 - 1 = 0

Remainder:

0 % 26 = 0

Character:

'A' + 0 = A

Output:
"A"


Example 2:
Input:

columnNumber = 28

First Iteration:

columnNumber--

28 - 1 = 27

Remainder:

27 % 26 = 1

Character:

'A' + 1 = B

StringBuilder:

"B"

Remaining Number:

27 / 26 = 1


Second Iteration:

columnNumber--

1 - 1 = 0

Remainder:

0 % 26 = 0

Character:

'A' + 0 = A

StringBuilder:

"BA"

Remaining Number:

0 / 26 = 0

Loop complete ho jayega.

StringBuilder me answer:

"BA"

Reverse karne ke baad:

"AB"

Output:
"AB"


Example 3:
Input:

columnNumber = 701

Output:
"ZY"


Variables:

columnNumber:
Excel column number ko store karta hai.

Har iteration ke baad ise divide karke
remaining number calculate kiya jata hai.

remainder:
Current character ki position ko store karta hai.

Iski value 0 se 25 ke beech hoti hai.

ch:
Current remainder ke corresponding Excel
column character ko store karta hai.

answer:
Calculated characters ko temporarily
reverse order me store karne ke liye
StringBuilder use kiya gaya hai.


Why columnNumber--?

Excel:

A = 1
B = 2
C = 3
...
Z = 26

Lekin character calculation:

'A' + 0 = A
'A' + 1 = B
'A' + 2 = C
...
'A' + 25 = Z

Isliye Excel ki:

1 to 26

range ko:

0 to 25

me convert karne ke liye har iteration me
1 subtract karna zaroori hai.


Time Complexity:
O(log26(columnNumber))

Har iteration me columnNumber approximately
26 se divide hota hai.

Isliye total iterations Excel column title
ke characters ke equal hoti hain.


Space Complexity:
O(log26(columnNumber))

Result ko store karne ke liye StringBuilder
use kiya gaya hai.

Final Excel title me jitne characters honge,
utni hi additional space required hogi.
*/

public class LC168_ExcelSheetColumnTitle {

    public static String convertToTitle(int columnNumber) {

        /*
         Excel column title ke characters ko
         temporarily reverse order me store karega.
        */
        StringBuilder answer = new StringBuilder();

        /*
         Loop tab tak chalega jab tak
         columnNumber 0 se greater hai.
        */
        while (columnNumber > 0) {

            /*
             Excel columns 1-based hote hain:

             A = 1
             B = 2
             ...
             Z = 26

             Lekin character calculation ke liye
             hume 0-based indexing chahiye:

             A = 0
             B = 1
             ...
             Z = 25

             Isliye 1 subtract karte hain.
            */
            columnNumber--;

            /*
             % 26 se current character ki
             position calculate hogi.

             0  -> A
             1  -> B
             2  -> C
             ...
             25 -> Z
            */
            int remainder = columnNumber % 26;

            /*
             Remainder ko corresponding
             alphabet character me convert karo.

             'A' + 0 = A
             'A' + 1 = B
             'A' + 2 = C
             ...
             'A' + 25 = Z
            */
            char ch = (char) ('A' + remainder);

            /*
             Current calculated character ko
             answer me add karo.
            */
            answer.append(ch);

            /*
             Current character process ho gaya.

             Ab remaining number ko process
             karne ke liye 26 se divide karo.
            */
            columnNumber = columnNumber / 26;
        }

        /*
         Characters right se left calculate hue hain.

         Example:

         28 ke liye StringBuilder me:

         "BA"

         store hoga.

         Reverse karne ke baad:

         "AB"

         final answer milega.
        */
        return answer.reverse().toString();
    }

    public static void main(String[] args) {

        int columnNumber = 28;

        String result = convertToTitle(columnNumber);

        System.out.println("Column Number: " + columnNumber);
        System.out.println("Excel Column Title: " + result);
    }
}