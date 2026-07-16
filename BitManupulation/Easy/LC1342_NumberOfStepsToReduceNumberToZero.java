package BitManupulation.Easy;

/*
Problem: Number of Steps to Reduce a Number to Zero
LeetCode: 1342
Difficulty: Easy
Main Topic: Bit Manipulation
Optimized Pattern: Odd/Even Check + Right Shift + XOR

Approach:
Hume ek non-negative integer num diya gaya hai.

Hume num ko zero banana hai aur count karna hai ki
zero banane me total kitne steps lagenge.

Rules:

1. Agar num even hai, toh num ko 2 se divide karo.

2. Agar num odd hai, toh num me se 1 subtract karo.

3. Ye process tab tak repeat karo jab tak num zero
   nahi ho jaata.

Bit Manipulation:

Even number check karne ke liye normally:

num % 2 == 0

use kar sakte hain.

Agar num even hai, toh 2 se divide karne ke liye
right shift operator use karenge:

num = num >> 1

Right shift by 1 kisi positive integer ko 2 se
divide karne ke equal hota hai.

Example:

14 ka binary:

1110

Right shift karne ke baad:

0111

Jo decimal me 7 hai.

14 / 2 = 7

Agar num odd hai, toh usme se 1 subtract karna hai.

Odd number ki binary representation ki last bit
hamesha 1 hoti hai.

XOR with 1:

num = num ^ 1

last bit ko 1 se 0 kar deta hai.

Ye odd number me se 1 subtract karne ke equal hai.

Example:

7 ka binary:

111

7 ^ 1:

111
001
---
110

110 decimal me 6 hai.

Isliye:

7 ^ 1 = 6

Example 1:

Input:
num = 14

Calculation:

14 even → 14 >> 1 = 7
7 odd   → 7 ^ 1 = 6
6 even  → 6 >> 1 = 3
3 odd   → 3 ^ 1 = 2
2 even  → 2 >> 1 = 1
1 odd   → 1 ^ 1 = 0

Total steps = 6

Output:
6

Example 2:

Input:
num = 8

Calculation:

8 even → 8 >> 1 = 4
4 even → 4 >> 1 = 2
2 even → 2 >> 1 = 1
1 odd  → 1 ^ 1 = 0

Total steps = 4

Output:
4

Example 3:

Input:
num = 0

Number already zero hai.

Total steps = 0

Output:
0

Variables:

num:
Current number ko store karta hai.
Har operation ke baad num update hota hai.

steps:
Number ko zero banane ke liye perform kiye gaye
total operations ki count store karta hai.

Time Complexity: O(log num)

Har right shift number ko approximately half kar deta hai.

Space Complexity: O(1)

Hum sirf ek fixed variable steps use kar rahe hain.
*/

public class LC1342_NumberOfStepsToReduceNumberToZero {

    public static int numberOfSteps(int num) {

        /*
         Number ko zero banane me lage total steps
         store karne ke liye variable.
        */
        int steps = 0;

        /*
         Jab tak num zero nahi ho jaata,
         operations perform karte raho.
        */
        while (num > 0) {

            /*
             Agar num even hai, toh right shift karke
             use 2 se divide karo.
            */
            if (num % 2 == 0) {

                num = num >> 1;

            } else {

                /*
                 Odd number ki last bit 1 hoti hai.

                 XOR with 1 last bit ko 0 kar dega,
                 jo odd number me se 1 subtract karne
                 ke equal hai.
                */
                num = num ^ 1;
            }

            /*
             Har operation ke baad steps ko
             1 se increase karo.
            */
            steps++;
        }

        return steps;
    }

    public static void main(String[] args) {

        int num = 14;

        int result = numberOfSteps(num);

        System.out.println("Number: " + num);
        System.out.println("Steps required: " + result);
    }
}