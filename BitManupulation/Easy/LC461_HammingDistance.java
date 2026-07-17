package BitManupulation.Easy;

/*
Problem: Hamming Distance
LeetCode: 461
Difficulty: Easy
Main Topic: Bit Manipulation
Optimized Pattern: XOR + Brian Kernighan's Algorithm

Approach:
Hume do integers x aur y diye gaye hain.

Hume count karna hai ki x aur y ki binary
representation me kitni positions par bits
different hain.

Do numbers ki binary representation me different
bit positions ki total count ko Hamming Distance
kehte hain.

XOR Concept:

XOR operator same bits ke liye 0 return karta hai
aur different bits ke liye 1 return karta hai.

XOR Rules:

0 ^ 0 = 0
1 ^ 1 = 0

0 ^ 1 = 1
1 ^ 0 = 1

Isliye x aur y ka XOR karne ke baad result me
sirf unhi positions par 1 present hoga jahan
x aur y ki bits different hongi.

Formula:

difference = x ^ y

Ab hume difference ki binary representation me
present total set bits count karni hain.

Set bits count karne ke liye Brian Kernighan's
Algorithm use karenge.

Formula:

difference = difference & (difference - 1)

Ye operation difference ki rightmost set bit ko
remove kar deta hai.

Har iteration me ek set bit remove hogi.

Jitni baar loop chalega, utni hi different bit
positions hongi.

Example 1:

Input:

x = 1
y = 4

Binary:

1 = 001
4 = 100

XOR:

  001
^ 100
-----
  101

XOR result 101 me total 2 set bits hain.

Isliye Hamming Distance:

2

Output:

2

Example 2:

Input:

x = 35
y = 10

Binary:

35 = 100011
10 = 001010

XOR:

  100011
^ 001010
--------
  101001

XOR result 101001 me total 3 set bits hain.

Calculation:

101001 & 101000 = 101000

101000 & 100111 = 100000

100000 & 011111 = 000000

Total 3 set bits remove hui hain.

Isliye Hamming Distance:

3

Output:

3

Example 3:

Input:

x = 3
y = 1

Binary:

3 = 0011
1 = 0001

XOR:

  0011
^ 0001
------
  0010

XOR result me sirf 1 set bit hai.

Output:

1

Variables:

difference:
x aur y ka XOR result store karta hai.

Isme unhi positions par 1 hota hai jahan
x aur y ki bits different hoti hain.

count:
Total different bit positions ki count store
karta hai.

Time Complexity: O(k)

Yahan k, x aur y ke beech different bits ki
total count hai.

Loop sirf utni baar chalta hai jitni set bits
XOR result me present hoti hain.

Worst case me maximum 32 iterations ho sakti hain.

Space Complexity: O(1)

Hum sirf fixed variables difference aur count
use kar rahe hain.
*/

public class LC461_HammingDistance {

    public static int hammingDistance(int x, int y) {

        /*
         XOR same bits ko 0 aur different bits ko
         1 me convert karta hai.
        */
        int difference = x ^ y;

        /*
         Different bit positions ki total count
         store karne ke liye variable.
        */
        int count = 0;

        /*
         Jab tak XOR result me koi set bit present
         hai, loop continue hoga.
        */
        while (difference != 0) {

            /*
             difference & (difference - 1)
             rightmost set bit ko remove karta hai.
            */
            difference = difference & (difference - 1);

            /*
             Har removed set bit ek different bit
             position ko represent karti hai.
            */
            count++;
        }

        return count;
    }

    public static void main(String[] args) {

        int x = 35;
        int y = 10;

        int result = hammingDistance(x, y);

        System.out.println("First Number: " + x);
        System.out.println("Second Number: " + y);
        System.out.println("Hamming Distance: " + result);
    }
}