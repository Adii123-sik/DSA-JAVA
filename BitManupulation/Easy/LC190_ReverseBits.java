package BitManupulation.Easy;

/*
Problem: Reverse Bits
LeetCode: 190
Difficulty: Easy
Main Topic: Bit Manipulation
Optimized Pattern: Extract Last Bit and Build Reversed Number

Approach:
Hume ek 32-bit integer diya gaya hai.

Hume us integer ke sabhi binary bits ko reverse
karna hai aur reversed integer return karna hai.

Example:

Input binary:

00000010100101000001111010011100

Bits ko reverse karne ke baad:

00111001011110000010100101000000

Input decimal:

43261596

Output decimal:

964176192

Hum given number ke bits ko right side se
ek-ek karke extract karenge.

Kisi number ka last bit nikalne ke liye:

n & 1

Use karte hain.

Example:

n ka last bit 1 hai:

n & 1 = 1

n ka last bit 0 hai:

n & 1 = 0

Ek variable answer maintain karenge.

Initially:

answer = 0

Har iteration mein answer ko ek position left
shift karenge:

answer = answer << 1

Left shift karne se answer mein naye bit ke liye
right side par ek empty position ban jayegi.

Uske baad extracted last bit ko answer mein add
karne ke liye bitwise OR operator use karenge:

answer = answer | lastBit

Isko ek hi statement mein bhi likh sakte hain:

answer = (answer << 1) | lastBit

Uske baad input number ko unsigned right shift
karenge:

n = n >>> 1

Java mein >>> unsigned right shift operator hai.

Ye left side mein hamesha 0 fill karta hai.

Is question mein >>> use karna important hai
kyunki input 32-bit signed integer ke form mein
negative bhi ho sakta hai.

Agar hum >> use karenge, toh negative number ke
case mein left side par 1 fill ho sakta hai.

Hume exactly 32 bits reverse karne hain.

Isliye loop 32 times chalegi.

Example:

Suppose last extracted bits hain:

1, 0, 1

Initially:

answer = 0

First bit:

answer = (0 << 1) | 1
answer = 1

Second bit:

answer = (1 << 1) | 0
answer = 2

Binary:

10

Third bit:

answer = (2 << 1) | 1
answer = 5

Binary:

101

Isi tarah sabhi 32 bits reverse order mein
answer ke andar store ho jayengi.

Important Bit Operations:

n & 1:
Number ka last bit extract karta hai.

answer << 1:
Answer ke bits ko ek position left move karta hai.

answer | lastBit:
Extracted bit ko answer mein insert karta hai.

n >>> 1:
Input number ko unsigned right shift karta hai.

Variables:

answer:
Reversed binary bits se banne wala final number
store karta hai.

lastBit:
Current number ka rightmost bit store karta hai.

i:
32 bits ko process karne ke liye loop counter hai.

Time Complexity: O(32)

Loop fixed 32 times chalti hai.

Isliye practical complexity:

O(1)

Space Complexity: O(1)

Koi extra array ya data structure use nahi kiya gaya.
*/

public class LC190_ReverseBits {

    public static int reverseBits(int n) {

        /*
         Reversed bits se banne wale final number
         ko store karne ke liye variable.
        */
        int answer = 0;

        /*
         Integer ke exactly 32 bits process karo.
        */
        for (int i = 0; i < 32; i++) {

            /*
             Input number ka rightmost bit extract karo.
            */
            int lastBit = n & 1;

            /*
             Answer ko ek position left shift karke
             extracted bit ko right side par add karo.
            */
            answer = (answer << 1) | lastBit;

            /*
             Input number ko unsigned right shift karo
             taaki next bit process ho sake.
            */
            n = n >>> 1;
        }

        /*
         Reversed bits se bana number return karo.
        */
        return answer;
    }

    public static void main(String[] args) {

        int n = 43261596;

        int result = reverseBits(n);

        System.out.println(
                "Original Number: " + n
        );

        System.out.println(
                "Reversed Bits Number: " + result
        );
    }
}