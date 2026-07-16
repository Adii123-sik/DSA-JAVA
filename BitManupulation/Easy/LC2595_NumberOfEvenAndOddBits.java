package BitManupulation.Easy;

import java.util.Arrays;

/*
Problem: Number of Even and Odd Bits
LeetCode: 2595
Difficulty: Easy
Main Topic: Bit Manipulation
Optimized Pattern: Last Bit Check + Right Shift

Approach:
Hume ek positive integer n diya gaya hai.

Hume n ke binary representation me count karna hai:

1. Even indexes par kitni bits ki value 1 hai.
2. Odd indexes par kitni bits ki value 1 hai.

Binary representation ki indexing right side se start hoti hai.

Rightmost bit ka index 0 hota hai.

Example:

n = 17

17 ka binary representation:

Binary:  1 0 0 0 1
Index:   4 3 2 1 0

Index 0 par bit 1 hai.
Index 4 par bit 1 hai.

Dono indexes even hain.

Isliye:

evenCount = 2
oddCount = 0

Output:
[2, 0]

Current rightmost bit nikalne ke liye:

n & 1

use karenge.

Agar:

(n & 1) == 1

hai, toh current index par bit 1 present hai.

Uske baad current index even hai ya odd,
ye check karenge.

Index even check karne ke liye:

(index & 1) == 0

use karenge.

Agar index even hai, toh evenCount increase karenge.

Otherwise oddCount increase karenge.

Current bit process karne ke baad number ko ek position
right shift karenge:

n = n >> 1

Right shift karne se current last bit remove ho jaati hai
aur next bit rightmost position par aa jaati hai.

Har iteration ke baad index ko increase karenge.

Finally ek integer array return karenge:

[evenCount, oddCount]

Example 1:

Input:
n = 17

Binary:

Binary:  1 0 0 0 1
Index:   4 3 2 1 0

Index 0 par bit 1 hai.
Index 4 par bit 1 hai.

evenCount = 2
oddCount = 0

Output:
[2, 0]

Example 2:

Input:
n = 2

Binary:

Binary:  1 0
Index:   1 0

Index 1 par bit 1 hai.

evenCount = 0
oddCount = 1

Output:
[0, 1]

Variables:

evenCount:
Even indexes par present 1 bits ki total count
store karta hai.

oddCount:
Odd indexes par present 1 bits ki total count
store karta hai.

index:
Current binary bit ke index ko track karta hai.

lastBit:
Number ki current rightmost bit ko store karta hai.

answer:
evenCount aur oddCount ko integer array me store
karta hai.

Time Complexity: O(log n)

Number me jitni binary bits hongi,
loop utni baar chalega.

Space Complexity: O(1)

Hum fixed number of variables use kar rahe hain.
*/

public class LC2595_NumberOfEvenAndOddBits {

    public static int[] evenOddBit(int n) {

        /*
         Even indexes par present 1 bits ki count.
        */
        int evenCount = 0;

        /*
         Odd indexes par present 1 bits ki count.
        */
        int oddCount = 0;

        /*
         Binary indexing rightmost bit se start hoti hai.

         Isliye starting index 0 hoga.
        */
        int index = 0;

        /*
         Jab tak number me process karne ke liye
         bits available hain, loop chalao.
        */
        while (n > 0) {

            /*
             Current rightmost bit nikalo.

             Agar last bit 0 hai:
             n & 1 = 0

             Agar last bit 1 hai:
             n & 1 = 1
            */
            int lastBit = n & 1;

            /*
             Hume sirf un indexes ko count karna hai
             jahan bit ki value 1 hai.
            */
            if (lastBit == 1) {

                /*
                 Agar index & 1 ka result 0 hai,
                 toh current index even hai.
                */
                if ((index & 1) == 0) {

                    evenCount++;

                } else {

                    /*
                     Agar current index even nahi hai,
                     toh current index odd hai.
                    */
                    oddCount++;
                }
            }

            /*
             Number ko ek position right shift karo.

             Isse current last bit remove ho jaayegi
             aur next bit rightmost position par aa jaayegi.
            */
            n = n >> 1;

            /*
             Next binary bit ke liye index increase karo.
            */
            index++;
        }

        /*
         Index 0 par even bits ki count hogi.

         Index 1 par odd bits ki count hogi.
        */
        int[] answer = {evenCount, oddCount};

        return answer;
    }

    public static void main(String[] args) {

        int n = 17;

        /*
         Method call karke result array receive karo.
        */
        int[] result = evenOddBit(n);

        /*
         Original number aur final result print karo.
        */
        System.out.println("Number: " + n);

        System.out.println(
                "Binary Representation: "
                        + Integer.toBinaryString(n)
        );

        System.out.println(
                "Even and Odd Bits: "
                        + Arrays.toString(result)
        );
    }
}