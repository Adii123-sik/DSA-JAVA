package BitManupulation.Easy;

/*
Problem: Number of 1 Bits
LeetCode: 191
Difficulty: Easy
Main Topic: Bit Manipulation
Optimized Pattern: Brian Kernighan's Algorithm

Approach:
Hume ek 32-bit integer n diya gaya hai.

Hume n ki binary representation me present total
1 bits ko count karke return karna hai.

Binary representation me jo bit 1 hoti hai,
use set bit kehte hain.

Example:

n = 11

11 ka binary representation:

1011

Is binary representation me total 3 set bits hain.

Isliye output:

3

Simple Approach:

Hum number ki har bit ko check kar sakte hain.

Last bit check karne ke liye:

n & 1

use kiya ja sakta hai.

Agar result 1 hai, toh last bit set hai.

Uske baad unsigned right shift:

n = n >>> 1

karke next bit ko check kar sakte hain.

Lekin ye approach maximum 32 iterations karegi.

Optimized Approach:

Hum Brian Kernighan's Algorithm use karenge.

Formula:

n = n & (n - 1)

Ye operation n ki rightmost set bit ko remove
kar deta hai.

Har iteration me exactly ek set bit remove hoti hai.

Isliye jitni set bits hongi, loop utni hi baar chalega.

Example:

n = 12

12 ka binary:

1100

First iteration:

n     = 1100
n - 1 = 1011

1100 & 1011 = 1000

Rightmost set bit remove ho gayi.

Second iteration:

n     = 1000
n - 1 = 0111

1000 & 0111 = 0000

Ab n zero ho gaya.

Total removed set bits = 2

Output:

2

Example 1:

Input:
n = 11

Binary:

1011

Calculation:

1011 & 1010 = 1010
1010 & 1001 = 1000
1000 & 0111 = 0000

Total set bits = 3

Output:
3

Example 2:

Input:
n = 128

Binary:

10000000

Calculation:

10000000 & 01111111 = 00000000

Total set bits = 1

Output:
1

Example 3:

Input:
n = 2147483645

Binary representation me total 30 set bits hain.

Output:
30

Important Java Concept:

Java ka int signed 32-bit integer hota hai.

LeetCode input ko unsigned binary representation
ki tarah treat kar sakta hai.

Isliye simple approach me:

while (n > 0)

use nahi karna chahiye.

Agar most significant bit 1 hui, toh Java me n
negative represent ho sakta hai.

Optimized approach me hum:

while (n != 0)

use karenge.

Brian Kernighan's Algorithm negative integer ki
bit representation par bhi correctly work karta hai.

Variables:

n:
Current integer ko store karta hai.
Har iteration ke baad iski rightmost set bit
remove hoti hai.

count:
Number ki binary representation me present total
set bits ki count store karta hai.

Time Complexity: O(k)

Yahan k number of set bits hai.

Loop sirf utni baar chalega jitni binary
representation me 1 bits hongi.

Worst case me 32 iterations ho sakti hain.

Space Complexity: O(1)

Hum sirf ek fixed variable count use kar rahe hain.
*/

public class LC191_NumberOf1Bits {

    public static int hammingWeight(int n) {

        /*
         Binary representation me present total
         set bits ko store karne ke liye variable.
        */
        int count = 0;

        /*
         Jab tak n ke andar koi set bit present hai,
         loop ko continue karo.
        */
        while (n != 0) {

            /*
             n & (n - 1) n ki rightmost set bit ko
             remove kar deta hai.

             Example:

             n = 12

             1100 & 1011 = 1000
            */
            n = n & (n - 1);

            /*
             Har iteration me ek set bit remove hoti hai,
             isliye count ko 1 se increase karo.
            */
            count++;
        }

        return count;
    }

    public static void main(String[] args) {

        int n = 11;

        int result = hammingWeight(n);

        System.out.println("Number: " + n);
        System.out.println("Number of 1 Bits: " + result);
    }
}