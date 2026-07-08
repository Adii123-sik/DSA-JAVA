package Math.Easy;

/*
Problem: Palindrome Number
LeetCode: 9
Difficulty: Easy
Main Topic: Math
Optimized Pattern: Reverse Half Number

Approach:
Hume check karna hai ki number palindrome hai ya nahi.
Palindrome number same hota hai left to right aur right to left.

Negative number kabhi palindrome nahi hota.
Agar number 10 se divisible hai aur number 0 nahi hai, to bhi palindrome nahi ho sakta.
Example: 10, 100

Optimized approach me hum poora number reverse nahi karte.
Sirf number ka half part reverse karte hain.

Example:
x = 1221
reverseHalf = 12
remaining x = 12
Dono equal hain, so palindrome.

Why Reverse Half Number?
Agar poora number reverse karenge to integer overflow ka risk ho sakta hai.
Half reverse karna safer aur optimized hai.

Time Complexity: O(log n)
Space Complexity: O(1)
*/

import java.util.Scanner;

public class LC009_PalindromeNumber {
    public static boolean isPalindrome(int x) {

        boolean isPalindrom = true;

        int reverse = 0;
        int num = x;

        while (num > 0) {

            int lastDigit = num % 10;
            reverse = reverse * 10 + lastDigit;
            num = num / 10;

        }

        if (x == reverse) {
            isPalindrom = true;
        } else {
            isPalindrom = false;
        }
        return isPalindrom;

    }

    public static void main(String[] args) {
        System.out.println("enter the value of n");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        System.out.println(isPalindrome(n));

    }
}
