package Strings.Easy;

/*
Problem: Roman to Integer
LeetCode: 13
Difficulty: Easy
Main Topic: String / Hashing
Optimized Pattern: Current and Next Character Comparison

Approach:
Hume ek Roman numeral string s di gayi hai.

Roman numerals ke characters aur unki values:

I = 1
V = 5
X = 10
L = 50
C = 100
D = 500
M = 1000

Normally Roman numeral ki values left se right
add hoti hain.

Example:

VI = 5 + 1 = 6
XII = 10 + 1 + 1 = 12
MXII = 1000 + 10 + 1 + 1 = 1012

Lekin agar koi chhoti Roman value kisi badi Roman
value se pehle aati hai, toh chhoti value ko subtract
kiya jaata hai.

Example:

IV = 5 - 1 = 4
IX = 10 - 1 = 9
XL = 50 - 10 = 40
XC = 100 - 10 = 90
CD = 500 - 100 = 400
CM = 1000 - 100 = 900

Hum string ke har character ko uske next character
ke saath compare karenge.

Sabse pehle current Roman character ki integer value
nikalenge.

Uske baad check karenge ki next character available hai
ya nahi.

Agar next character available hai, toh uski bhi integer
value nikalenge.

Agar:

currentValue < nextValue

toh current value ko answer se subtract karenge.

Otherwise current value ko answer me add karenge.

String ka last character hamesha add hoga, kyunki uske
baad compare karne ke liye koi character nahi hota.

Roman character ko integer value me convert karne ke liye
getValue() helper method use kiya gaya hai.

Example 1:
Input:
s = "III"

Calculation:

I = 1
I = 1
I = 1

1 + 1 + 1 = 3

Output:
3

Example 2:
Input:
s = "LVIII"

Calculation:

L = 50
V = 5
I = 1
I = 1
I = 1

50 + 5 + 1 + 1 + 1 = 58

Output:
58

Example 3:
Input:
s = "MCMXCIV"

Calculation:

M = 1000
CM = 900
XC = 90
IV = 4

1000 + 900 + 90 + 4 = 1994

Output:
1994

Variables:

answer:
Roman numeral ki final integer value ko store karta hai.

i:
String ke current index ko track karta hai.

currentValue:
Current Roman character ki integer value ko store karta hai.

nextValue:
Next Roman character ki integer value ko store karta hai.

ch:
getValue() method me Roman character ko represent karta hai.

Time Complexity: O(n)
Space Complexity: O(1)
*/

public class LC13_RomanToInteger {

    public static int romanToInt(String s) {

        int answer = 0;

        /*
         String ke har Roman character ko process karo.
        */
        for (int i = 0; i < s.length(); i++) {

            /*
             Current Roman character ki integer value nikalo.
            */
            int currentValue = getValue(s.charAt(i));

            /*
             Check karo ki current character ke baad
             next character available hai ya nahi.
            */
            if (i + 1 < s.length()) {

                /*
                 Next Roman character ki integer value nikalo.
                */
                int nextValue = getValue(s.charAt(i + 1));

                /*
                 Agar current value next value se chhoti hai,
                 toh current value ko subtract karo.

                 Example:

                 IV

                 I = 1
                 V = 5

                 1 < 5

                 Isliye I ko subtract karenge.
                */
                if (currentValue < nextValue) {

                    answer = answer - currentValue;

                } else {

                    /*
                     Agar current value next value se chhoti
                     nahi hai, toh current value ko add karo.

                     Example:

                     VI

                     V = 5
                     I = 1

                     5 < 1 false hai.

                     Isliye V ko add karenge.
                    */
                    answer = answer + currentValue;
                }

            } else {

                /*
                 Last character ke baad koi next character
                 nahi hota.

                 Isliye last character ki value ko directly
                 answer me add karo.
                */
                answer = answer + currentValue;
            }
        }

        return answer;
    }

    /*
     Roman character ko uski integer value me convert
     karne ke liye helper method.
    */
    public static int getValue(char ch) {

        if (ch == 'I') {
            return 1;
        }

        if (ch == 'V') {
            return 5;
        }

        if (ch == 'X') {
            return 10;
        }

        if (ch == 'L') {
            return 50;
        }

        if (ch == 'C') {
            return 100;
        }

        if (ch == 'D') {
            return 500;
        }

        if (ch == 'M') {
            return 1000;
        }

        /*
         Agar invalid Roman character aaye,
         toh 0 return karo.
        */
        return 0;
    }

    public static void main(String[] args) {

        String s = "MCMXCIV";

        int result = romanToInt(s);

        System.out.println("Roman Number: " + s);
        System.out.println("Integer Value: " + result);
    }
}