package BitManupulation.Easy;

/*
Problem: Power of Two
LeetCode: 231
Difficulty: Easy
Main Topic: Bit Manipulation
Optimized Pattern: n & (n - 1)

Approach:
Hume ek integer n diya gaya hai.

Hume check karna hai ki n, 2 ki power hai
ya nahi.

Kisi number ko power of two tab kaha jaata hai
jab use is form me likha ja sake:

n = 2^x

Yahan x ek non-negative integer hota hai.

Power of Two Numbers:

1  = 2^0
2  = 2^1
4  = 2^2
8  = 2^3
16 = 2^4
32 = 2^5

Binary Observation:

Power of two number ki binary representation me
sirf ek set bit hoti hai.

Examples:

1  = 0001
2  = 0010
4  = 0100
8  = 1000
16 = 10000

Bit Manipulation:

Hum following expression use karenge:

n & (n - 1)

Ye operation number ki rightmost set bit ko
remove kar deta hai.

Agar n power of two hai, toh usme sirf ek set bit
hogi.

Us set bit ko remove karne ke baad result zero
ho jayega.

Example:

n = 8

8 ka binary:

1000

n - 1 = 7

7 ka binary:

0111

AND operation:

1000
0111
----
0000

Result zero hai, isliye 8 power of two hai.

Example of Non-Power of Two:

n = 10

10 ka binary:

1010

n - 1 = 9

9 ka binary:

1001

AND operation:

1010
1001
----
1000

Result zero nahi hai, isliye 10 power of two
nahi hai.

Important Edge Case:

n = 0

Zero power of two nahi hota.

Lekin:

0 & (0 - 1)

ka result zero aa sakta hai.

Isliye condition me n > 0 check karna compulsory
hai.

Final Condition:

n > 0 && (n & (n - 1)) == 0

Example 1:

Input:
n = 1

Binary:
0001

Output:
true

Kyunki:

1 = 2^0

Example 2:

Input:
n = 16

Binary:
10000

Calculation:

10000 & 01111 = 00000

Output:
true

Example 3:

Input:
n = 3

Binary:
0011

Calculation:

0011 & 0010 = 0010

Result zero nahi hai.

Output:
false

Example 4:

Input:
n = 0

Zero power of two nahi hai.

Output:
false

Variable:

n:
Input integer jise check karna hai ki woh power
of two hai ya nahi.

Time Complexity: O(1)

Hum sirf ek bitwise AND operation aur comparison
perform kar rahe hain.

Space Complexity: O(1)

Koi extra data structure use nahi kiya gaya hai.
*/

public class LC231_PowerOfTwo {

    public static boolean isPowerOfTwo(int n) {

        /*
         Power of two number positive hota hai aur
         uski binary representation me sirf ek
         set bit hoti hai.

         n & (n - 1) us set bit ko remove karke
         result zero kar deta hai.
        */
        return n > 0 && (n & (n - 1)) == 0;
    }

    public static void main(String[] args) {

        int n = 16;

        boolean result = isPowerOfTwo(n);

        System.out.println("Number: " + n);
        System.out.println("Is Power of Two: " + result);
    }
}